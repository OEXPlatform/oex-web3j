package com.oexchain.web3j.response;

import org.web3j.protocol.core.Response;

import java.util.Optional;

public class GetTransactionReceiptResult extends Response<TransactionReceipt> {

    public Optional<TransactionReceipt> getReceipt() {
        return Optional.ofNullable(getResult());
    }

}
