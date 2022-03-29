package com.example.activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityLihatData extends AppCompatActivity {

    //Deklarasi variabel dengan jenis data TextView
    TextView tvnama,tvnomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        //membuat variable dengan jenis data bundle dan assign value dari variabel tersebut dengan getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel nama dan assign value dari pesan yang dikirimkan dari acivity sebelumnya
        String nama = bundle.getString("a");

        switch (nama)
        {
            case "Fajri":
                tvnama.setText("M. Fatchul Fajri");
                tvnomor.setText("081234567890");
                break;
            case "Isa":
                tvnama.setText("Isa Jaisyullah Hamid");
                tvnomor.setText("082345678910");
                break;
            case "Jaya":
                tvnama.setText("Syahrizal Muhammad Nurjaya");
                tvnomor.setText("087866874716");
                break;
            case "Ilham":
                tvnama.setText("Ilham Ardy Pratama");
                tvnomor.setText("081627193817");
                break;
        }
    }
}