package com.oexchain.web3j.response;

import org.web3j.protocol.core.Response;

import java.math.BigInteger;

public class NonceResult extends Response<BigInteger> {

    public BigInteger getNonce() {
        return getResult();
    }

}
