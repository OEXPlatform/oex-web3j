package com.oexchain.web3j.response;

import java.math.BigInteger;
import java.util.List;

public class Log {

    private String name;
    private List<String> topics;
    private String data;
    private BigInteger blockNumber;
    private String blockHash;
    private String transactionHash;
    private BigInteger logIndex;
    private BigInteger actionIndex;
    private BigInteger transactionIndex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigInteger getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(BigInteger blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    public String getTransactionHash() {
        return transactionHash;
    }

    public void setTransactionHash(String transactionHash) {
        this.transactionHash = transactionHash;
    }

    public BigInteger getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(BigInteger logIndex) {
        this.logIndex = logIndex;
    }

    public BigInteger getActionIndex() {
        return actionIndex;
    }

    public void setActionIndex(BigInteger actionIndex) {
        this.actionIndex = actionIndex;
    }

    public BigInteger getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(BigInteger transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    @Override
    public String toString() {
        return "Log{" +
                "name='" + name + '\'' +
                ", topics=" + topics +
                ", data='" + data + '\'' +
                ", blockNumber=" + blockNumber +
                ", blockHash='" + blockHash + '\'' +
                ", transactionHash='" + transactionHash + '\'' +
                ", logIndex=" + logIndex +
                ", actionIndex=" + actionIndex +
                ", transactionIndex=" + transactionIndex +
                '}';
    }

}
