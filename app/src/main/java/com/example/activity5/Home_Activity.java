package com.example.activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasikan variabel dengan jenis data ListView
    private ListView list;

    //Memanggil class ListViewAdapter dan di inisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listnama;

    //Memanggil class ClassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //MEmbuat objek Bundle
    Bundle bundle = new Bundle();

    //Membuat objek intent
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Menyimpan nama  didalam array listNama
        listnama = new String[]{"Fajri","Isa","Jaya","Ilham"};
        list = findViewById(R.id.listKontak);

        for (int i =0; i<listnama.length;  i++){
            //membuat objek class nama
            ClassNama classNama = new ClassNama(listnama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }
        //Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //binds adapter ke ListView
        list.setAdapter(adapter);

        //Membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getNama();

                //memasukkan value dari variabel yang berisi dengan kunci "a" dan dimasukkan kedalam bundle
                bundle.putString("a", nama.trim());

                //
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                //
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //
                pm.inflate(R.menu.popup_menu);

                //
                pm.show();
            }
        });


    }



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}