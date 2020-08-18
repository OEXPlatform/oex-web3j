package com.oexchain.web3j.tx;

import java.math.BigInteger;

/**
 * @author howaric@163.com
 * @date 2019/11/3
 */
public class Transaction {

    /**
     * AType:    actionType, //必填项 Transfer 0x205
     * Nonce:    nonce, //必填项
     * AssetID:  assetID, //必填项 转账资产ID
     * From:     from, //必填项
     * To:       to, //必填项
     * GasLimit: gasLimit,//必填项
     * Amount:   new(big.Int), //转账金额
     * Payload:  payload,
     * Remark:   remark,   // 备注信息
     */
    private BigInteger actionType;
    private BigInteger nonce;
    private BigInteger assetId;
    private String accountName;
    private String toAccountName;
    private BigInteger gasLimit;
    private BigInteger gasPrice;
    private BigInteger amount;
    private BigInteger parentIndex = BigInteger.ZERO;
    private byte[] payload;
    private String remark = "";

    public BigInteger getActionType() {
        return actionType;
    }

    public void setActionType(BigInteger actionType) {
        this.actionType = actionType;
    }

    public BigInteger getNonce() {
        return nonce;
    }

    public void setNonce(BigInteger nonce) {
        this.nonce = nonce;
    }

    public BigInteger getAssetId() {
        return assetId;
    }

    public void setAssetId(BigInteger assetId) {
        this.assetId = assetId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getToAccountName() {
        return toAccountName;
    }

    public void setToAccountName(String toAccountName) {
        this.toAccountName = toAccountName;
    }

    public BigInteger getGasLimit() {
        return gasLimit;
    }

    public void setGasLimit(BigInteger gasLimit) {
        this.gasLimit = gasLimit;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(BigInteger parentIndex) {
        this.parentIndex = parentIndex;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
