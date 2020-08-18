创建账户：

```
public void createAccount() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create("786d968206fdfab98b26c9e2ebfa061c09abc28c7c39da023b0630");
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(ChainId.TEST).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.CREATE_NEW_ACCOUNT);
        oexTransaction.setAccountName("oexchain.founder");
        oexTransaction.setToAccountName("oexchain.account");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("1510000")));

        String accountName = "minernodetest11";
        String publicKey = "0x04f24a1bf55d6635aba52292057d2ecbdae77b4e0628234cc7f9b6b2e7b53f9164d5fed23852c2c952ccc3e0ffe2ca109bd2ec738a5c315e7ccd32b931521199a2";
        //send transaction
        TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                PayloadProvider.createAccountPayload(accountName, "oexchain.founder", publicKey, "my wallet"));
        System.out.println(oexTransactionReceipt);
    }
```
转账：

```
public void transfer() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create("786d968206fdfab98b26c9e2ebfa061c09abc28c7c39da023b0630");
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(ChainId.TEST).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.TRANSFER);
        oexTransaction.setAccountName("accout4testweb3j");
        oexTransaction.setToAccountName("accout4testweb3j.test1");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("10000000000000000"));//0.01oex
        //send transaction
        TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction, PayloadProvider.createTransferPayload());
        System.out.println(oexTransactionReceipt);
    }
```
