package com.khoirullatif.modul2_kel03.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.khoirullatif.modul2_kel03.model.DataItem;
import com.khoirullatif.modul2_kel03.R;
import com.khoirullatif.modul2_kel03.view.DetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private List<DataItem> dataUser;
    private Context mContext;

    public RecycleAdapter(List<DataItem> dataUser, Context context) {
        this.dataUser = dataUser;
        this.mContext = context;
    }

    @NonNull
    @NotNull
    @Override

    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_list_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecycleAdapter.ViewHolder holder, int position) {
        holder.tvFirstName.setText(dataUser.get(position).getFirstName());
        holder.tvLastName.setText(dataUser.get(position).getLastName());
        holder.tvEmail.setText(String.format("Email : %s", dataUser.get(position).getEmail()));
        Glide.with(mContext)
                .load(dataUser.get(position).getAvatar())
                .into(holder.imgPhotoUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Id", dataUser.get(position).getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPhotoUser;
        private TextView tvFirstName, tvLastName, tvEmail;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imgPhotoUser = itemView.findViewById(R.id.img_photo_user);
            tvFirstName = itemView.findViewById(R.id.tv_item_first_name);
            tvLastName = itemView.findViewById(R.id.tv_full_name);
            tvEmail = itemView.findViewById(R.id.tv_item_email);

        }
    }
}
