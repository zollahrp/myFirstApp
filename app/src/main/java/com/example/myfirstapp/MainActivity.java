package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tv_username = findViewById(R.id.tv_username);

        Intent intent = getIntent();

        tv_username.setText(intent.getStringExtra("username"));

        Button btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                startActivity(intent);

                finish();
            }
        });

        String nama[] = {"Zolla", "Putra", "Ayah", "Adrian", "Rival"};
        String hp[] = {"081312343829", "081289326329", "085820012829", "081380530896", "081222417473"};
        int img[] = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

        ListView lv_mhs = findViewById(R.id.lv_mhs);

    //    ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, hp);
        CustomAdapter adapter = new CustomAdapter(this, nama, hp, img);

        lv_mhs.setAdapter(adapter);

        lv_mhs.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
    //            Toast.makeText(getApplicationContext(), mhs[i], Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + hp[i]));

                startActivity(intent);

                return false;
            }
        });
    }
}