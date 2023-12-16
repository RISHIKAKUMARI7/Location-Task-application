package com.example.nearest_offer;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    ArrayList<mytask> mList;
    private final MyAdapter.RecyclerViewClickListener listener;

    public MyAdapter(ArrayList<mytask> mList, MyAdapter.RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mytask vacancy1 = mList.get(position);
        holder.txtbname.setText("Task Name "+vacancy1.getName());
        holder.txtaddress.setText("Address "+vacancy1.getAddress());
        holder.txttype.setText("Description "+vacancy1.getDescription());

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
