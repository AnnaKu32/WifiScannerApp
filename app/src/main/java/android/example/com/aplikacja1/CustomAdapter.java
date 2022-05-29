package android.example.com.aplikacja1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> id, connection, ip, speed, rssi, mac, ssid, bssid, frequency;


    CustomAdapter(Context context,
                         ArrayList id,
                         ArrayList connection,
                         ArrayList ip,
                         ArrayList speed,
                         ArrayList rssi,
                         ArrayList mac,
                         ArrayList ssid,
                         ArrayList bssid,
                         ArrayList frequency) {
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.textid.setText(String.valueOf(id.get(position)));
        holder.textconnection.setText(String.valueOf(connection.get(position)));
        holder.textip.setText(String.valueOf(ip.get(position)));
        holder.textspeed.setText(String.valueOf(speed.get(position)));
        holder.textrssi.setText(String.valueOf(rssi.get(position)));
        holder.textmac.setText(String.valueOf(mac.get(position)));
        holder.textssid.setText(String.valueOf(ssid.get(position)));
        holder.textbssid.setText(String.valueOf(bssid.get(position)));
        holder.textfrequency.setText(String.valueOf(frequency.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textid, textconnection, textip, textspeed, textrssi, textmac, textssid, textbssid, textfrequency;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textid = itemView.findViewById(R.id.textid);
            textconnection = itemView.findViewById(R.id.textconnection);
            textip = itemView.findViewById(R.id.textip);
            textspeed = itemView.findViewById(R.id.textspeed);
            textrssi = itemView.findViewById(R.id.textrssi);
            textmac = itemView.findViewById(R.id.textmac);
            textssid = itemView.findViewById(R.id.textssid);
            textbssid = itemView.findViewById(R.id.textbssid);
            textfrequency= itemView.findViewById(R.id.textfrequency);

        }
    }
}
