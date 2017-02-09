package com.nao20010128nao.Phosphorus.phar.events

import groovy.transform.Memoized

/**
 * Created by nao on 2017/02/09.
 */
class SignatureEvent implements PharParserEvent{
    final int hashSize
    final byte[] hash
    final int sigFlags

    SignatureEvent(
            int hashSize,
            byte[] hash,
            int sigFlags
    ){
        this.hashSize=hashSize
        this.hash=hash
        this.sigFlags=sigFlags
    }

    @Memoized
    boolean isMd5(){
        sigFlags&0x0001!=0
    }

    @Memoized
    boolean isSha1(){
        sigFlags&0x0002!=0
    }

    @Memoized
    boolean isValidMd5(){
        md5&hash.length==16
    }

    @Memoized
    boolean isValidSha1(){
        sha1&hash.length==20
    }

    int getId() {
        ID_SIGNATURE
    }
}
