package com.example.android.eduhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ProgressDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "progress.db";
    public static final String TABLE_NAME = "PROGRESS_TABLE";
    public static final String PROGRESS_OWNER = "PROGRESS_OWNER";
    public static final String MATHS1 = "MARKS_MATHS1";
    public static final String MATHS2 = "MARKS_MATHS2";
    public static final String ADDMATHS1 = "MARKS_ADDMATHS1";
    public static final String ADDMATHS2 = "MARKS_ADDMATHS2";
    public static final String PHYSICS1 = "MARKS_PHYSICS1";
    public static final String PHYSICS2 = "MARKS_PHYSICS2";
    public static final String CHEMISTRY1 = "MARKS_CHEMISTRY1";
    public static final String CHEMISTRY2 = "MARKS_CHEMISTRY2";
    public static final String BIOLOGY1 = "MARKS_BIOLOGY1";
    public static final String BIOLOGY2 = "MARKS_BIOLOGY2";
    public static final String FIRST_ACHIEVEMENT = "FIRST_ACHIEVEMENT";
    public static final String SECOND_ACHIEVEMENT = "SECOND_ACHIEVEMENT";

    public ProgressDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + PROGRESS_OWNER + " TEXT PRIMARY KEY NOT NULL, " +
                MATHS1 + " INTEGER, " + MATHS2 + " INTEGER, " + ADDMATHS1 + " INTEGER, " + ADDMATHS2 +
                " INTEGER, " + PHYSICS1 + " INTEGER, " + PHYSICS2 + " INTEGER, " + CHEMISTRY1 + " INTEGER, " +
                CHEMISTRY2 + " INTEGER, " + BIOLOGY1 + " INTEGER, " + BIOLOGY2 + " INTEGER, " + FIRST_ACHIEVEMENT +
                " INTEGER, " + SECOND_ACHIEVEMENT + " INTEGER " + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void addProgress(Progress_Achievement progress) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(PROGRESS_OWNER, progress.getUserID());
        values.put(MATHS1, progress.getMaths1());
        values.put(MATHS2, progress.getMaths2());
        values.put(ADDMATHS1, progress.getAddmaths1());
        values.put(ADDMATHS2, progress.getAddmaths2());
        values.put(PHYSICS1, progress.getPhysics1());
        values.put(PHYSICS2, progress.getPhysics2());
        values.put(CHEMISTRY1, progress.getChemistry1());
        values.put(CHEMISTRY2, progress.getChemistry2());
        values.put(BIOLOGY1, progress.getBiology1());
        values.put(BIOLOGY2, progress.getBiology2());
        values.put(FIRST_ACHIEVEMENT, progress.getFirst_achievement());
        values.put(SECOND_ACHIEVEMENT, progress.getSecond_achievement());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Progress_Achievement getProgress(String owner){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{PROGRESS_OWNER, MATHS1, MATHS2, ADDMATHS1, ADDMATHS2, PHYSICS1,
                PHYSICS2, CHEMISTRY1, CHEMISTRY2, BIOLOGY1, BIOLOGY2, FIRST_ACHIEVEMENT, SECOND_ACHIEVEMENT}, PROGRESS_OWNER + " =?",
                new String[]{owner}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Progress_Achievement progress = new Progress_Achievement(cursor.getString(0), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8)),
                Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)),
                Integer.parseInt(cursor.getString(12))) ;

        return progress;
    }

    public int updateProgress(Progress_Achievement progress){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PROGRESS_OWNER, progress.getUserID());
        values.put(MATHS1, progress.getMaths1());
        values.put(MATHS2, progress.getMaths2());
        values.put(ADDMATHS1, progress.getAddmaths1());
        values.put(ADDMATHS2, progress.getAddmaths2());
        values.put(PHYSICS1, progress.getPhysics1());
        values.put(PHYSICS2, progress.getPhysics2());
        values.put(CHEMISTRY1, progress.getChemistry1());
        values.put(CHEMISTRY2, progress.getChemistry2());
        values.put(BIOLOGY1, progress.getBiology1());
        values.put(BIOLOGY2, progress.getBiology2());
        values.put(FIRST_ACHIEVEMENT, progress.getFirst_achievement());
        values.put(SECOND_ACHIEVEMENT, progress.getSecond_achievement());

        return db.update(TABLE_NAME, values, PROGRESS_OWNER + "=?", new String[]{progress.getUserID()});
    }

    public void deleteProgress(Progress_Achievement progress){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, PROGRESS_OWNER + "=?", new String[]{progress.getUserID()});
        db.close();
    }


}
