package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mText = (TextView)findViewById(R.id.tv_detail);
        Intent intent = getIntent();
        if (intent.hasExtra(FORECAST_SHARE_HASHTAG)){
            String text = intent.getStringExtra(FORECAST_SHARE_HASHTAG);
            mText.setText(text);
        }
    }
}