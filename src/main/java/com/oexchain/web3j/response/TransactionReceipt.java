package com.oexchain.web3j.response;

import java.math.BigInteger;
import java.util.List;

public class TransactionReceipt {

    private String blockHash;
    private BigInteger blockNumber;
    private String txHash;
    private BigInteger transactionIndex;
    private String postState;
    private List<ActionResult> actionResults;
    private BigInteger cumulativeGasUsed;
    private BigInteger totalGasUsed;
    private String logsBloom;
    private List<Log> logs;

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(BigInteger blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public BigInteger getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(BigInteger transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public String getPostState() {
        return postState;
    }

    public void setPostState(String postState) {
        this.postState = postState;
    }

    public List<ActionResult> getActionResults() {
        return actionResults;
    }

    public void setActionResults(List<ActionResult> actionResults) {
        this.actionResults = actionResults;
    }

    public BigInteger getCumulativeGasUsed() {
        return cumulativeGasUsed;
    }

    public void setCumulativeGasUsed(BigInteger cumulativeGasUsed) {
        this.cumulativeGasUsed = cumulativeGasUsed;
    }

    public BigInteger getTotalGasUsed() {
        return totalGasUsed;
    }

    public void setTotalGasUsed(BigInteger totalGasUsed) {
        this.totalGasUsed = totalGasUsed;
    }

    public String getLogsBloom() {
        return logsBloom;
    }

    public void setLogsBloom(String logsBloom) {
        this.logsBloom = logsBloom;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "TransactionReceipt{" +
                "blockHash='" + blockHash + '\'' +
                ", blockNumber=" + blockNumber +
                ", txHash='" + txHash + '\'' +
                ", transactionIndex=" + transactionIndex +
                ", postState='" + postState + '\'' +
                ", actionResults=" + actionResults +
                ", cumulativeGasUsed=" + cumulativeGasUsed +
                ", totalGasUsed=" + totalGasUsed +
                ", logsBloom='" + logsBloom + '\'' +
                ", logs=" + logs +
                '}';
    }

}
