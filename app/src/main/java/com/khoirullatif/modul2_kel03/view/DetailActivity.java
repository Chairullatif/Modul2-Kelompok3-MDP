package com.khoirullatif.modul2_kel03.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.khoirullatif.modul2_kel03.R;
import com.khoirullatif.modul2_kel03.model.DataItem;
import com.khoirullatif.modul2_kel03.utils.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    private TextView tvEmail, tvName;
    private Integer id;
    private ImageView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvEmail = findViewById(R.id.tv_email);
        tvName = findViewById(R.id.tv_full_name);
        ivPhoto = findViewById(R.id.iv_photo_detail);
        getSupportActionBar().setTitle("");

        if (getIntent().hasExtra("Id")) {
            id = getIntent().getIntExtra("Id",0);
            Log.d(TAG, "onCreate: id= "+id.toString());
//            tvName.setText(id.toString());
        }

        ApiClient.getService().getUser(id).enqueue(new Callback<DataItem>() {
            @Override
            public void onResponse(Call<DataItem> call, Response<DataItem> response) {
                if (response.isSuccessful()) {
                    DataItem user = response.body().getDataItem();
                    String fullName = String.format(getString(R.string.full_name), user.getFirstName(), user.getLastName());
                    tvEmail.setText(user.getEmail());
                    tvName.setText(fullName);
                    Glide.with(DetailActivity.this)
                            .load(user.getAvatar())
                            .into(ivPhoto);
                    getSupportActionBar().setTitle(fullName);
                }
            }

            @Override
            public void onFailure(Call<DataItem> call, Throwable t) {
                Log.d(TAG, "onFailure: response");
            }
        });
    }
}