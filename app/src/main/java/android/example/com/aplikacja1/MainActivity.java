package android.example.com.aplikacja1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//-------------------------------------------------------------------------------//
//deklaracja klasy MainActivity, która rozszerza AppCompatActivity
//AppCompatActivity to podklasa Activity, która obsługuje funkcje Androida
public class MainActivity<textRssi> extends AppCompatActivity {

    private int WIFI_PERMISSION_CODE = 1;

    RecyclerView recyclerView;
    FloatingActionButton Button2;

    DataBase mydb;
    ArrayList<String> id, connection, ip, speed, rssi, mac, ssid, bssid, frequency;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //określa, który layout jest przypisany do aktywności (np. ten do activity_main.xml)
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        Button2 = findViewById(R.id.Button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Wifi_Scanner_Information.class);
                startActivity(intent);
            }
        });

        mydb = new DataBase(MainActivity.this);
        id = new ArrayList<>();
        connection = new ArrayList<>();
        ip = new ArrayList<>();
        speed = new ArrayList<>();
        rssi = new ArrayList<>();
        mac = new ArrayList<>();
        ssid = new ArrayList<>();
        bssid = new ArrayList<>();
        frequency = new ArrayList<>();

        informationInArrays();

        Button buttonRequest = findViewById(R.id.button);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "You have already granted this permission!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    requestWIFIPermission();
                }
            }
        });
    }

    void informationInArrays(){
        Cursor cursor = mydb.listData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Brak Skanów", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));
                connection.add(cursor.getString(1));
                ip.add(cursor.getString(2));
                speed.add(cursor.getString(3));
                rssi.add(cursor.getString(4));
                mac.add(cursor.getString(5));
                ssid.add(cursor.getString(6));
                bssid.add(cursor.getString(7));
                frequency.add(cursor.getString(8));

            }
        }
    }



    //funkcja do zdobycia przyzwolenia do ACCESS_WIFI_STATE
    private void requestWIFIPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_WIFI_STATE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed for WIFI access")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[]{Manifest.permission.ACCESS_WIFI_STATE}, WIFI_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_WIFI_STATE}, WIFI_PERMISSION_CODE);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == WIFI_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}









