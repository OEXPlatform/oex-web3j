package com.oexchain.web3j.tx;

import com.oexchain.web3j.OexchainWeb3j;
import com.oexchain.web3j.constant.ActionType;
import com.oexchain.web3j.constant.ChainId;
import com.oexchain.web3j.payload.PayloadProvider;
import com.oexchain.web3j.request.CallTransaction;
import com.oexchain.web3j.response.CallResult;
import com.oexchain.web3j.response.SendTransactionResult;
import com.oexchain.web3j.response.TransactionReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class TransactionManager {

    private Logger logger = LoggerFactory.getLogger(TransactionManager.class);

    private OexchainWeb3j oexchainWeb3J;
    private TransactionReceiptProcessor transactionReceiptProcessor;
    private FeePayer feePayer;
    private Credentials credentials;
    private GasProvider oexGasProvider = new GasProvider();
    private int chainId;

    private TransactionManager(OexchainWeb3j oexchainWeb3J, TransactionReceiptProcessor transactionReceiptProcessor, FeePayer feePayer, Credentials credentials, GasProvider oexGasProvider, int chainId) {
        this.oexchainWeb3J = oexchainWeb3J;
        this.transactionReceiptProcessor = transactionReceiptProcessor;
        this.feePayer = feePayer;
        this.credentials = credentials;
        this.oexGasProvider = oexGasProvider;
        this.chainId = chainId;
    }

    /**
     * 发起合约交易
     *
     * @param transaction
     * @param function
     * @return
     * @throws IOException
     * @throws TransactionException
     */
    public TransactionReceipt sendContractTransaction(Transaction transaction, Function function) throws IOException, TransactionException {
        transaction.setActionType(ActionType.CALL_CONTRACT);
        return sendRawTransaction(transaction, Numeric.hexStringToByteArray(FunctionEncoder.encode(function)));
    }

    /**
     * 发起普通交易
     *
     * @param transaction
     * @param payload       {@link PayloadProvider}
     * @return
     * @throws IOException
     * @throws TransactionException
     */
    public TransactionReceipt sendRawTransaction(Transaction transaction, byte[] payload) throws IOException, TransactionException {
        transaction.setNonce(getNonce(transaction.getAccountName()));
        transaction.setGasLimit(oexGasProvider.getGasLimit());
        transaction.setGasPrice(oexGasProvider.getGasPrice());
        transaction.setPayload(payload);
        String message = Numeric.toHexString(TransactionEncoder.signMessage(transaction, chainId, credentials, feePayer, false));
        SendTransactionResult sendTransactionResult = oexchainWeb3J.sendRawTransaction(message).send();
        logger.debug("TransactionHash: {}", sendTransactionResult.getTransactionHash());
        return transactionReceiptProcessor.waitForTransactionReceipt(sendTransactionResult.getTransactionHash());
    }

    /**
     * 发起普通交易，由父账号签名
     *
     * @param transaction
     * @param payload       {@link PayloadProvider}
     * @return
     * @throws IOException
     * @throws TransactionException
     */
    public TransactionReceipt sendRawTransactionByFatherAccount(Transaction transaction, byte[] payload) throws IOException, TransactionException {
        transaction.setNonce(getNonce(transaction.getAccountName()));
        transaction.setGasLimit(oexGasProvider.getGasLimit());
        transaction.setGasPrice(oexGasProvider.getGasPrice());
        transaction.setPayload(payload);
        String message = Numeric.toHexString(TransactionEncoder.signMessage(transaction, chainId, credentials, feePayer, true));
        SendTransactionResult sendTransactionResult = oexchainWeb3J.sendRawTransaction(message).send();
        logger.debug("TransactionHash: {}", sendTransactionResult.getTransactionHash());
        return transactionReceiptProcessor.waitForTransactionReceipt(sendTransactionResult.getTransactionHash());
    }
    /**
     * @param callTransaction
     * @param function
     * @return
     * @throws IOException
     */
    public List<Type> call(CallTransaction callTransaction, Function function) throws IOException {
        callTransaction.setActionType(ActionType.CALL_CONTRACT);
        callTransaction.setAssetId(BigInteger.ZERO);
        callTransaction.setValue(BigInteger.ZERO);
        callTransaction.setData(FunctionEncoder.encode(function));
        CallResult callResult = oexchainWeb3J.call(callTransaction).send();
        String result = callResult.getResult();
        return FunctionReturnDecoder.decode(result, function.getOutputParameters());
    }

    protected BigInteger getNonce(String accountName) throws IOException {
        return oexchainWeb3J.getNonce(accountName).send().getNonce();
    }


    public static class Builder {
        private OexchainWeb3j oexchainWeb3J;
        private TransactionReceiptProcessor transactionReceiptProcessor;
        private FeePayer feePayer;
        private Credentials credentials;
        private GasProvider oexGasProvider;
        private int chainId;

        public Builder oexchainWeb3j(OexchainWeb3j oexchainWeb3J) {
            this.oexchainWeb3J = oexchainWeb3J;
            return this;
        }

        public Builder transactionReceiptProcessor(TransactionReceiptProcessor transactionReceiptProcessor) {
            this.transactionReceiptProcessor = transactionReceiptProcessor;
            return this;
        }

        public Builder feePayer(FeePayer feePayer) {
            this.feePayer = feePayer;
            return this;
        }

        public Builder credentials(Credentials credentials) {
            this.credentials = credentials;
            return this;
        }

        public Builder gasProvider(GasProvider oexGasProvider) {
            this.oexGasProvider = oexGasProvider;
            return this;
        }

        public Builder chainId(int chainId) {
            this.chainId = chainId;
            return this;
        }

        public TransactionManager build() {
            if (transactionReceiptProcessor == null) {
                transactionReceiptProcessor = new PollTransactionReceiptProcessor(oexchainWeb3J);
            }
            if (oexGasProvider == null) {
                oexGasProvider = new GasProvider();
            }
            if (chainId == 0) {
                chainId = ChainId.TEST;
            }
            return new TransactionManager(oexchainWeb3J, transactionReceiptProcessor, feePayer, credentials, oexGasProvider, chainId);
        }

    }

}
