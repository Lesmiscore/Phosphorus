package com.nao20010128nao.Phosphorus.phar.events

/**
 * Created by nao on 2017/02/10.
 */
class ErrorEvent extends Throwable implements PharParserEvent{
    ErrorEvent(Throwable cause) {
        super(cause)
    }
    int getId() {
        ID_UNKNOWN
    }
}
