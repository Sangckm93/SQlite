package vn.com.sqlite.SQLite;

public interface Constant {

    public static final String DATABASE_NAME = "Sqlite_db";
    public static final int DATABASE_VERSION_1 = 1;
    public static final int DATABASE_VERSION_2 = 2;
    public static final int DATABASE_VERSION_3 = 3;

    //Collum of wallet table
    // Version 1
    String TABLE_WALLET = "wallet";
    String TABLE_WALLET_TEMP = "wallet_temp";

    //Collum of transaction table
    String TABLE_TRANSACTION = "transactions";
    String TABLE_TRANSACTION_TEMP = "transactions_temp";

    //Version 3
    String TABLE_NODE= "node";

    String CREATE_WALLET_V1 = "CREATE TABLE IF NOT EXISTS "+TABLE_WALLET+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "address TEXT, "+
            "balance INTEGER, "+
            "pendingBalance INTEGER)";
    String CREATE_WALLET_V2 = "CREATE TABLE IF NOT EXISTS "+TABLE_WALLET+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "address TEXT, "+
            "name TEXT, "+
            "balance TEXT, "+
            "pendingBalance TEXT)";
    String CREATE_WALLET_V2_TEMP = "CREATE TABLE IF NOT EXISTS "+TABLE_WALLET_TEMP+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "address TEXT, "+
            "name TEXT, "+
            "balance TEXT, "+
            "pendingBalance TEXT)";
    String CREATE_WALLET_V3 = "CREATE TABLE IF NOT EXISTS "+TABLE_WALLET+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "address TEXT, "+
            "name TEXT, "+
            "balance TEXT, "+
            "pendingBalance TEXT, "+
            "totalBalance TEXT)";
    String CREATE_WALLET_V3_TEMP = "CREATE TABLE IF NOT EXISTS "+TABLE_WALLET_TEMP+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "address TEXT, "+
            "name TEXT, "+
            "balance TEXT, "+
            "pendingBalance TEXT, "+
            "totalBalance TEXT)";

    String CREATE_TRANSACTION_V1 = "CREATE TABLE IF NOT EXISTS "+TABLE_TRANSACTION+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "hash TEXT, "+
            "address TEXT, "+
            "toAddress TEXT, "+
            "pubKey TEXT, "+
            "amount INTEGER, "+
            "pendingUse INTEGER, "+
            "balance INTEGER, "+
            "fee INTEGER, "+
            "tip INTEGER, "+
            "message TEXT, "+
            "time INTEGER, "+
            "status INTEGER, "+
            "type TEXT, "+
            "prevHash TEXT, "+
            "sign TEXT, "+
            "receive_info TEXT, "+
            "isDeploy INTEGER, "+
            "isCall INTEGER, "+
            "functionCall TEXT)";
    String CREATE_TRANSACTION_V2 = "CREATE TABLE IF NOT EXISTS "+TABLE_TRANSACTION+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "hash TEXT, "+
            "address TEXT, "+
            "toAddress TEXT, "+
            "pubKey TEXT, "+
            "amount TEXT, "+
            "pendingUse TEXT, "+
            "balance TEXT, "+
            "fee TEXT, "+
            "tip TEXT, "+
            "message TEXT, "+
            "time INTEGER, "+
            "status INTEGER, "+
            "type TEXT, "+
            "prevHash TEXT, "+
            "sign TEXT, "+
            "receive_info TEXT, "+
            "isDeploy INTEGER, "+
            "isCall INTEGER, "+
            "functionCall TEXT, "+
            "data TEXT, "+
            "totalBalance TEXT)";

    String CREATE_TRANSACTION_V2_TEMP = "CREATE TABLE IF NOT EXISTS "+TABLE_TRANSACTION_TEMP+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "hash TEXT, "+
            "address TEXT, "+
            "toAddress TEXT, "+
            "pubKey TEXT, "+
            "amount TEXT, "+
            "pendingUse TEXT, "+
            "balance TEXT, "+
            "fee TEXT, "+
            "tip TEXT, "+
            "message TEXT, "+
            "time INTEGER, "+
            "status INTEGER, "+
            "type TEXT, "+
            "prevHash TEXT, "+
            "sign TEXT, "+
            "receive_info TEXT, "+
            "isDeploy INTEGER, "+
            "isCall INTEGER, "+
            "functionCall TEXT, "+
            "data TEXT, "+
            "totalBalance TEXT)";
    String CREATE_NODE= "CREATE TABLE IF NOT EXISTS "+TABLE_NODE+
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "ip TEXT, "+
            "port INTEGER, "+
            "time INTEGER)";
}
