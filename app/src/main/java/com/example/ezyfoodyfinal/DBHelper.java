package com.example.ezyfoodyfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.ezyfoodyfinal.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "ezyfoody.db";
    final static int DBVERSION = 2;

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table orders "+"(id integer primary key autoincrement," +
                        "foodname text," +
                        "foodprice int, " +
                        "foodimage int," +
                        "quantity int," +
                        "address text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists orders");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String foodname, int foodprice, int foodimage, String address, String quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put("foodname",foodname);
        value.put("foodprice",foodprice);
        value.put("foodimage",foodimage);
        value.put("address",address);
        value.put("quantity",quantity);
        long id = database.insert("orders",null,value);
        if(id <= 0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<OrderModel> getOrder(){
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,foodprice,foodimage,address,quantity from orders", null);
            if(cursor.moveToFirst()){
                while(cursor.moveToNext()){
                    OrderModel model = new OrderModel(0,null,null,null,null,null,null);
                    model.setOrderNum(cursor.getInt(0)+"");
                    model.setOrdername(cursor.getString(1));
                    model.setOrderprice(cursor.getInt(2) +"");
                    model.setOrderImage(cursor.getInt(3));
                    model.setAddress(cursor.getString(4));
                    model.setQuantity(cursor.getString(5));
                    orders.add(model);
                }
            }

            cursor.close();
            database.close();
            return orders;
    }

    public int deletedOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }
}