package com.oexchain.web3j.constant;

import org.web3j.utils.Numeric;

import java.math.BigInteger;

public interface ActionType {

    /**
     * export const CALL_CONTRACT = 0x00;
     * export const CREATE_CONTRACT = 0x01;
     * <p>
     * export const CREATE_NEW_ACCOUNT = 0x100;
     * export const UPDATE_ACCOUNT = 0x101;
     * export const DELETE_ACCOUNT = 0x102;
     * export const UPDATE_ACCOUNT_AUTHOR = 0x103;
     * <p>
     * export const INCREASE_ASSET = 0x200;
     * export const ISSUE_ASSET = 0x201;
     * export const DESTORY_ASSET = 0x202;
     * export const SET_ASSET_OWNER = 0x203;
     * export const UPDATE_ASSET = 0x204;
     * export const TRANSFER = 0x205;
     * <p>
     * export const REG_CANDIDATE = 0x300;
     * export const UPDATE_CANDIDATE = 0x301;
     * export const UNREG_CANDIDATE = 0x302;
     * export const REFUND_CANDIDATE = 0x303;
     * export const VOTE_CANDIDATE = 0x304;
     * <p>
     * export const KICKED_CANDIDATE = 0x400;
     * export const EXIT_TAKEOVER = 0x401;
     * <p>
     * export const WITHDRAW_FEE = 0x500;
     */
    BigInteger CALL_CONTRACT = Numeric.toBigInt("0x00");
    BigInteger CREATE_NEW_ACCOUNT = Numeric.toBigInt("0x100");
    BigInteger TRANSFER = Numeric.toBigInt("0x205");
    BigInteger UPDATE_ASSET_CONTRACT = Numeric.toBigInt("0x206");
    BigInteger CHANGE_ASSET_CONTRACT = Numeric.toBigInt("0x203");
    BigInteger ISSUE_ASSET = Numeric.toBigInt("0x201");
    BigInteger REGISTER_CANDIDATE = Numeric.toBigInt("0x300");
    BigInteger VOTE_CANDIDATE = Numeric.toBigInt("0x304");
    BigInteger EXIT_TAKEOVER = Numeric.toBigInt("0x401");

}
