package com.nao20010128nao.Phosphorus.phar.events

import groovy.transform.Memoized

/**
 * Created by nao on 2017/02/09.
 */
class StubEvent implements PharParserEvent{
    final byte[] stub
    StubEvent(byte[] stub){
        this.stub=stub
    }

    @Memoized
    String getStubString(){
        new String(stub,"utf-8")
    }

    int getId() {
        ID_STUB
    }
}
