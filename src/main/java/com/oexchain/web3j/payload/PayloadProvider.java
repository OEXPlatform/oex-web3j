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
     * @return
     * type AccountAuthorAction struct {
     *  Threshold             uint64          `json:"threshold,omitempty"`
     *  UpdateAuthorThreshold uint64          `json:"updateAuthorThreshold,omitempty"`
     *  AuthorActions         []*AuthorAction `json:"authorActions,omitempty"`
     * }
     * type AuthorAction struct {
     *  ActionType AuthorActionType //必填项 0添加 1更新 2删除
     *  Author     *common.Author //必填项
     * }
     *
     * type Author struct {
     *  Owner  `json:"owner"`         //用户名，地址或公钥
     *  Weight uint64 `json:"weight"` //必填项 权重
     * }
     *
     * Owner interface {
     *  String() string
     * }
     *
     *
    authorUpdateList.push([author.status, [ownerType, owner, author.weight]]);
    });

    const payload = '0x' + encode([threshold, updateAuthorThreshold, [...authorUpdateList]]).toString('hex');
     */
    public static byte[] updateAccountAuthorPayload(String oldPublicKey, String newPublicKey) {
        Long threshold = 1L;
        Long updateAuthorThreshold = 1L;
        Long addAuthor = 0L;
        Long deleteAuthor = 2L;
        Long publicKeyType = 1L;
        Long weight = 1L;

        RlpList deletePubKeyList = new RlpList(RlpString.create(deleteAuthor),
                                               new RlpList(RlpString.create(publicKeyType),
                                                           RlpString.create(Numeric.hexStringToByteArray(oldPublicKey)),
                                                           RlpString.create(weight)));
        RlpList addPubKeyList = new RlpList(RlpString.create(addAuthor),
                                            new RlpList(RlpString.create(publicKeyType),
                                                        RlpString.create(Numeric.hexStringToByteArray(newPublicKey)),
                                                        RlpString.create(weight)));

        RlpList rlpList = new RlpList(RlpString.create(threshold),
                                      RlpString.create(updateAuthorThreshold),
                                      new RlpList(deletePubKeyList, addPubKeyList));
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
