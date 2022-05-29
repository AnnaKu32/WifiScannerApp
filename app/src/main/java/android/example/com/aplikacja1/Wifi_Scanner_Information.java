package android.example.com.aplikacja1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class Wifi_Scanner_Information extends AppCompatActivity {

    private WifiManager wifiManager;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_scanner_information);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
        WifiInfo wifiinfo = wifiManager.getConnectionInfo();
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkinfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        TextView textconnection = (TextView) findViewById(R.id.textconnection);
        String connection;
        if(networkinfo.isConnected()){
            connection = "Connected";
            textconnection.setText("Status: " + connection);
        }
        else{
            connection = "Disconnected";
            textconnection.setText(connection);
        }

        TextView textIP = (TextView) findViewById(R.id.ip);
        String ip=Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        textIP.setText("IP: " + ip);

        TextView textSpeed = (TextView) findViewById(R.id.speed);
        int speed = wifiinfo.getLinkSpeed();
        textSpeed.setText("Speed: " + String.valueOf(speed) + " " + wifiinfo.LINK_SPEED_UNITS);

        TextView textFrequency = (TextView) findViewById(R.id.frequency);
        int frequency = wifiinfo.getFrequency();
        textFrequency.setText("Frequency: "+String.valueOf(frequency) + "MHz");

        TextView textRSSI = (TextView) findViewById(R.id.rssi);
        int rssi = wifiinfo.getRssi();
        textRSSI.setText("RSSI: " + String.valueOf(rssi));

        TextView textMacAddress = (TextView) findViewById(R.id.mac);
        String mac = getMacAddr();
        textMacAddress.setText("Mac Address: " + mac);

        TextView textSSID = (TextView) findViewById(R.id.ssid);
        String ssid = wifiinfo.getSSID();
        textSSID.setText("SSID: " + ssid);

        TextView textBSSID = (TextView) findViewById(R.id.bssid);
        String bssid = wifiinfo.getBSSID();
        textBSSID.setText("BSSID: "+ bssid);


        Button save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBase myDB = new DataBase(Wifi_Scanner_Information.this);
                myDB.addInfo(connection, ip, speed, rssi, mac, ssid, bssid, frequency);

            }
        });
    }


    private TextView textRSSI;
    private TextView textIP;
    private TextView textFrequency;
    private TextView textMacAddress;
    private TextView textSpeed;
    private TextView textSSID;
    private TextView textBSSID;
    private TextView textconnection;


    public static String getMacAddr() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

                byte[] macBytes = nif.getHardwareAddress();
                if (macBytes == null) {
                    return "";
                }

                StringBuilder res1 = new StringBuilder();
                for (byte b : macBytes) {
                    res1.append(Integer.toHexString(b & 0xFF) + ":");
                }

                if (res1.length() > 0) {
                    res1.deleteCharAt(res1.length() - 1);
                }
                return res1.toString();
            }
        } catch (Exception ex) {
            //handle exception
        }
        return "";
    }
}
