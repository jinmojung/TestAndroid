package kr.codesolutions.landlord.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import kr.codesolutions.landlord.vo.Tenant;

public class DbOpenHelper {

    private static final String DATABASE_NAME = "landlord.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase mDB;
    private DatabaseHelper mDBHelper;
    private Context mCtx;

    public DbOpenHelper(Context context){
        this.mCtx = context;
    }

    public DbOpenHelper open() throws SQLException{
        mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
        mDB = mDBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        mDB.close();
    }

    // Insert DB
    public long insertColumn(String name, String smsKeyWord, String price, String address){
        ContentValues values = new ContentValues();
        values.put(DataBases.Tenant.NAME, name);
        values.put(DataBases.Tenant.SMS_KEY_WORD, smsKeyWord);
        values.put(DataBases.Tenant.PRICE, price);
        values.put(DataBases.Tenant.ADDRESS, address);
        return mDB.insert(DataBases.Tenant._TABLENAME, null, values);
    }

    // Update DB
    public boolean updateColumn(long id , String name, String smsKeyWord, String price, String address){
        ContentValues values = new ContentValues();
        values.put(DataBases.Tenant.NAME, name);
        values.put(DataBases.Tenant.SMS_KEY_WORD, smsKeyWord);
        values.put(DataBases.Tenant.PRICE, price);
        values.put(DataBases.Tenant.ADDRESS, address);
        return mDB.update(DataBases.Tenant._TABLENAME, values, "_id="+id, null) > 0;
    }

    // Delete ID
    public boolean deleteColumn(long id){
        return mDB.delete(DataBases.Tenant._TABLENAME, "_id="+id, null) > 0;
    }

    // Select All
    public List<Tenant> getAllColumns(){
        List<Tenant> result =  new ArrayList<Tenant>();
        Cursor cursor = mDB.query(DataBases.Tenant._TABLENAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Tenant tenant = new Tenant();
            tenant.setName(cursor.getString(cursor.getColumnIndex(DataBases.Tenant.NAME)));
            tenant.setSmsKeyWord(cursor.getString(cursor.getColumnIndex(DataBases.Tenant.SMS_KEY_WORD)));
            tenant.setPrice(cursor.getString(cursor.getColumnIndex(DataBases.Tenant.PRICE)));
            tenant.setAddress(cursor.getString(cursor.getColumnIndex(DataBases.Tenant.ADDRESS)));
            result.add(tenant);
        }
        cursor.close();
        return result;
    }

    // ID 컬럼 얻어 오기
    public Cursor getColumn(long id){
        Cursor c = mDB.query(DataBases.Tenant._TABLENAME, null,
                "_id="+id, null, null, null, null);
        if(c != null && c.getCount() != 0){
            c.moveToFirst();
        }
        return c;
    }

    // 이름 검색 하기 (rawQuery)
    public Cursor getMatchName(String name){
        Cursor c = mDB.rawQuery( "select * from address where name=" + "'" + name + "'" , null);
        return c;
    }

    private class DatabaseHelper extends SQLiteOpenHelper{

        // 생성자
        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        // 최초 DB를 만들때 한번만 호출된다.
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DataBases.Tenant._CREATE);

        }

        // 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DataBases.Tenant._TABLENAME);
            onCreate(db);
        }
    }

}
