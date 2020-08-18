package com.oexchain.web3j.response;

import org.web3j.protocol.core.Response;

import java.util.List;

public class PendingTransactionResult extends Response<List<String>> {

    public List<String> getPendingTransactionHashList() {
        return getResult();
    }

}
