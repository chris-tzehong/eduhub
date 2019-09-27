package com.example.android.eduhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME = "userInfo_table";
    public static final String NAME = "NAME";
    public static final String USERNAME = "USERNAME";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";

    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_user_table = "CREATE TABLE " + TABLE_NAME + "(" + NAME + " TEXT, " +
                USERNAME + " TEXT PRIMARY KEY, " + EMAIL + " TEXT, " + PASSWORD + " TEXT " + ")";
        sqLiteDatabase.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, user.getName());
        values.put(USERNAME, user.getUserName());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public User getUser(String userName){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{NAME, USERNAME, EMAIL, PASSWORD}, USERNAME + " =?",
        new String[]{userName}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        User user = new User (cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return user;
    }

    public List<User> getAllUser(){
        List<User> userList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setName(cursor.getString(0));
                user.setUserName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));
                userList.add(user);

            } while (cursor.moveToNext());
        }

        return userList;
    }

    public int updateUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME, user.getName());
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        return db.update(TABLE_NAME, values, USERNAME + "=?", new String[]{user.getUserName()});
    }

    public void deleteUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, USERNAME + "=?", new String[]{user.getUserName()});
        db.close();
    }

    public int getUserCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
}
