package com.example.android.musicstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by davidchazarrabru on 16/3/18.
 */

public class VidrierasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_vidrieras);

        TextView museu = (TextView) findViewById(R.id.web_museo);
        museu.setMovementMethod(LinkMovementMethod.getInstance());

}
}
