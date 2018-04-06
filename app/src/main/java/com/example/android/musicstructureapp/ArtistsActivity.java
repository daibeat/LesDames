package com.example.android.musicstructureapp;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

/**
 * Created by davidchazarrabru on 19/3/18.
 */

public class ArtistsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        TextView david = (TextView) findViewById(R.id.web_david);
        david.setMovementMethod(LinkMovementMethod.getInstance());

        TextView alfons = (TextView) findViewById(R.id.web_alfons);
        alfons.setMovementMethod(LinkMovementMethod.getInstance());

    }
}