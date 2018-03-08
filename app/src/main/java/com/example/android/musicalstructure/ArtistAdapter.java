package com.example.android.musicalstructure;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist> {

    DATA db = new DATA();
    String currentArtistName;
    int allAlbums;
    int allArtists;
    int allSongs;
    int albumsWithCurrentArtist = 0;
    int songsWithCurrentArtist = 0;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param artists A List of Artist objects to display in a list.
     */
    public ArtistAdapter(Activity context, ArrayList<Artist> artists) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, artists);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.artist_item, parent, false);
        }

        /**
         * Get the {@link Artist} object located at this position in the list
         */
        final Artist currentArtist = getItem(position);

        // Find the ImageView in the artist_item.xml layout with the ID artist_image.
        ImageView artistImage = (ImageView) listItemView.findViewById(R.id.artist_image);
        // Get the rtist image resource id from the current Artist object and
        // set this resource on the artistImage ImageView.
        artistImage.setImageResource(currentArtist.getArtistImage());

        // Find the TextView in the artist_item.xml layout with the ID artist_name
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Artist object and
        // set this text on the artistName TextView.
        artistName.setText(currentArtist.getArtistName());

        //store the name of the current Artist object.
        currentArtistName = currentArtist.getArtistName();

        // get the count of the Album, Artist and Song objects in the db DATA object.
        allAlbums = db.getAlbums().size();
        allArtists = db.getArtists().size();
        allSongs = db.getSongs().size();

        // count the albums on the current Artist object.
        for(int i = 0; i < allAlbums; i++){
            if(db.getAlbums().get(i).getAlbumArtist().getArtistName() == currentArtistName) {
                albumsWithCurrentArtist++;
            }
        }

        // count the songs on the current Artist object.
        for(int j = 0; j < allSongs; j++){
            if(db.getSongs().get(j).getSongArtistName() == currentArtistName) {
                songsWithCurrentArtist++;
            }
        }

        // Find the TextView in the artist_item.xml layout with the ID album_count
        TextView albumCount = (TextView) listItemView.findViewById(R.id.album_count);
        // set the number of albums and songs on the Artist object on the albumCount TextView.
        albumCount.setText(albumsWithCurrentArtist + " album / " + songsWithCurrentArtist + " song");
        albumsWithCurrentArtist = 0;
        songsWithCurrentArtist = 0;

        /**
         * Return the whole list item layout (containing 2 TextViews and an ImageView)
         * so that it can be shown in the ListView
         */
        return listItemView;
    }

}

