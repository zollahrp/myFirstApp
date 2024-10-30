package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] nama;
    String[] hp; // Mengubah dari String menjadi String[]
    int[] img;

    public CustomAdapter(Context context, String[] nama, String[] hp, int[] img) {
        super(context, R.layout.list_item, nama);

        this.context = context;
        this.nama = nama;
        this.hp = hp;
        this.img = img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(context); // Menggunakan LayoutInflater dari context
            rowView = inflater.inflate(R.layout.list_item, parent, false);
        }

        ImageView lv_list_item = rowView.findViewById(R.id.im_list_item);
        TextView tv_nama = rowView.findViewById(R.id.tv_nama);
        TextView tv_hp = rowView.findViewById(R.id.tv_hp);

        lv_list_item.setImageResource(img[position]);
        tv_nama.setText(nama[position]);
        tv_hp.setText(hp[position]);

        return rowView;
    }
}
