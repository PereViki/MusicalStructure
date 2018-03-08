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

public class GenreAdapter extends ArrayAdapter<Genre> {

    DATA db = new DATA();
    String currentGenreName;
    int allAlbums;
    int allGenres;
    int allSongs;
    int albumsWithCurrentGenre = 0;
    int songsWithCurrentGenre = 0;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param genres  A List of Genres objects to display in a list.
     */
    public GenreAdapter(Activity context, ArrayList<Genre> genres) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, genres);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genre_item, parent, false);
        }

        /**
         * Get the {@link Genre} object located at this position in the list
         */
        final Genre currentGenre = getItem(position);

        // Find the ImageView in the genre_item.xml layout with the ID genre_icon.
        ImageView genreIcon = (ImageView) listItemView.findViewById(R.id.genre_icon);
        // Get the genre icon resource id from the current Genre object and
        // set this resource on the genreIcon ImageView.
        genreIcon.setImageResource(currentGenre.getGenreIcon());

        //store the name of the current Genre object.
        currentGenreName = currentGenre.getGenreName();

        // get the count of the Album, Artist and Song objects in the db DATA object.
        allAlbums = db.getAlbums().size();
        allGenres = db.getGenres().size();
        allSongs = db.getSongs().size();

        // count the albums on the current Genre object.
        for (int i = 0; i < allAlbums; i++) {
            if (db.getAlbums().get(i).getAlbumGenre().getGenreName() == currentGenreName) {
                albumsWithCurrentGenre++;
            }
        }

        // count the songs on the current Genre object.
        for (int j = 0; j < allSongs; j++) {
            if (db.getSongs().get(j).getSongAlbumGenre() == currentGenreName) {
                songsWithCurrentGenre++;
            }
        }

        // Find the TextView in the genre_item.xml layout with the ID album_count
        TextView albumCount = (TextView) listItemView.findViewById(R.id.album_count);
        // set the number of albums and songs on the Genre object on the albumCount TextView.
        albumCount.setText(albumsWithCurrentGenre + " album / " + songsWithCurrentGenre + " song");
        albumsWithCurrentGenre = 0;
        songsWithCurrentGenre = 0;

        /**
         * Return the whole list item layout (containing a TextView and an ImageView)
         * so that it can be shown in the ListView
         */
        return listItemView;
    }

}
