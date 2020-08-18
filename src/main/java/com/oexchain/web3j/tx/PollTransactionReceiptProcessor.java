package com.oexchain.web3j.tx;

import com.oexchain.web3j.OexchainWeb3j;
import com.oexchain.web3j.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;

import java.io.IOException;
import java.util.Optional;

public class PollTransactionReceiptProcessor extends TransactionReceiptProcessor {

    private final long sleepDuration;
    private final int attempts;

    public PollTransactionReceiptProcessor(OexchainWeb3j oexchainWeb3J) {
        this(oexchainWeb3J, 3000, 60);
    }

    public PollTransactionReceiptProcessor(OexchainWeb3j oexchainWeb3J, long sleepDuration, int attempts) {
        super.oexchainWeb3J = oexchainWeb3J;
        this.sleepDuration = sleepDuration;
        this.attempts = attempts;
    }

    @Override
    public TransactionReceipt waitForTransactionReceipt(String transactionHash) throws IOException, TransactionException {
        return getTransactionReceipt(transactionHash, sleepDuration, attempts);
    }

    private TransactionReceipt getTransactionReceipt(
            String transactionHash, long sleepDuration, int attempts)
            throws IOException, TransactionException {

        Optional<TransactionReceipt> transactionDetails = sendTransactionReceiptRequest(transactionHash);
        for (int i = 0; i < attempts; i++) {
            if (!transactionDetails.isPresent()) {
                try {
                    Thread.sleep(sleepDuration);
                } catch (InterruptedException e) {
                    throw new TransactionException(e);
                }
                transactionDetails = sendTransactionReceiptRequest(transactionHash);
            } else {
                return transactionDetails.get();
            }
        }
        throw new TransactionException("Transaction receipt was not generated after "
                + ((sleepDuration * attempts) / 1000
                + " seconds for transaction: " + transactionHash));
    }
}
