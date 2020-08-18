package com.oexchain.web3j.response;

import org.web3j.protocol.core.Response;

public class SendTransactionResult extends Response<String> {

    public String getTransactionHash() {
        return getResult();
    }

}
