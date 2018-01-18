package com.example.admin.schedulemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private Button mBtnBack;
    ListView lvCv;
    ArrayList<JobInWeek> list = new ArrayList<JobInWeek>();
    ArrayAdapter<JobInWeek>adapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        lvCv=(ListView) findViewById(R.id.lvcongviec);

        list = (ArrayList<JobInWeek>) getIntent().getSerializableExtra("result");

        adapter = new ArrayAdapter<JobInWeek>(DetailActivity.this, android.R.layout.simple_list_item_1, list);
        lvCv.setAdapter(adapter);

        mBtnBack = (findViewById(R.id.btn_back));
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(DetailActivity.this, MainActivity.class);
                myIntent.putExtra("list", list);
                startActivity(myIntent);
            }
        });

    }
}
