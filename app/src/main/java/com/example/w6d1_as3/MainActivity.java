package com.example.w6d1_as3;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase.loadLibs(this);
        insertSthToDb();
    }

    private void insertSthToDb(){
        SQLiteDatabase db = FeedReaderDbHelper.getInstance(this).getWritableDatabase("wow!");

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, 1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "Ross encrypts a database");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "Promptly shoved into locker");

        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);

        Cursor cursor = db.rawQuery("SELECT * FROM '" + FeedReaderContract.FeedEntry.TABLE_NAME + "';", null);
        Log.d(MainActivity.class.getSimpleName(), "Rows count: " + cursor.getCount());
        cursor.close();
        db.close();

        //db = FeedReaderDbHelper.getInstance(this).getWritableDatabase("");
    }
}
