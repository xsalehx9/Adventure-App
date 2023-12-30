/*
this program to create Database (sqlite), they include Username, Password, Phone and Gender.
username is a primary key
they are condition for check username if is existed or not for sign up.
for LogIn they are condition for username and password if are available in database
*/

package com.Horizon_Adventure_App.Activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users(username TEXT primary key, password TEXT, Phones TEXT, Gender TEXT)");
        sqLiteDatabase.execSQL("create Table driver(IdCard TEXT, Fname TEXT, Lname TEX, city TEXT)");
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");
        sqLiteDatabase.execSQL("drop Table if exists driver");

    }

    public Boolean insertData(String username, String password, String Phones, String Gender) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("Phones", Phones);
        contentValues.put("Gender", Gender);

        long result = sqLiteDatabase.insert("users", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean insertData2(String IdCard, String Fname, String Lname, String city) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IdCard", IdCard);
        contentValues.put("Fname", Fname);
        contentValues.put("Lname", Lname);
        contentValues.put("city", city);
        long result = sqLiteDatabase.insert("driver", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username=? ", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users where username=? and password=?", new String[]{username,password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}