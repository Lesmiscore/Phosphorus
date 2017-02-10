package com.nao20010128nao.Phosphorus.phar.events

/**
 * Created by nao on 2017/02/09.
 */
interface PharParserEvent {
    static final int ID_UNKNOWN=-1
    static final int ID_BEGIN=0
    static final int ID_STUB=1
    static final int ID_MANIFEST=2
    static final int ID_FILE_MANIFEST=3
    static final int ID_RAW_FILE=4
    static final int ID_SIGNATURE=5
    static final int ID_SIGNATURE_VALIDATED=6
    static final int ID_EOF=7

    int getId()
}