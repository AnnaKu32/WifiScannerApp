package android.example.com.aplikacja1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class DataBase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "WifiDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "wifi_informations";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CONNECTION = "connection";
    private static final String COLUMN_FREQUENCY = "frequency";
    private static final String COLUMN_RSSI = "rssi";
    private static final String COLUMN_IP = "ip";
    private static final String COLUMN_MACADDRESS = "macaddress";
    private static final String COLUMN_SPEED = "speed";
    private static final String COLUMN_SSID = "ssid";
    private static final String COLUMN_BSSID = "bssid";
    private static final String COLUMN_DISTANCE = "distance";

    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CONNECTION + " TEXT, " +
                        COLUMN_IP + " TEXT, " +
                        COLUMN_SPEED + " INTEGER, " +
                        COLUMN_RSSI + " INTEGER, " +
                        COLUMN_MACADDRESS + " TEXT, " +
                        COLUMN_SSID + " TEXT, " +
                        COLUMN_BSSID + " TEXT, " +
                        COLUMN_FREQUENCY + " INTEGER, " +
                        COLUMN_DISTANCE + " DOUBLE);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addInfo(String connection, String ip, int speed, int rssi, String mac, String ssid,
                 String bssid, int frequency, double distance){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_CONNECTION, connection);
        cv.put(COLUMN_IP, ip);
        cv.put(COLUMN_SPEED, speed);
        cv.put(COLUMN_RSSI, rssi);
        cv.put(COLUMN_MACADDRESS, mac);
        cv.put(COLUMN_SSID, ssid);
        cv.put(COLUMN_BSSID, bssid);
        cv.put(COLUMN_FREQUENCY, frequency);
        cv.put(COLUMN_DISTANCE, distance);
        long result = db.insert(TABLE_NAME,null,cv);
        //nie udalo sie dodac danych do bazy
        if(result == -1){
            Toast.makeText(context, "Failed to Add Wifi Information To Database", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Success to Add Wifi Information To Database", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor listData(){
        String query = "SELECT *  FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
