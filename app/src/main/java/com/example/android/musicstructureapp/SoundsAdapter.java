package com.example.android.musicstructureapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * {@link SoundsAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Sounds} objects.
 */
public class SoundsAdapter extends ArrayAdapter<Sounds> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link SoundsAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being
     *                        created in.
     * @param sounds          is the list of {@link Sounds}s to be displayed.
     * @param colorResourceId color
     */
    public SoundsAdapter(Context context, ArrayList<Sounds> sounds, int colorResourceId) {
        super(context, 0, sounds);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Sounds} object located at this position in the list
        Sounds currentSounds = getItem(position);

        //Catalan part

        // Find the TextView in the list_item.xml layout with the catalan text

        TextView catalanTextView = (TextView) listItemView.findViewById(R.id.catalan);

        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        catalanTextView.setText(currentSounds.getmCatalan());

        // English part

        // Find the TextView in the list_item.xml layout with the english text

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.ingles);

        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        englishTextView.setText(currentSounds.getmIngles());

        //Image part

        // Find the Image in the list_item.xml layout with the ID image

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imagen);

        // Check if an image is provided for this word or not

        if (currentSounds.hasImage()) {
            imageView.setImageResource(currentSounds.getmImageResourceId());

            imageView.setVisibility(View.VISIBLE);
        } else imageView.setVisibility(View.GONE);


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return listItemView;
    }
}

