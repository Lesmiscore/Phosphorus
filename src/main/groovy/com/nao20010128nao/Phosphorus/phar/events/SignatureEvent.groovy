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
        (sigFlags&0x0001)!=0
    }

    @Memoized
    boolean isSha1(){
        (sigFlags&0x0002)!=0
    }

    @Memoized
    boolean isSha256(){
        (sigFlags&0x0004)!=0
    }

    @Memoized
    boolean isSha512(){
        (sigFlags&0x0008)!=0
    }

    @Memoized
    boolean isValidMd5(){
        md5&hash.length==16
    }

    @Memoized
    boolean isValidSha1(){
        sha1&hash.length==20
    }

    @Memoized
    boolean isValidSha256(){
        sha256&hash.length==32
    }

    @Memoized
    boolean isValidSha512(){
        sha512&hash.length==64
    }

    @Memoized
    String getHashNameFromFlag(){
        if(md5)"md5"
        else if(sha1)"sha-1"
        else if(sha256)"sha-256"
        else if(sha512)"sha-512"
        else null
    }

    int getId() {
        ID_SIGNATURE
    }
}
