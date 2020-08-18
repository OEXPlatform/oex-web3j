package com.oexchain.web3j;

import org.web3j.protocol.Web3jService;

public interface OexchainWeb3j extends Oexchain {

    static OexchainWeb3j build(Web3jService web3jService) {
        return new JsonRpc2_0OexchainWeb3j(web3jService);
    }

}
