package vn.com.sqlite.database;

public interface BaseCollum {

    String DATABASE_NAME = "Sqlite_db";
    int DATABASE_VERSION_1 = 1;
    int DATABASE_VERSION_2 = 2;
    int DATABASE_VERSION_3 = 3;

    //Collum of wallet table
    // Version 1
    String TABLE_WALLET = "wallet";
    String TABLE_WALLET_TEMP = "wallet_temp";
    String COLLUM_WALLET_ID = "id";
    String COLLUM_WALLET_ADDRESS = "address";
    String COLLUM_WALLET_BALANCE = "balance";
    String COLLUM_WALLET_PENDING_BALANCE = "pendingBalance";
    // Version 2
    String COLLUM_WALLET_NAME = "name";

    //Collum of transaction table
    String TABLE_TRANSACTION = "transactions";
    String TABLE_TRANSACTION_TEMP = "transactions_temp";
    String COLLUM_TRANSACTION_ID = "id";
    String COLLUM_TRANSACTION_HASH = "hash";
    String COLLUM_TRANSACTION_ADDRESS = "address";
    String COLLUM_TRANSACTION_TO_ADDRESS = "toAddress";
    String COLLUM_TRANSACTION_PUB_KEY = "pubKey";
    String COLLUM_TRANSACTION_AMOUNT = "amount";
    String COLLUM_TRANSACTION_PENDING_USE = "pendingUse";
    String COLLUM_TRANSACTION_BALANCE = "balance";
    String COLLUM_TRANSACTION_FEE = "fee";
    String COLLUM_TRANSACTION_TIP = "tip";
    String COLLUM_TRANSACTION_MESSAGE = "message";
    String COLLUM_TRANSACTION_TIME = "time";
    String COLLUM_TRANSACTION_STATUS = "status";
    String COLLUM_TRANSACTION_TYPE = "type";
    String COLLUM_TRANSACTION_PREV_HASH = "prevHash";
    String COLLUM_TRANSACTION_SIGN = "sign";
    String COLLUM_TRANSACTION_RECEIVE_INFO = "receive_info";
    String COLLUM_TRANSACTION_IS_DEPLOY = "isDeploy";
    String COLLUM_TRANSACTION_IS_CALL = "isCall";
    String COLLUM_TRANSACTION_FUNCTION_CALL = "functionCall";

}
