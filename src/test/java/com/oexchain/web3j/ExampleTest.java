package com.oexchain.web3j;

import com.oexchain.web3j.constant.ActionType;
import com.oexchain.web3j.constant.AssetId;
import com.oexchain.web3j.constant.ChainHost;
import com.oexchain.web3j.constant.ChainId;
import com.oexchain.web3j.payload.PayloadProvider;
import com.oexchain.web3j.request.CallTransaction;
import com.oexchain.web3j.response.TransactionReceipt;
import com.oexchain.web3j.tx.Transaction;
import com.oexchain.web3j.tx.TransactionManager;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.web3j.abi.datatypes.Function;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class ExampleTest {

    private OexchainWeb3j oexchainWeb3J = OexchainWeb3j.build(new HttpService(ChainHost.TEST));
    private int chainId = ChainId.TEST;
    private String testNodeNamePrefix = "minernodetest";
    private String oexchainOfficial = "oexchainofficial";
    private String contractAccount = "";
//    private String founderPrivateKey = "14d072cf6fa88e2a7ffd7cf6fa88e2a7f72cf6fa88e2a7ffd7fa88e2a7ffd7fd7f";
//    private String minerPrivateKey   = "f8890c0da8f3dae6547b22e3d206e3a249937a8f3dae6d206e3a249937a8f3dae6";
    private String founderPrivateKey = "";
    private String minerPrivateKey   = "";
    private String minerPrivateKey1 = "";
    private String anotherPrivateKey = "";

    @Test
    public void testCreateAccount() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey1);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.CREATE_NEW_ACCOUNT);
        oexTransaction.setAccountName(oexchainOfficial);
        oexTransaction.setToAccountName("oexchain.account");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("1")));

        for (int i = 1; i < 2; i++) {
            String accountName = "qqqqqqqqqqq2"; //testNodeNamePrefix + i;
            String publicKey = "0x046d8ca26f82aabcc26ef2c1882240f8d80d31cf5cced6abc2357e5e7fc5a66d3860c9b36a4045f12dd027475dd6c8c3687509f0fc9d82d8f706727350e7bf288d";
            try {
                //send transaction
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                        PayloadProvider.createAccountPayload(accountName, oexchainOfficial, publicKey, "Srv"));
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    @Test
    public void testCreateSubAccount() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey1);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        String fatherAccount = oexchainOfficial;
        oexTransaction.setActionType(ActionType.CREATE_NEW_ACCOUNT);
        oexTransaction.setAccountName(fatherAccount);
        oexTransaction.setToAccountName("oexchain.account");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("10")));

        for (int i = 0; i < 1; i++) {
            String accountName = fatherAccount + ".samyu100";  // 这就是子账号,子账号长度3~16个字符
            String publicKey = "0x046d8ca26f82aabcc26ef2c1882240f8d80d31cf5cced6abc2357e5e7fc5a66d3860c9b36a4045f12dd027475dd6c8c3687509f0fc9d82d8f706727350e7bf288d";
            try {
                //send transaction
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                        PayloadProvider.createAccountPayload(accountName, fatherAccount, publicKey, "Srv"));
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    @Test
    public void testUpdateAccountAuthor() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(anotherPrivateKey);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.UPDATE_ACCOUNT_AUTHOR);
        String fatherAccount = testNodeNamePrefix + '0';
        String accountName = fatherAccount + ".samyu";
        oexTransaction.setAccountName(accountName);
        oexTransaction.setToAccountName("oexchain.account");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("0")));

        for (int i = 1; i < 2; i++) {
            String oldPubKey = "0x044b6b39f775576f78bbd2f6fba7a112c2e4f7b804c816aaf691563d5734e7ce90643aa13fcc7f6bf30d256970589d3cb2eb5e2c74d16a7ac0fb214262ff587c07";
            String publicKey = "0x046d8ca26f82aabcc26ef2c1882240f8d80d31cf5cced6abc2357e5e7fc5a66d3860c9b36a4045f12dd027475dd6c8c3687509f0fc9d82d8f706727350e7bf288d";
            try {
                //send transaction
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                        PayloadProvider.updateAccountAuthorPayload(oldPubKey, publicKey));
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }



    @Test
    public void testUpdateAccountAuthorByFather() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey);   // 此处输入父账户的私钥
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.UPDATE_ACCOUNT_AUTHOR);
        String fatherAccount = testNodeNamePrefix + '0';
        String accountName = fatherAccount + ".samyu";
        oexTransaction.setAccountName(accountName);
        oexTransaction.setToAccountName("oexchain.account");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("0")));

        for (int i = 1; i < 2; i++) {
            String oldPubKey = "0x044b6b39f775576f78bbd2f6fba7a112c2e4f7b804c816aaf691563d5734e7ce90643aa13fcc7f6bf30d256970589d3cb2eb5e2c74d16a7ac0fb214262ff587c07";
            String newPubKey = "0x046d8ca26f82aabcc26ef2c1882240f8d80d31cf5cced6abc2357e5e7fc5a66d3860c9b36a4045f12dd027475dd6c8c3687509f0fc9d82d8f706727350e7bf288d";
            try {
                //send transaction
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransactionByFatherAccount(oexTransaction,
                        PayloadProvider.updateAccountAuthorPayload(oldPubKey, newPubKey));
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void testRegisterCandidate() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();

        for (int i = 1; i < 29; i++) {
            String accountName = testNodeNamePrefix + i;
            //create oexTransaction
            Transaction oexTransaction = new Transaction();
            oexTransaction.setActionType(ActionType.REGISTER_CANDIDATE);
            oexTransaction.setAccountName(accountName);
            oexTransaction.setToAccountName("oexchain.dpos");
            oexTransaction.setAssetId(AssetId.OEX);
            oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("100000")));
            //send transaction
            TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                    PayloadProvider.createRegCandidateload(""));
            System.out.println(oexTransactionReceipt);
        }
    }


    @Test
    public void testVote4Candidate() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(founderPrivateKey);//oexchain.founder(founderPrivateKey);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.VOTE_CANDIDATE);
        oexTransaction.setAccountName("oexchain.founder");
        oexTransaction.setToAccountName("oexchain.dpos");
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("0")));

        for (int i = 1; i <= 28; i++) {
            String accountName = testNodeNamePrefix + i;
            try {
                //send transaction
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                        PayloadProvider.createVoteCandidatePayload(accountName, new BigInteger("1000000000000000000").multiply(new BigInteger("11000000"))));
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){}
        }
    }


    @Test
    public void testBatchTransferByFounder() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(founderPrivateKey);

        for (int i = 1; i < 29; i++) {
            String accountName = "oexchain.founder";
            String toAccountName = testNodeNamePrefix + i;
            //create oexTransaction
            Transaction oexTransaction = new Transaction();
            oexTransaction.setActionType(ActionType.TRANSFER);
            oexTransaction.setAccountName(accountName);
            oexTransaction.setToAccountName(toAccountName);
            oexTransaction.setAssetId(AssetId.OEX);
            oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("300000")));

            TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
            //send transaction
            try {
                TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                        PayloadProvider.createTransferPayload());
                System.out.println(oexTransactionReceipt);
            } catch (Exception e){

            }
        }
    }

    @Test
    public void testExitTakeOver() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(founderPrivateKey);

        String accountName = "oexchain.founder";
        String toAccountName = "oexchain.dpos";
        //create oexTransaction
        Transaction oexTransaction = new Transaction();
        oexTransaction.setActionType(ActionType.EXIT_TAKEOVER);
        oexTransaction.setAccountName(accountName);
        oexTransaction.setToAccountName(toAccountName);
        oexTransaction.setAssetId(AssetId.OEX);
        oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("0")));

        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //send transaction
        try {
            TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                    PayloadProvider.createExitTakeOverPayload());
            System.out.println(oexTransactionReceipt);
        } catch (Exception e){

        }
    }

    @Test
    public void testBatchTransfer() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey);
        while(true) {
            for (int i = 1; i < 28; i++) {
                String accountName = testNodeNamePrefix + i;
                String toAccountName = testNodeNamePrefix + ( i + 1);
                //create oexTransaction
                Transaction oexTransaction = new Transaction();
                oexTransaction.setActionType(ActionType.TRANSFER);
                oexTransaction.setAccountName(accountName);
                oexTransaction.setToAccountName(toAccountName);
                oexTransaction.setAssetId(AssetId.OEX);
                oexTransaction.setAmount(new BigInteger("1000000000000000000").multiply(new BigInteger("1")));

                TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
                //send transaction
                try {
                    TransactionReceipt oexTransactionReceipt = oexTransactionManager.sendRawTransaction(oexTransaction,
                            PayloadProvider.createTransferPayload());
                    System.out.println(oexTransactionReceipt);
                } catch (Exception e){

                }
            }
        }
    }
    @Test
    public void testTransfer() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
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

    @Test
    public void testReadContract() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey1);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
        //create oexTransaction
        CallTransaction oexTransaction = new CallTransaction();
        oexTransaction.setFrom(oexchainOfficial);
        Function function = new Function("voterRewardRecord", );
        function
        //send transaction
        TransactionReceipt oexTransactionReceipt = oexTransactionManager.call(oexTransaction, );
        System.out.println(oexTransactionReceipt);
    }

    @Test
    public void testWriteContract() throws IOException, TransactionException {
        Credentials accout4testweb3jCredentials = Credentials.create(minerPrivateKey);
        TransactionManager oexTransactionManager = new TransactionManager.Builder().oexchainWeb3j(oexchainWeb3J).credentials(accout4testweb3jCredentials).chainId(chainId).build();
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

    static final int totalNum = 300000;
    private String[] readNamesFromFile() throws Exception {
        String[] names = new String[totalNum];
        String pattern = "^[a-z][a-z0-9]{3,15}";

        String filePath = "D:\\oexAccountNames.txt";
        File filename = new File(filePath);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        int count = 0;
        int index = 0;
        while (line != null && index < totalNum) {
            boolean isMatch = Pattern.matches(pattern, line);
            if (isMatch) {
                names[index++]  = line;
            }
            count++;
            if (count % 1000 == 0) {
                System.out.println("count = " + count);
            }
            line = br.readLine();
        }
        return names;
    }


    @Test
    public void buildAccounts() throws Exception {
        String[] nameList = readNamesFromFile();
        System.out.println("names' length = " + nameList.length);
        Set<Integer> usedIndex = new HashSet<Integer>();
        File accountNamesFile = new File("D:\\accountNames.txt");
        accountNamesFile.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(accountNamesFile));
        for (int i = 0; i < 10000; ) {
            int index = new Random().nextInt(totalNum);
            if (usedIndex.contains(index)) continue;
            usedIndex.add(index);
            i++;
            String name = nameList[index];
            if (name.length() < 12) {
                int minNum = (int)(Math.pow(10, 12 - name.length()));
                int plusNum = 1 +  new Random().nextInt(4);
                int maxNum = (int)(Math.pow(10, 12 + plusNum - name.length()));
                int num = minNum + (int)(Math.random() * (maxNum - minNum + 1));
                name += "" + num;
            } else if (name.length() < 16) {
                int randomNum = new Random().nextInt(5);
                if (randomNum == 2) {
                    int addonAfter = new Random().nextInt(10000);
                    name += "" + addonAfter;
                    if (name.length() > 16) name = name.substring(0, 16);
                }
            }

            ECKeyPair ecKeyPair = Keys.createEcKeyPair();
            String publicKey = "0x04" + Numeric.toHexStringNoPrefix(ecKeyPair.getPublicKey());
            String founderPrivateKey = "0x" + Numeric.toHexStringNoPrefix(ecKeyPair.getPrivateKey());

            out.write(name + "," + founderPrivateKey + "," + publicKey + "\r\n");
        }

        out.flush();
        out.close();
    }

    @Test
    public void createAccounts() throws Exception {
        File filename = new File("D:\\accountNames.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        int startIndex = 11;
        int endIndex = 10000;
        int count = 0;
        while(line != null) {
            if (count < startIndex) {
                line = br.readLine();
                count++;
                continue;
            }
            if (count > endIndex) break;
            String[] accountInfos = line.split(",");
            String accountName = accountInfos[0];
            String publicKey = accountInfos[2];
            String srvRequest = "http://47.115.150.104:9000/wallet_account_creation?accname="
                + accountName + "&pubkey=" + publicKey + "&deviceid=jWallet&rpchost=47.115.136.228&rpcport=8080&chainid=1";

            System.out.println(count + "：accountName = " + accountName);
            HttpGet httpget = new HttpGet(srvRequest);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println(response.toString());
            } finally {
                response.close();
            }
            Thread.sleep(1000);
            line = br.readLine();
            count++;
        }
    }


    @Test
    public void createMiners() throws Exception {
        File filename = new File("D:\\accountNames.txt");
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = "";
        line = br.readLine();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        int startIndex = 11;
        int endIndex = 10000;
        int count = 0;
        while(line != null) {
            if (count < startIndex) {
                line = br.readLine();
                count++;
                continue;
            }
            if (count > endIndex) break;
            String[] accountInfos = line.split(",");
            String accountName = accountInfos[0];
            String publicKey = accountInfos[2];
            String srvRequest = "http://47.115.150.104:9000/wallet_account_creation?accname="
                    + accountName + "&pubkey=" + publicKey + "&deviceid=jWallet&rpchost=47.115.136.228&rpcport=8080&chainid=1";

            System.out.println(count + "：accountName = " + accountName);
            HttpGet httpget = new HttpGet(srvRequest);
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                System.out.println(response.toString());
            } finally {
                response.close();
            }
            Thread.sleep(1000);
            line = br.readLine();
            count++;
        }
    }
}
