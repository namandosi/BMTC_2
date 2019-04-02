package myapp.bmtc.com.bmtc_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String dob, String num, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.DOB, dob);
        contentValues.put(myDbHelper.NUM, num);
        contentValues.put(myDbHelper.PASS, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NAME,myDbHelper.DOB,myDbHelper.PASS,myDbHelper.NUM};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
//            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  dob =cursor.getString(cursor.getColumnIndex(myDbHelper.DOB));
            String  pass =cursor.getString(cursor.getColumnIndex(myDbHelper.PASS));
            String  num =cursor.getString(cursor.getColumnIndex(myDbHelper.NUM));
            buffer.append(name + "   " + dob +"   "+pass+"   "+num+" \n");
        }
        return buffer.toString();
    }

    public long checkData(String phone, String pass) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NUM,myDbHelper.PASS};
        String selection = myDbHelper.NUM + " = ?" + " AND " + myDbHelper.PASS + " = ?";
        String[] selectionArgs = {phone, pass};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return 100;
        }

        return -100;
    }
    public long checkPhone(String phone) {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.NUM};
        String selection = myDbHelper.NUM + " = ?";
        String[] selectionArgs = {phone};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return 100;
        }

        return -100;
    }
    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "BMTC_DB";    // Database Name
        private static final String TABLE_NAME = "UserDetails";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        //        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "User_name";    //Column II
        private static final String DOB= "User_DOB";    // Column III
        private static final String PASS="User_pass";
        private static final String NUM = "User_num";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+NAME+" VARCHAR(255) ,"+ DOB+" VARCHAR(225), "+PASS+"  VARCHAR(225), "+NUM+" VARCHAR(225) PRIMARY KEY)";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }
}
