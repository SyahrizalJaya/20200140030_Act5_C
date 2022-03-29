package com.example.activity5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;




public class ListViewAdapter extends BaseAdapter {

    //Deklarasi variabel dengan jenis data context
    Context mContext;

    //Deklarasi variabel denghan jenis data layout inflater
    LayoutInflater inflater;

    //Deklarasi variable denngan jenis data arraylist
    private ArrayList<ClassNama> arrayList;


    //Membuat konstruktor Listviewadapter
    public  ListViewAdapter(Context context){
        //membari nilai mCOntext dengan context
        mContext = context;

        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arryalist dari class ClassNama
        this.arrayList= new ArrayList<ClassNama>();

        //Menambahkan semua elemen ke arryalist
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }
    public class ViewHolder{
        //mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return Home_Activity.classNamaArrayList.size();
    }

    /*fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    * tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi tertentu dalam
    * pengumpulan data item*/
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //mengembalikan nilai dari posisi ke adaptor
    @Override
    public long getItemId(int i) {

        return i;
    }

    //fungsi ini otomatis dipanggil ketika tampilan item list siap untuk ditampilkan
    // atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //membuat variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if(view==null){

            //membuat objek view holder
            holder = new ViewHolder();

            //Mengaturlayout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textView
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        }else {
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //Set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getNama());

        //mengembalikan nilai ke variabel view
        return view;



    }
}
