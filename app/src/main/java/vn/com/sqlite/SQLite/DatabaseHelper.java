package vn.com.sqlite.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Sqlite_db";
    public static final int DATABASE_VERSION_1 = 1;
    public static final int DATABASE_VERSION_2 = 2;
    public static final int DATABASE_VERSION_3 = 3;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION_1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create table
        String wallet = "CREATE TABLE "+ Constant.TABLE_WALLET+" (id INTEGER PRIMARY KEY AUTOINCREMENT, address TEXT, balance INTEGER, pendingBalance INTEGER)";
//        String wallet = "CREATE TABLE "+BaseCollum.TABLE_WALLET+" (id INTEGER PRIMARY KEY AUTOINCREMENT, address TEXT, name TEXT, balance TEXT, pendingBalance TEXT, totalBalance TEXT)";
        String transaction = "CREATE TABLE "+ Constant.TABLE_TRANSACTION+"(id INTEGER PRIMARY KEY AUTOINCREMENT, hash TEXT, address TEXT, toAddress TEXT, pubKey TEXT, amount INTEGER, pendingUse INTEGER, balance INTEGER, fee INTEGER, tip INTEGER, message TEXT, time INTEGER, status INTEGER, type TEXT, prevHash TEXT, sign TEXT, receive_info TEXT, isDeploy INTEGER, isCall INTEGER, functionCall TEXT)";
//        String transaction = "CREATE TABLE "+BaseCollum.TABLE_TRANSACTION+"(id INTEGER PRIMARY KEY AUTOINCREMENT, hash TEXT, address TEXT, toAddress TEXT, pubKey TEXT, amount INTEGER, pendingUse INTEGER, balance INTEGER, fee INTEGER, tip INTEGER, message TEXT, time INTEGER, status INTEGER, type TEXT, prevHash TEXT, sign TEXT, receive_info TEXT, isDeploy INTEGER, isCall INTEGER, functionCall TEXT)";

        db.execSQL(wallet);
        db.execSQL(transaction);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        // Update from version 1 -> 2

        // create temp table
        String wallet_temp = "CREATE TABLE "+ Constant.TABLE_WALLET_TEMP+" (id INTEGER PRIMARY KEY AUTOINCREMENT, address TEXT, name TEXT, balance TEXT, pendingBalance TEXT)";
        String transaction_temp = "CREATE TABLE "+ Constant.TABLE_TRANSACTION_TEMP+"(id INTEGER PRIMARY KEY AUTOINCREMENT, hash TEXT, address TEXT, toAddress TEXT, pubKey TEXT, amount TEXT, pendingUse TEXT, balance TEXT, fee TEXT, tip TEXT, message TEXT, time INTEGER, status INTEGER, type TEXT, prevHash TEXT, sign TEXT, receive_info TEXT, isDeploy INTEGER, isCall INTEGER, functionCall TEXT, data TEXT, totalBalance TEXT)";
        db.execSQL(wallet_temp);
        db.execSQL(transaction_temp);
        // Copy and cast data from original table
        String copy_data_wallet = "INSERT INTO "+ Constant.TABLE_WALLET_TEMP+"(id, address, balance, pendingBalance) SELECT id, address, CAST(balance as TEXT), CAST(pendingBalance as TEXT) From "+ Constant.TABLE_WALLET;
        String copy_data_transaction = "INSERT INTO "+ Constant.TABLE_TRANSACTION_TEMP +
                "(id, hash, address, toAddress, pubKey, amount, pendingUse, balance, fee, tip, message, time, status, type, prevHash, sign, receive_info, isDeploy, isCall, functionCall, data, totalBalance) SELECT id, hash, address, toAddress, pubKey, CAST(amount as TEXT), CAST(pendingUse as TEXT), CAST(balance as TEXT), CAST(fee as TEXT), CAST(tip as TEXT), message, time, status, type, prevHash, sign, receive_info, isDeploy, isCall, functionCall, data, totalBalance From "+ Constant.TABLE_TRANSACTION;
        db.execSQL(copy_data_wallet);
        db.execSQL(copy_data_transaction);

        // delete original db
        String delete_wallet_db = "DROP TABLE IF EXISTS "+ Constant.TABLE_WALLET;
        String delete_transaction_db = "DROP TABLE IF EXISTS "+ Constant.TABLE_TRANSACTION;

        db.execSQL(delete_wallet_db);
        db.execSQL(delete_transaction_db);

        // Change name of table wallet temp
        String change_name_wallet = "ALTER TABLE "+ Constant.TABLE_WALLET_TEMP+" RENAME TO "+ Constant.TABLE_WALLET +";";
        String change_name_transaction = "ALTER TABLE "+ Constant.TABLE_TRANSACTION_TEMP+" RENAME TO "+ Constant.TABLE_TRANSACTION +";";
        db.execSQL(change_name_wallet);
        db.execSQL(change_name_transaction);

        // Add 2 collum to transaction

        String add_collum_data = "ALTER TABLE "+ Constant.TABLE_TRANSACTION+ " ADD COLUMN data TEXT";
        String add_collum_totalBalance = "ALTER TABLE "+ Constant.TABLE_TRANSACTION+ " ADD COLUMN totalBalance TEXT";
        db.execSQL(add_collum_data);
        db.execSQL(add_collum_totalBalance);

        onCreate(db);

    }
}
