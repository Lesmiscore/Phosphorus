package com.nao20010128nao.Phosphorus.phar.events

/**
 * Created by nao on 2017/02/09.
 */
class SignatureValidatedEvent implements PharParserEvent{
    final SignatureEvent signature
    final boolean correct

    SignatureValidatedEvent(
            SignatureEvent signature,
            boolean correct
    ){
        this.signature=signature
        this.correct=correct
    }

    int getId() {
        ID_SIGNATURE_VALIDATED
    }
}
