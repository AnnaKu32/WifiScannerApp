package android.example.com.aplikacja1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class GetTextViewInfo extends AppCompatActivity {

    private WifiManager wifiManager;

//    private TextView textRSSI;
//    private TextView textIP;
//    private TextView textFrequency;
//    private TextView textMacAddress;
//    private TextView textSpeed;
//    private TextView textSSID;
//    private TextView textBSSID;
//    private TextView textconnection;

//    String ip;
//    String ssid;
//    int speed;
//    int rssi;
//    String mac;
//    String bssid;
//    int frequency;
//    String connection;


//    public TextView getTextRSSI() {return textRSSI;}
//    public void setTextRSSI(TextView textRSSI) {this.textRSSI = textRSSI;}
//    public TextView getTextIP() {return textIP;}
//    public void setTextIP(TextView textIP) {this.textIP = textIP;}
//    public TextView getTextFrequency() {return textFrequency;}
//    public void setTextFrequency(TextView textFrequency) {this.textFrequency = textFrequency;}
//    public TextView getTextMacAddress() {return textMacAddress;}
//    public void setTextMacAddress(TextView textMacAddress) {this.textMacAddress = textMacAddress;}
//    public TextView getTextSpeed() {return textSpeed;}
//    public void setTextSpeed(TextView textSpeed) {this.textSpeed = textSpeed;}
//    public TextView getTextSSID() {return textSSID;}
//    public void setTextSSID(TextView textSSID) {this.textSSID = textSSID;}
//    public TextView getTextBSSID() {return textBSSID;}
//    public void setTextBSSID(TextView textBSSID) {this.textBSSID = textBSSID;}
//    public TextView getTextconnection() {return textconnection;}
//    public void setTextconnection(TextView textconnection) {this.textconnection = textconnection;}
//
//
//    public String getIp() {return ip;}
//    public void setIp(String ip) {this.ip = ip;}
//    public String getSsid() {return ssid;}
//    public void setSsid(String ssid) {this.ssid = ssid;}
//    public String getBssid() {return bssid;}
//    public void setBssid(String bssid) {this.bssid = bssid;}
//    public int getFrequency() {return frequency; }
//    public void setFrequency(int frequency) { this.frequency = frequency; }
//    public int getSpeed() { return speed; }
//    public void setSpeed(int speed) { this.speed = speed; }
//    public int getRssi() { return rssi; }
//    public void setRssi(int rssi) { this.rssi = rssi; }
//    public String getMac() { return mac; }
//    public void setMac(String mac) { this.mac = mac;}
//    public String getConnection() {return connection; }
//    public void setConnection(String connection) {this.connection = connection;}


//    public static String getMacAddr() {
//        try {
//            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
//            for (NetworkInterface nif : all) {
//                if (!nif.getName().equalsIgnoreCase("wlan0")) continue;
//
//                byte[] macBytes = nif.getHardwareAddress();
//                if (macBytes == null) {
//                    return "";
//                }
//
//                StringBuilder res1 = new StringBuilder();
//                for (byte b : macBytes) {
//                    res1.append(Integer.toHexString(b & 0xFF) + ":");
//                }
//
//                if (res1.length() > 0) {
//                    res1.deleteCharAt(res1.length() - 1);
//                }
//                return res1.toString();
//            }
//        } catch (Exception ex) {
//            //handle exception
//        }
//        return "";
//    }

//    public void getWIFIInfo(){
//        wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
//        wifiManager.setWifiEnabled(true);
//        WifiInfo wifiinfo = wifiManager.getConnectionInfo();
//        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkinfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//
//        try {
//            Toast.makeText(getApplicationContext(), "wifimanager getConnectionInfo() success", Toast.LENGTH_SHORT).show();
//        }
//        catch (Exception e) {
//            //wyświetlanie błędów
//            e.printStackTrace();
//        }
//
//        //-----------------     pobieranie danych   ---------------------//
//        String ip= Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
//        String ssid = wifiinfo.getSSID();
//        int speed = wifiinfo.getLinkSpeed();
//        int rssi = wifiinfo.getRssi();
//        String mac = getMacAddr();
//        String bssid = wifiinfo.getBSSID();
//        int frequency = wifiinfo.getFrequency();
//
//
//        if(networkinfo.isConnected()){
//            String connection = "Connected";
//            textconnection.setText(connection);
//            textIP.setText(ip);
//            textSpeed.setText(String.valueOf(speed) + " " + wifiinfo.LINK_SPEED_UNITS);
//            textRSSI.setText(String.valueOf(rssi));
//            textMacAddress.setText(mac);
//            textSSID.setText(ssid);
//            textBSSID.setText(bssid);
//            textFrequency.setText(String.valueOf(frequency));
//        }
//        else{
//            String connection = "Disconnected";
//            textconnection.setText(connection);
//            textIP.setText("---");
//            textSpeed.setText("---");
//            textRSSI.setText("---");
//            textMacAddress.setText("---");
//            textSSID.setText("---");
//            textBSSID.setText("---");
//            textFrequency.setText("---");
//        }
//    }


}
