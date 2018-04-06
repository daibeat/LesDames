package com.example.android.musicstructureapp;


/**
 * Created by davidchazarrabru on 15/3/18. This @link Sounds, contains the catalan and english
 * version of the sounds
 */

public class Sounds {

    /**
     * Catalan translation for the word
     */

    private String mCatalan;

    /**
     * English translation for the word
     */

    private String mIngles;

    /**
     * Image resource ID for the word
     */

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Audio resource ID for the word
     */

    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param catalan         is the word in catalan
     * @param ingles          is the word in english language
     * @param imageResourceId is the drawable resource for the image asset
     * @param audioResourceId is the audio resource for the words
     */

    public Sounds(String catalan, String ingles, int imageResourceId, int audioResourceId) {
        mCatalan = catalan;
        mIngles = ingles;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the catalan translation of the word.
     */
    public String getmCatalan() {

        return mCatalan;
    }

    /**
     * Get the english translation of the word.
     */
    public String getmIngles() {
        return mIngles;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getmImageResourceId() {

        return mImageResourceId;
    }

    /**
     * Return wether or not there is an image for this word.
     */
    public boolean hasImage() {

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return sounds for the words and phrases.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

}
