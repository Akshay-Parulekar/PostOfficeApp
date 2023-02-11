package com.example.postofficeapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postofficeapp.R;
import com.example.postofficeapp.helper.Helper;
import com.example.postofficeapp.model.PincodeDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PincodeDetailsAdapter extends RecyclerView.Adapter<PincodeDetailsAdapter.MyViewHolder>
{
    List<PincodeDetails> list;
    Context context;

    public PincodeDetailsAdapter(Context context, List<PincodeDetails> list) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pincode_details, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        PincodeDetails pincodeDetails = list.get(position);
        holder.tvPincode.setText(pincodeDetails.getPincode() + "");
        holder.tvDivision.setText(pincodeDetails.getDivision().trim());
        holder.tvDelivery.setText(pincodeDetails.getDelivery().trim());
        holder.tvRegion.setText(pincodeDetails.getRegion().trim());
        holder.tvOfficeType.setText(pincodeDetails.getOfficeType().trim());
        holder.tvOffice.setText(pincodeDetails.getOffice().trim());
        holder.tvCircle.setText(pincodeDetails.getCircle().trim());
        holder.tvLocation.setText(pincodeDetails.getState().trim() + " > " + pincodeDetails.getDistrict().trim());

        holder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap(pincodeDetails.getLatitude(), pincodeDetails.getLongitude());
            }
        });

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap(pincodeDetails.getLatitude(), pincodeDetails.getLongitude());
            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvPincode, tvCircle, tvRegion, tvDivision, tvOffice, tvOfficeType, tvDelivery, tvLocation;
        ImageButton btnLocation;
        CardView card;

        public MyViewHolder(@NonNull View root) {
            super(root);
            card = root.findViewById(R.id.card);
            tvPincode = root.findViewById(R.id.tvPincode);
            tvCircle = root.findViewById(R.id.tvCircle);
            tvRegion = root.findViewById(R.id.tvRegion);
            tvDivision = root.findViewById(R.id.tvDivision);
            tvOffice = root.findViewById(R.id.tvOffice);
            tvOfficeType = root.findViewById(R.id.tvOfficeType);
            tvDelivery = root.findViewById(R.id.tvDelivery);
            tvLocation = root.findViewById(R.id.tvLocation);
            btnLocation = root.findViewById(R.id.btnLocation);
        }
    }

    public void openMap(double lat, double lon)
    {
        Uri gmmIntentUri = Uri.parse("geo:" + lat + "," + lon + "?z=50");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
    }
}