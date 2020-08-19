package com.oexchain.web3j.payload;

import org.web3j.rlp.RlpEncoder;
import org.web3j.rlp.RlpList;
import org.web3j.rlp.RlpString;
import org.web3j.utils.Numeric;

import java.math.BigInteger;


public class PayloadProvider {

    private PayloadProvider() {
    }

    /**
     * 获取创建账户payload
     *
     * @param accountName
     * @param founder
     * @param publicKey
     * @param description
     * @return
     */
    public static byte[] createAccountPayload(String accountName, String founder, String publicKey, String description) {
        RlpList rlpList = new RlpList(RlpString.create(accountName), RlpString.create(founder),
                RlpString.create(Numeric.hexStringToByteArray(publicKey)), RlpString.create(description));
        return RlpEncoder.encode(rlpList);
    }

    /**
     * 获取注册候选者payload
     *
     * @param url
     * @return
     */
    public static byte[] createRegCandidateload(String url) {
        RlpList rlpList = new RlpList(RlpString.create(url));
        return RlpEncoder.encode(rlpList);
    }

    /**
     * 获取转账payload
     *
     * @param
     * @return
     */
    public static byte[] createTransferPayload() {
        return new byte[0];
    }

    /**
     * 获取用户给候选者投票的payload
     *
     * @param
     * @return
     */
    public static byte[] createVoteCandidatePayload(String candidateName, BigInteger stake) {
        RlpList rlpList = new RlpList(RlpString.create(candidateName), RlpString.create(stake));
        return RlpEncoder.encode(rlpList);
    }

    /**
     * 获取超级账号退出接管的payload
     *
     * @param
     * @return
     */
    public static byte[] createExitTakeOverPayload() {
        return new byte[0];
    }
}
