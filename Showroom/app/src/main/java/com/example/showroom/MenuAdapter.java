package com.example.showroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private Context context;
    private ArrayList<Menu> menus;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void SetOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public MenuAdapter(Context ncontext, ArrayList<Menu> menukendaraan){
        context=ncontext;
        menus=menukendaraan;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);

        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menubaru= menus.get(position);
        String gambarbaru = menubaru.getGambar();
        String harga = menubaru.getHarga();
        String nama = menubaru.getNama();
        String keterangan = menubaru.getKeterangan();

        holder.tvnamadata.setText(nama);
        holder.tvhargadata.setText(harga);
        holder.tvketerangandata.setText(keterangan);
        Glide
                .with(context)
                .load(gambarbaru)
                .centerCrop()
                .into(holder.imdata);

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        public ImageView imdata;
        public TextView tvhargadata;
        public TextView tvnamadata;
        public TextView tvketerangandata;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imdata= itemView.findViewById(R.id.img_menu);
            tvhargadata=itemView.findViewById(R.id.tv_harga);
            tvnamadata=itemView.findViewById(R.id.tv_nama);
            tvketerangandata=itemView.findViewById(R.id.tv_keterangan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }

}