package com.example.android.eduhub;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import static com.example.android.eduhub.MainActivity.loginID;

public class SchedulerDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "scheduler.db";
    public static final String TABLE_NAME = "SCHEDULER_TABLE";
    public static final String TASK_NAME = "NAME";
    public static final String TASK_YEAR = "YEAR";
    public static final String TASK_MONTH = "MONTH";
    public static final String TASK_DAY = "DAY";
    public static final String TASK_HOUR = "HOUR";
    public static final String TASK_MINUTE = "MINUTE";
    public static final String TASK_DESCRIPTION = "DESCRIPTION";
    public static final String TASK_OWNER = "OWNER";

    public SchedulerDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + TASK_NAME + " TEXT PRIMARY KEY, " +
                TASK_YEAR + " INTEGER, " + TASK_MONTH + " INTEGER, " + TASK_DAY + " INTEGER, " +
                TASK_HOUR + " INTEGER, " + TASK_MINUTE + " INTEGER, " + TASK_DESCRIPTION + " TEXT, " +
                TASK_OWNER + " TEXT" + ")";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TASK_NAME, task.getTaskName());
        values.put(TASK_YEAR, task.getYear());
        values.put(TASK_MONTH, task.getMonth());
        values.put(TASK_DAY, task.getDay());
        values.put(TASK_HOUR, task.getHour());
        values.put(TASK_MINUTE, task.getMinute());
        values.put(TASK_DESCRIPTION, task.getDescription());
        values.put(TASK_OWNER, loginID);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Task getTask(String taskName){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{TASK_NAME, TASK_YEAR, TASK_MONTH, TASK_DAY, TASK_HOUR, TASK_MINUTE, TASK_DESCRIPTION, TASK_OWNER}, TASK_NAME + " =?",
                new String[]{taskName}, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Task task = new Task(cursor.getString(0), Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)),
                cursor.getString(6)) ;

        return task;
    }

    public ArrayList<Task> getAllTask(){
        ArrayList<Task> taskList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setTaskName(cursor.getString(0));
                task.setYear(Integer.parseInt(cursor.getString(1)));
                task.setMonth(Integer.parseInt(cursor.getString(2)));
                task.setDay(Integer.parseInt(cursor.getString(3)));
                task.setHour(Integer.parseInt(cursor.getString(4)));
                task.setMinute(Integer.parseInt(cursor.getString(5)));
                task.setDescription(cursor.getString(6));
                taskList.add(task);

            } while (cursor.moveToNext());
        }

        return taskList;
    }

    public int updateTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TASK_NAME, task.getTaskName());
        values.put(TASK_YEAR, task.getYear());
        values.put(TASK_MONTH, task.getMonth());
        values.put(TASK_DAY, task.getDay());
        values.put(TASK_HOUR, task.getHour());
        values.put(TASK_MINUTE, task.getMinute());
        values.put(TASK_DESCRIPTION, task.getDescription());

        return db.update(TABLE_NAME, values, TASK_NAME + "=?", new String[]{task.getTaskName()});
    }

    public void deleteTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, TASK_NAME + "=?", new String[]{task.getTaskName()});
        db.close();
    }

    public int getTaskCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public ArrayList<Task> getAllTaskForUser(){
        ArrayList<Task> taskList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + TASK_OWNER + " = " + "\"" + loginID + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setTaskName(cursor.getString(0));
                task.setYear(Integer.parseInt(cursor.getString(1)));
                task.setMonth(Integer.parseInt(cursor.getString(2)));
                task.setDay(Integer.parseInt(cursor.getString(3)));
                task.setHour(Integer.parseInt(cursor.getString(4)));
                task.setMinute(Integer.parseInt(cursor.getString(5)));
                task.setDescription(cursor.getString(6));
                taskList.add(task);
                loginID = cursor.getString(7);

            } while (cursor.moveToNext());
        }

        return taskList;
    }

}
