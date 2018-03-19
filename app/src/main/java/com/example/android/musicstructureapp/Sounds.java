package com.example.android.musicstructureapp;

/**
 * Created by davidchazarrabru on 15/3/18.
 */

public class Sounds {

    /** Default translation for the word */

    private String mCastellano;

    /** Miwok translation for the word */

    private String mCatalan;

    /** Image resource ID for the word */

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */

    private static final int NO_IMAGE_PROVIDED = -1;

    /** Audio resource ID for the word */

    private int mAudioResourceId;


    /**
     * Create a new Word object.
     *
     * @param castellano is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param catalan is the word in the Miwok language
     *
     * @param audioResourceId is the audio resource for the words
     */
    public Sounds (String castellano, String catalan, int audioResourceId) {
        mCastellano = castellano;
        mCatalan = catalan;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param castellano is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param catalan is the word in the Miwok language
     *
     * @param imageResourceId is the drawable resource for the image asset
     *
     * @param audioResourceId is the audio resource for the words
     */

    public Sounds(String castellano, String catalan, int imageResourceId, int audioResourceId) {
        mCastellano = castellano;
        mCatalan = catalan;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }


    /**
     * Get the default translation of the word.
     */
    public String getmCastellano() {
        return mCastellano;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getmCatalan() {

        return mCatalan;
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
    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    /**
     * Return sounds for the words and phrases.
     *
     */
    public int getAudioResourceId(){return mAudioResourceId;}

}
