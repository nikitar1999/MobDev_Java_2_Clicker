package com.example.myapplication_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.text_view);
        tv.setText(getString(R.string.hellojava));

        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tv.setText(getString(R.string.Text_updated));
    }
}
