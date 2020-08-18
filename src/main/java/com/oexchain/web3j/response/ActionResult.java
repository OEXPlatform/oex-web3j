package com.oexchain.web3j.response;

import java.math.BigInteger;
import java.util.List;

public class ActionResult {

    private BigInteger actionType;
    private BigInteger status;
    private BigInteger index;
    private BigInteger gasUsed;
    private List<GasAllot> gasAllot;
    private String error;

    public BigInteger getActionType() {
        return actionType;
    }

    public void setActionType(BigInteger actionType) {
        this.actionType = actionType;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public BigInteger getIndex() {
        return index;
    }

    public void setIndex(BigInteger index) {
        this.index = index;
    }

    public BigInteger getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(BigInteger gasUsed) {
        this.gasUsed = gasUsed;
    }

    public List<GasAllot> getGasAllot() {
        return gasAllot;
    }

    public void setGasAllot(List<GasAllot> gasAllot) {
        this.gasAllot = gasAllot;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ActionResult{" +
                "actionType=" + actionType +
                ", status=" + status +
                ", index=" + index +
                ", gasUsed=" + gasUsed +
                ", gasAllot=" + gasAllot +
                ", error='" + error + '\'' +
                '}';
    }

}
