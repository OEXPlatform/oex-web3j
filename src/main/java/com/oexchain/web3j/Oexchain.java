package com.oexchain.web3j;

import com.oexchain.web3j.request.CallTransaction;
import com.oexchain.web3j.response.*;
import org.web3j.protocol.core.Request;

public interface Oexchain {

    Request<?, CallResult> call(CallTransaction transaction);

    Request<?, NonceResult> getNonce(String accountName);

    Request<?, SendTransactionResult> sendRawTransaction(String transactionData);

    Request<?, GetTransactionReceiptResult> getTransactionReceipt(String transactionHash);

    Request<?, SendTransactionResult> createPendingTransactionFilter();

    Request<?, PendingTransactionResult> getFilterChanges(String filterId);

}
