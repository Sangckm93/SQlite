package vn.com.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import vn.com.sqlite.SQLite.Constant;
import vn.com.sqlite.SQLite.DBHelper;

public class MainActivity extends AppCompatActivity implements Constant {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create DB
        DBHelper dbHelper = new DBHelper(this, DATABASE_NAME, null, DATABASE_VERSION_1);

        // create Table V1
//        dbHelper.QueryData(CREATE_WALLET_V1);
//        dbHelper.QueryData(CREATE_TRANSACTION_V1);

//        addValueWallet(dbHelper, 100);
//        addValueTransaction(dbHelper, 100);
//        fromV1_V2(dbHelper);
//        fromV2_V3(dbHelper);
        fromV1_V3(dbHelper);


//        Cursor cursor = dbHelper.getData("SELECT * FROM wallet");
//        while (cursor.moveToNext()){
//            Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
//        }
    }

    private void fromV1_V3(DBHelper dbHelper) {
        // Add node table
        dbHelper.QueryData(CREATE_NODE);
        // Update wallet table from v1->v3
        update_walletTB_V1_V3(dbHelper);
        // update transaction table from v1->v3
        update_transaction_table(dbHelper);
    }

    private void fromV2_V3(DBHelper dbHelper) {
        update_walletTB_v2_v3(dbHelper);
        dbHelper.QueryData(CREATE_NODE);
    }

    private void update_walletTB_v2_v3(DBHelper dbHelper) {
        // Add collum totalBalance
        String add_collum = "ALTER TABLE "+ TABLE_WALLET+ " ADD COLUMN totalBalance TEXT";
        dbHelper.QueryData(add_collum);
    }

    private void fromV1_V2(DBHelper dbHelper) {
        update_walletTB_V1_V2(dbHelper);
        update_transaction_table(dbHelper);
    }

    private void addValueWallet(DBHelper dbHelper, int count) {
        for (int i = 0; i<=count; i++){
            dbHelper.QueryData("INSERT INTO "+TABLE_WALLET+ " VALUES"+
                    "(null, 'Hanoi', 24, "+ (count-i) +")");
        }
//        dbHelper.QueryData("INSERT INTO "+TABLE_WALLET+ " VALUES(null, 'Hanoi', 24, 24)");
    }
    private void addValueTransaction(DBHelper dbHelper, int count) {
        for(int i = 0; i<=count; i++){
            dbHelper.QueryData("INSERT INTO "+TABLE_TRANSACTION+ " VALUES"+
                    "(null, "+
                    "'hash"+i+"', "+
                    "'address"+i+"', "+
                    "'toAddress"+i+"', "+
                    "'pubKey"+i+"', "+
                    "12, "+
                    "12, "+
                    "12, "+
                    "11, "+
                    "14, "+
                    "'message TEXT', "+
                    "15, "+
                    "16, "+
                    "'type TEXT', "+
                    "'prevHash TEXT', "+
                    "'sign TEXT', "+
                    "'receive_info TEXT', "+
                    "17, "+
                    "18, "+
                    "'functionCall"+i+"')");
        }
    }
    private void update_walletTB_V1_V2(DBHelper dbHelper) {

        String copy_data_wallet = "INSERT INTO "+TABLE_WALLET_TEMP+"(id, address, balance, pendingBalance) SELECT id, address, CAST(balance as TEXT), CAST(pendingBalance as TEXT) From "+TABLE_WALLET;
        String delete_wallet_db = "DROP TABLE IF EXISTS "+ TABLE_WALLET;
        String change_name_wallet = "ALTER TABLE "+ TABLE_WALLET_TEMP+" RENAME TO "+ TABLE_WALLET;

        // create Table V1_TEMP
        dbHelper.QueryData(CREATE_WALLET_V2_TEMP);
        // Copy and cast data from original table to temp
        dbHelper.QueryData(copy_data_wallet);
        // Delete old wallet Version
        dbHelper.QueryData(delete_wallet_db);
        // Rename to original
        dbHelper.QueryData(change_name_wallet);

    }
    private void update_walletTB_V1_V3(DBHelper dbHelper) {

        String copy_data_wallet = "INSERT INTO "+TABLE_WALLET_TEMP+"(id, address, balance, pendingBalance) SELECT id, address, CAST(balance as TEXT), CAST(pendingBalance as TEXT) From "+TABLE_WALLET;
        String delete_wallet_db = "DROP TABLE IF EXISTS "+ TABLE_WALLET;
        String change_name_wallet = "ALTER TABLE "+ TABLE_WALLET_TEMP+" RENAME TO "+ TABLE_WALLET;

        // create wallet V3_TEMP
        dbHelper.QueryData(CREATE_WALLET_V3_TEMP);
        // Copy and cast data from original table to temp
        dbHelper.QueryData(copy_data_wallet);
        // Delete old wallet Version
        dbHelper.QueryData(delete_wallet_db);
        // Rename to original
        dbHelper.QueryData(change_name_wallet);

    }
    private void update_transaction_table(DBHelper dbHelper) {

        String copy_data_transaction = "INSERT INTO "+ TABLE_TRANSACTION_TEMP +
                "(id, hash, address, toAddress, pubKey, amount, pendingUse, balance, fee, tip, message, time, status, type, prevHash, sign, receive_info, isDeploy, isCall, functionCall) "+
                "SELECT id, hash, address, toAddress, pubKey, CAST(amount as TEXT), CAST(pendingUse as TEXT), CAST(balance as TEXT), CAST(fee as TEXT), CAST(tip as TEXT), message, time, status, type, prevHash, sign, receive_info, isDeploy, isCall, functionCall "+
                "From "+TABLE_TRANSACTION;
        String delete_transaction_db = "DROP TABLE IF EXISTS "+ TABLE_TRANSACTION;
        String change_name_transaction = "ALTER TABLE "+ Constant.TABLE_TRANSACTION_TEMP+" RENAME TO "+ Constant.TABLE_TRANSACTION;

        // Create temp transaction table
        dbHelper.QueryData(CREATE_TRANSACTION_V2_TEMP);
        //copy and cast old data
        dbHelper.QueryData(copy_data_transaction);
        // delete old transaction table
        dbHelper.QueryData(delete_transaction_db);
        //Rename to original
        dbHelper.QueryData(change_name_transaction);
    }
}