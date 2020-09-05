package com.oexchain.web3j.constant;

import org.web3j.utils.Numeric;

import java.math.BigInteger;

public interface ActionType {

    /**
     * 关于各种Action的含义，请参考：
     * https://github.com/oexplatform/oexchain/wiki/%E4%BA%A4%E6%98%93payload%E6%9E%84%E9%80%A0
     */
    BigInteger CALL_CONTRACT = Numeric.toBigInt("0x00");
    BigInteger CREATE_CONTRACT = Numeric.toBigInt("0x01");
    BigInteger MULTI_ASSET_CALL = Numeric.toBigInt("0x02");

    BigInteger CREATE_NEW_ACCOUNT = Numeric.toBigInt("0x100");
    BigInteger UPDATE_ACCOUNT_FOUNDER = Numeric.toBigInt("0x101");
    BigInteger DELETE_ACCOUNT = Numeric.toBigInt("0x102");
    BigInteger UPDATE_ACCOUNT_AUTHOR = Numeric.toBigInt("0x103");
    BigInteger UPDATE_ACCOUNT_DESC = Numeric.toBigInt("0x104");

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

}
