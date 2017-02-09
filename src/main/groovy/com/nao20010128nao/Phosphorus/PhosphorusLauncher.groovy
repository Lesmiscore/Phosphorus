package com.nao20010128nao.Phosphorus

import com.nao20010128nao.Phosphorus.phar.PharParser
import com.nao20010128nao.Phosphorus.phar.events.FileManifestEvent
import com.nao20010128nao.Phosphorus.phar.events.StubEvent

String input=args.first()
def parser=new PharParser(new File(input))
try {
    parser.readAll()
} catch (e) {
    e.printStackTrace()
}

println ((parser.list[1] as StubEvent).stubString)
parser.each {event->
    println event.id
    if(event instanceof FileManifestEvent){
        println event.fileNameString
    }
}
