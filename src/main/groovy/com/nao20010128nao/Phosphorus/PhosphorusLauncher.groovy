package com.nao20010128nao.Phosphorus

import com.nao20010128nao.Phosphorus.phar.PharParser
import com.nao20010128nao.Phosphorus.phar.events.FileManifestEvent
import com.nao20010128nao.Phosphorus.phar.events.RawFileEvent
import com.nao20010128nao.Phosphorus.phar.events.StubEvent
import joptsimple.OptionParser

import java.util.regex.Pattern

OptionParser opt=new OptionParser()
opt.accepts("input").withRequiredArg()
opt.accepts("output")
opt.accepts("stub")
def result=opt.parse(args)

File input,output,stub

if(!result.has("input")){
    println "input argument is required. e.g.) --input=(filename)"
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

parser.each {event->
    if(event instanceof StubEvent & stub!=null & !extractedStub){
        println "Extracting stub"
        stub.parentFile.mkdirs()
        stub.bytes= (event as StubEvent).stub
        extractedStub=true
    }
    if(event instanceof RawFileEvent){
        println "Extract: ${event.manifest.fileNameString}"
        File dest=new File(output,event.manifest.fileNameString)
        dest.parentFile.mkdirs()
        dest.bytes=event.raw
        extractedCount++
    }
}

println "Extracted $extractedCount files${extractedStub?" with a stub":""}"
println "Done"
