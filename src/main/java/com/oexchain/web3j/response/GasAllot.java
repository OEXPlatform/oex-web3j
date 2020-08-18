package com.oexchain.web3j.response;

import java.math.BigInteger;

public class GasAllot {

    private String name;
    private BigInteger gas;
    private BigInteger typeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getGas() {
        return gas;
    }

    public void setGas(BigInteger gas) {
        this.gas = gas;
    }

    public BigInteger getTypeId() {
        return typeId;
    }

    public void setTypeId(BigInteger typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "GasAllot{" +
                "name='" + name + '\'' +
                ", gas=" + gas +
                ", typeId=" + typeId +
                '}';
    }

}
