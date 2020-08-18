package com.oexchain.web3j.tx;

import com.oexchain.web3j.OexchainWeb3j;
import com.oexchain.web3j.response.GetTransactionReceiptResult;
import com.oexchain.web3j.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;

import java.io.IOException;
import java.util.Optional;

public abstract class TransactionReceiptProcessor {

    protected OexchainWeb3j oexchainWeb3J;

    public abstract TransactionReceipt waitForTransactionReceipt(String transactionHash) throws IOException, TransactionException;

    Optional<TransactionReceipt> sendTransactionReceiptRequest(String transactionHash) throws IOException, TransactionException {
        GetTransactionReceiptResult getTransactionReceiptResult = oexchainWeb3J.getTransactionReceipt(transactionHash).send();
        if (getTransactionReceiptResult.hasError()) {
            throw new TransactionException("Error processing request: " + getTransactionReceiptResult.getError().getMessage());
        } else {
            return getTransactionReceiptResult.getReceipt();
        }
    }
}
