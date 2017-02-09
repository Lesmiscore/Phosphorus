package com.nao20010128nao.Phosphorus.phar.events

/**
 * Created by nao on 2017/02/09.
 */
class RawFileEvent implements PharParserEvent{
    final byte[] raw
    final FileManifestEvent manifest

    RawFileEvent(
            byte[] raw,
            FileManifestEvent manifest
    ){
        this.raw=raw
        this.manifest=manifest
    }

    int getId() {
        ID_RAW_FILE
    }
}
