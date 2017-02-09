package com.nao20010128nao.Phosphorus.phar.events

import groovy.transform.Memoized

/**
 * Created by nao on 2017/02/09.
 */
class ManifestEvent implements PharParserEvent{
    final int manifestTotal
    final int filesInsidePhar
    final short pharApiVersion
    final int globalFlags
    final int pharAliasesLength
    final byte[] pharAliases
    final int pharMetadataLength
    final byte[] pharMetadata

    ManifestEvent(
            int manifestTotal,
            int filesInsidePhar,
            short pharApiVersion,
            int globalFlags,
            int pharAliasesLength,
            byte[] pharAliases,
            int pharMetadataLength,
            byte[] pharMetadata
    ){
        this.manifestTotal=manifestTotal
        this.filesInsidePhar=filesInsidePhar
        this.pharApiVersion=pharApiVersion
        this.globalFlags=globalFlags
        this.pharAliasesLength=pharAliasesLength
        this.pharAliases=pharAliases
        this.pharMetadataLength=pharMetadataLength
        this.pharMetadata=pharMetadata
    }

    @Memoized
    String getPharAliasesString(){
        new String(pharAliases,"UTF-8")
    }

    @Memoized
    String getPharMetadata(){
        new String(pharMetadata,"UTF-8")
    }

    int getId() {
        ID_MANIFEST
    }
}