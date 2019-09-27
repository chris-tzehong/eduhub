package com.example.android.eduhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserProfilePicDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "userProfilePic.db";
    public static final String TABLE_NAME = "userProfilePic_table";
    public static final String USERNAME = "USERNAME";
    public static final String PROFILE_PIC = "PROFILE_PICTURE";

    public UserProfilePicDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(" + USERNAME + "TEXT PRIMARY KEY, " +
        PROFILE_PIC + "BLOB" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addProfilePic(String userName, byte[] profilePic) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, userName);
        values.put(PROFILE_PIC, profilePic);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int updateProfilePic(String userName, byte[] profilePic){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME, userName);
        values.put(PROFILE_PIC, profilePic);

        return db.update(TABLE_NAME, values, USERNAME + "=?", new String[]{userName});
    }

    public Cursor getProfilePic() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;

    }
}
