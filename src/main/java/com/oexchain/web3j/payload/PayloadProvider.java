package com.oexchain.web3j.payload;

import org.web3j.rlp.RlpEncoder;
import org.web3j.rlp.RlpList;
import org.web3j.rlp.RlpString;
import org.web3j.utils.Numeric;

import java.math.BigInteger;


/*
*
    BigInteger CALL_CONTRACT = Numeric.toBigInt("0x00");
    BigInteger CREATE_CONTRACT = Numeric.toBigInt("0x01");
    BigInteger MULTI_ASSET_CALL = Numeric.toBigInt("0x02");


    BigInteger INCREASE_ASSET = Numeric.toBigInt("0x200");
    BigInteger ISSUE_ASSET = Numeric.toBigInt("0x201");
    BigInteger DESTORY_ASSET = Numeric.toBigInt("0x202");
    BigInteger SET_ASSET_OWNER = Numeric.toBigInt("0x203");
    BigInteger UPDATE_ASSET_FOUNDER = Numeric.toBigInt("0x204");
    BigInteger TRANSFER = Numeric.toBigInt("0x205");
    BigInteger UPDATE_ASSET_CONTRACT = Numeric.toBigInt("0x206");

    BigInteger REGISTER_CANDIDATE = Numeric.toBigInt("0x300");
    BigInteger UPDATE_CANDIDATE_URL = Numeric.toBigInt("0x301");
    BigInteger UNREG_CANDIDATE = Numeric.toBigInt("0x302");
    BigInteger REFUND_CANDIDATE = Numeric.toBigInt("0x303");
    BigInteger VOTE_CANDIDATE = Numeric.toBigInt("0x304");
    BigInteger UPDATE_CANDIDATE_PUBKEY = Numeric.toBigInt("0x305");

    BigInteger KICKED_CANDIDATE = Numeric.toBigInt("0x400");
    BigInteger EXIT_TAKEOVER = Numeric.toBigInt("0x401");
    BigInteger REMOVE_KICKED_CANDIDATE = Numeric.toBigInt("0x402");

    BigInteger WITHDRAW_FEE = Numeric.toBigInt("0x500");

* */

public class PayloadProvider {

    private PayloadProvider() {
    }

    /**
     * 获取创建账户的payload
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
     * 更新账户Founder的payload
     *
     * @param founder
     * @return
     */
    public static byte[] updateAccountFounderPayload(String founder) {
        RlpList rlpList = new RlpList(RlpString.create(founder));
        return RlpEncoder.encode(rlpList);
    }

    /**
     * 更新账户权限的payload
     *
     * @param threshold
     * @param updateAuthorThreshold
     * @param publicKey
     * @param weight
     * @return
     */
    public static byte[] updateAccountAuthorPayload(Long threshold, Long updateAuthorThreshold, String publicKey, Long weight) {
        RlpList rlpList = new RlpList(RlpString.create(threshold), RlpString.create(updateAuthorThreshold),
                new RlpList(new RlpList(RlpString.create(1), new RlpList(RlpString.create(publicKey), RlpString.create(weight)))));
        return RlpEncoder.encode(rlpList);
    }

    /**
     * 更新账户描述的payload
     *
     * @param desc
     * @return
     */
    public static byte[] updateAccountDescPayload(String desc) {
        RlpList rlpList = new RlpList(RlpString.create(desc));
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
