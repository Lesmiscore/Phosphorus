package com.nao20010128nao.Phosphorus.phar.events

import groovy.transform.Memoized

/**
 * Created by nao on 2017/02/09.
 */
class FileManifestEvent implements PharParserEvent{
    final int fileNameLength
    final byte[] fileName
    final int nonCompressedFileSize
    final int unixFileTimeStamp
    final int compressedFileSize
    final int crc32Checksum
    final int bitFlags
    final int fileMetadataLength
    final byte[] fileMetadata

    FileManifestEvent(
            int fileNameLength,
            byte[] fileName,
            int nonCompressedFileSize,
            int unixFileTimeStamp,
            int compressedFileSize,
            int crc32Checksum,
            int bitFlags,
            int fileMetadataLength,
            byte[] fileMetadata
    ){
        this.fileNameLength=fileNameLength
        this.fileName=fileName
        this.nonCompressedFileSize=nonCompressedFileSize
        this.unixFileTimeStamp=unixFileTimeStamp
        this.compressedFileSize=compressedFileSize
        this.crc32Checksum=crc32Checksum
        this.bitFlags=bitFlags
        this.fileMetadataLength=fileMetadataLength
        this.fileMetadata=fileMetadata
    }

    @Memoized
    String getFileNameString(){
        new String(fileName,"UTF-8")
    }

    @Memoized
    String getFileMetadataString(){
        new String(fileMetadata,"UTF-8")
    }

    @Memoized
    int getFilePermission(){
        bitFlags&0x000001FF
    }

    @Memoized
    boolean isNotCompressed(){
        !(zlibCompressed|bzipCompressed)
    }

    @Memoized
    boolean isZlibCompressed(){
        (bitFlags&0x00001000)!=0
    }

    @Memoized
    boolean isBzipCompressed(){
        (bitFlags&0x00002000)!=0
    }

    int getId() {
        ID_FILE_MANIFEST
    }
}
