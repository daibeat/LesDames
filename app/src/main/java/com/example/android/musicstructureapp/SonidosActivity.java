package com.example.android.musicstructureapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by davidchazarrabru on 16/3/18.
 */

public class SonidosActivity extends AppCompatActivity {

    /**
     * Handles playback of all the sound files
     */

    private MediaPlayer mMediaPlayer;


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);


        //Create a list of sounds

        final ArrayList<Sounds> sounds = new ArrayList<Sounds>();

        //sounds.add ("one");

        sounds.add(new Sounds("escales", "stairs", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("gronxador", "swing", R.drawable.detalle_reproduccion,
                R.raw.shortsong));
        sounds.add(new Sounds("font", "fountain", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("colom", "pigeon", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("cigne", "swans", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("llac", "lake", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("campanes", "bells", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("cants", "chants", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("trepitjades", "steps", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("suspir", "sigh", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("joies", "jewels", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));
        sounds.add(new Sounds("tormenta", "storm", R.drawable.detalle_reproduccion,
                R.raw.test__theshaggyfreak__waves_on_the_lake));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // list_item.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.

        SoundsAdapter adapter = new SoundsAdapter(this, sounds, R.color.category_sonidos);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_sonidos layout file.

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                // Get the {@link Sounds} object at the given position the user clicked on
                Sounds sound = sounds.get(position);

                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(SonidosActivity.this, sound.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }

        });


    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}