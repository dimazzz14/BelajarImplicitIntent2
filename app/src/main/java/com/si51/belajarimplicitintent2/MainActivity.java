package com.si51.belajarimplicitintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etLink, etLokasi, etTeks;
    private Button btnLink, btnLokasi, btnBagikanTeks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLink = findViewById(R.id.et_url);
        etLokasi = findViewById(R.id.et_lokasi);
        etTeks = findViewById(R.id.et_teks);

        btnLink = findViewById(R.id.btn_buka_link);
        btnLokasi = findViewById(R.id.btn_buka_lokasi);
        btnBagikanTeks = findViewById(R.id.btn_bagikan_teks);

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String link = etLink.getText().toString(); // untuk nangkep nilai edittext link di activity_main
                Uri uriLink = Uri.parse(link);//parsing nilai dalem bentuk Uri-android.net (link di convert dalem bentuk uri)
                Intent bukaWebsite = new Intent(Intent.ACTION_VIEW, uriLink);

                try{
                    startActivity(bukaWebsite);
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Link harus lengkap atau link salah!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lokasi = etLokasi.getText().toString();
                Uri urilokasi = Uri.parse("geo:0,0?q="+lokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, urilokasi);
                startActivity(bukaLokasi);

            }
        });

        btnBagikanTeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}