package com.nao20010128nao.Phosphorus

import com.nao20010128nao.Phosphorus.phar.PharParser
import com.nao20010128nao.Phosphorus.phar.events.RawFileEvent
import com.nao20010128nao.Phosphorus.phar.events.StubEvent
import joptsimple.OptionParser
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream

import java.util.regex.Pattern
import java.util.zip.Inflater
import java.util.zip.InflaterInputStream

OptionParser opt=new OptionParser()
opt.accepts("input").withRequiredArg()
opt.accepts("output").withOptionalArg()
opt.accepts("stub").withOptionalArg()
opt.accepts("check")
def result=opt.parse(args)

File input,output,stub

if(!result.has("input")){
    println "input argument is required."
    println "Usage:"
    println "--input=(filename) - Input file name (full path) of the PHAR file. (required)"
    println "--output=(dirname) - Output directory to save extracted result (default is input+\"_extracted\")"
    println "--stub=(filename) - Relative path from output to save stub file (default is null, and never save)"
    println "--check - Check the input from command line, and never save any file"
    System.exit 1
    return
}else{
    input=new File(result.valueOf("input").toString()).absoluteFile
    println "IN: $input"
}
if(!result.has("output")){
    output=new File(input.parentFile,input.absolutePath.split(Pattern.quote(File.separator)).last()+"_extracted")
}else{
    output=new File(result.valueOf("output").toString()).absoluteFile
}
println "OUT: $output"

if(!result.has("stub")){
    stub=null//do not export stub
}else{
    stub=new File(output,result.valueOf("stub").toString()).absoluteFile
    println "STUB: $stub"
}

if(result.has("check")){
    System.exit 0
}

println "Parsing PHAR file..."

def parser=new PharParser(input)
try {
    parser.readAll()
} catch (e) {
    e.printStackTrace()
}

println "Extracting..."

boolean extractedStub=false
int extractedCount=0

parser.startReading {event->
    if(event instanceof StubEvent & stub!=null & !extractedStub){
        println "Extracting stub"
        stub.parentFile.mkdirs()
        stub.bytes= (event as StubEvent).stub
        extractedStub=true
    }
    if(event instanceof RawFileEvent){
        def decompress={RawFileEvent ev->
            def manifest=ev.manifest
            def raw=ev.raw
            if(manifest.notCompressed){
                return raw
            }else if(manifest.zlibCompressed){
                return new InflaterInputStream(new ByteArrayInputStream(raw),new Inflater(true)).bytes
            }else if(manifest.bzipCompressed){
                return new BZip2CompressorInputStream(new ByteArrayInputStream(raw),true).bytes
            }
        }
        println "Extract: ${event.manifest.fileNameString}"
        File dest=new File(output,event.manifest.fileNameString)
        dest.parentFile.mkdirs()
        dest.bytes=decompress(event)
        extractedCount++
    }
}

println "Extracted $extractedCount files${extractedStub?" with a stub":""}"
println "Done"
