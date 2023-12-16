package com.example.nearest_offer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {


    ArrayList<Myoffer> mList;
    private final OfferAdapter.RecyclerViewClickListener listener;

    public OfferAdapter(ArrayList<Myoffer> mList, OfferAdapter.RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Myoffer vacancy1 = mList.get(position);
        holder.txtbname.setText("Shop Name "+vacancy1.getName());
        holder.txtaddress.setText("Address "+vacancy1.getAddress());
        holder.txttype.setText("Offer "+vacancy1.getOffer());
        holder.txtitem4.setText("Mobile NO:"+vacancy1.getNumber());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtbname,txtaddress,txttype,txtitem4,txtitem5;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);
            txtitem4 = itemView.findViewById(R.id.txtitem4);

            txtitem5 = itemView.findViewById(R.id.txtitem5);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }
}
