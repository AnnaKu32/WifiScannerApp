package android.example.com.aplikacja1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Context context;
    ArrayList<String> id, connection, ip, speed, rssi, mac, ssid, bssid, frequency;

    CustomerAdapter(Context context,
                         ArrayList id,
                         ArrayList connection,
                         ArrayList ip,
                         ArrayList speed,
                         ArrayList rssi,
                         ArrayList mac,
                         ArrayList ssid,
                         ArrayList bssid,
                         ArrayList frequency){
            this.context = context;
            this.connection = connection;
            this.ip = ip;
            this.speed = speed;
            this.rssi = rssi;
            this.mac = mac;
            this.ssid = ssid;
            this.bssid = bssid;
            this.frequency = frequency;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}
