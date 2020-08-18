package com.oexchain.web3j.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigInteger;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CallTransaction {
    /**
     * actionType - Quantity type of transaction.
     * from - String name of sender account.
     * to - String name of receipt account.
     * assetId - Quantity id of used asset.
     * gas - Quantity integer of the gas provided for the transaction execution. eth_call consumes zero gas, but this parameter may be needed by some executions.
     * gasPrice - Quantity integer of the gasPrice used for each paid gas.
     * value - Quantity integer of the value sent with this transaction.
     * data - String hash of the method signature and encoded parameters.
     * remark - String extra data with this transaction. -Quantity - height of the block, or string value latest or earliest.
     */
    private BigInteger actionType;
    private BigInteger nonce;
    private BigInteger assetId;
    private String from;
    private String to;
    private BigInteger gasPrice;
    private BigInteger gas;
    private BigInteger value;
    private String data;

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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigInteger getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(BigInteger gasPrice) {
        this.gasPrice = gasPrice;
    }

    public BigInteger getGas() {
        return gas;
    }

    public void setGas(BigInteger gas) {
        this.gas = gas;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
