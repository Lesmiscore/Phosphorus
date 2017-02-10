package com.nao20010128nao.Phosphorus.phar

import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Created by nao on 2017/02/09.
 */
class LocalFileReader implements Closeable{
    final File f
    final DataInputStream fis
    LocalFileReader(File f){
        fis=(this.f=f).newDataInputStream()
    }

    byte get(){
        fis.read()
    }

    void get(byte[] a){
        fis.readFully(a)
    }

    void skip(int amount){
        fis.skipBytes(amount)
    }

    int remaining(){
        fis.available()
    }

    void close() throws IOException {
        fis.close()
    }

    int getInt(){
        byte[] buffer=new byte[4]
        get(buffer)
        ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).int
    }
    int getLeInt(){
        byte[] buffer=new byte[4]
        get(buffer)
        ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN).int
    }
    short getShort(){
        byte[] buffer=new byte[2]
        get(buffer)
        ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).short
    }
}
