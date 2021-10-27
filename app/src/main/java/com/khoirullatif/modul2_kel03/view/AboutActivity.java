package com.khoirullatif.modul2_kel03.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.khoirullatif.modul2_kel03.R;

public class AboutActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        listView = findViewById(R.id.list_view);
        //Daftar nama dan NIM
        String[] values = new String[] {
                "Alberto Mathew Christopher\t\t21120118170002",
                "Chairullatif Aji Sadewa\t\t21120119120015",
                "Erlin Sofia Sitohang\t\t21120119120014",
                "Mohammad Rifqi Satriamas\t\t21120119130115"
        };

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, R.layout.support_simple_spinner_dropdown_item, values);
        listView.setAdapter(adapter);
    }
}