package com.example.android.musicstructureapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Set;

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
    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Now that the sound file has finished playing, release the media player
                    // resources.
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

        sounds.add(new Sounds(getString(R.string.escales), getString(R.string.stairs), R.drawable.dames_rep,
                R.raw.escaleras));
        sounds.add(new Sounds(getString(R.string.ocells), getString(R.string.birds), R.drawable.dames_rep,
                R.raw.pajaros));
        sounds.add(new Sounds(getString(R.string.font), getString(R.string.fountain), R.drawable.dames_rep,
                R.raw.fuente));
        sounds.add(new Sounds(getString(R.string.colom), getString(R.string.pigeon), R.drawable.dames_rep,
                R.raw.palomas));
        sounds.add(new Sounds(getString(R.string.cigne), getString(R.string.swans), R.drawable.dames_rep,
                R.raw.cisnes2));
        sounds.add(new Sounds(getString(R.string.llac), getString(R.string.lake), R.drawable.dames_rep,
                R.raw.lago));
        sounds.add(new Sounds(getString(R.string.campanes), getString(R.string.bells), R.drawable.dames_rep,
                R.raw.campanas));
        sounds.add(new Sounds(getString(R.string.cants), getString(R.string.chants), R.drawable.dames_rep,
                R.raw.cantos));
        sounds.add(new Sounds(getString(R.string.trepitjades), getString(R.string.steps), R.drawable.dames_rep,
                R.raw.pisadas));
        sounds.add(new Sounds(getString(R.string.suspir), getString(R.string.sigh), R.drawable.dames_rep,
                R.raw.suspiro));
        sounds.add(new Sounds(getString(R.string.gronxador), getString(R.string.swing), R.drawable.dames_rep,
                R.raw.columpio));
        sounds.add(new Sounds(getString(R.string.tormenta), getString(R.string.storm),
                R.drawable.dames_rep,
                R.raw.lago));
         /**
         *Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
         *adapter knows how to create layouts for each item in the list, using the
         *list_item.xml layout resource defined in the Android framework.
         *This list item layout contains a single {@link TextView}, which the adapter will set to
         *display a single word.
          */

        SoundsAdapter adapter = new SoundsAdapter(this, sounds, R.color.category_sonidos);

        /**
         * Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
         * There should be a {@link ListView} with the view ID called list, which is declared in the
         * activity_sonidos layout file.
         * */

        ListView listView = (ListView) findViewById(R.id.list);

        /**
         *Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
         *{@link ListView} will display list items for each sound in the list of sounds.
         *Do this by calling the setAdapter method on the {@link ListView} object and pass in
         *1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
         */

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
                mMediaPlayer = MediaPlayer.create(SonidosActivity.this,
                        sound.getAudioResourceId());

                // Start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        /** When the activity is stopped, release the media player resources because we won't
         * be playing any more sounds.
         */
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            /** Regardless of the current state of the media player, release its resources
            * because we no longer need it
             * */
            mMediaPlayer.release();

            /**
             *Set the media player back to null. For our code, we've decided that
             * setting the media player to null is an easy way to tell that the media player
             * is not configured to play an audio file at the moment.
             */

            mMediaPlayer = null;
        }
    }
}