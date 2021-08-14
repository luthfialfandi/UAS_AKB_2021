// Tgl Pengerjaan : 9 Agustus 2021
// NIM            : 10118351
// Nama           : Luthfi Alfandi
// Kelas          : IF-8

package com.tugas.uasAKB_10118351.View.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tugas.uasAKB_10118351.Model.WisataModel;
import com.tugas.uasAKB_10118351.R;
import com.tugas.uasAKB_10118351.View.WisataActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ViewHolder>{

    private ArrayList<WisataModel> wisataModels;
    private Context context;
    private Activity act;

    public ListWisataAdapter(ArrayList<WisataModel> wisataModel, Context context, Activity act){
        this.wisataModels = wisataModel;
        this.context = context;
        this.act = act;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ListWisataAdapter.ViewHolder holder, int position) {
        WisataModel wisataModel = wisataModels.get(position);
        Glide.with(context).load(wisataModel.getImg()).into(holder.foto);
        holder.nama.setText(wisataModel.getNama());
        holder.deskripsi.setText(wisataModel.getDesc());
        holder.item.setOnClickListener(v -> {
            Intent intent = new Intent(act, WisataActivity.class);
            intent.putExtra("nama", wisataModel.getNama());
            intent.putExtra("deskripsi", wisataModel.getDesc());
            intent.putExtra("foto", wisataModel.getImg());
            intent.putExtra("lat", wisataModel.getLatLng().latitude);
            intent.putExtra("lng", wisataModel.getLatLng().longitude);
            act.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wisataModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView deskripsi;
        ImageView foto;
        ConstraintLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.listnama);
            deskripsi = itemView.findViewById(R.id.listdeskripsi);
            foto = itemView.findViewById(R.id.listfoto);
            item = itemView.findViewById(R.id.item);
        }
    }

}
