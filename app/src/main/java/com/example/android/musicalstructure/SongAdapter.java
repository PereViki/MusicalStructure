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

public class SongAdapter extends ArrayAdapter<Song> {

    ArrayList<Song> db;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs A List of Song objects to display in a list.
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, songs);
        this.db = songs;
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
                    R.layout.song_item, parent, false);
        }

        /*
          Get the {@link Song} object located at this position in the list
         */
        final Song currentSong = getItem(position);

        // Find the ImageView in the song_item.xml layout with the ID album_cover.
        ImageView albumImage = listItemView.findViewById(R.id.album_cover);
        // Get the album cover resource id from the current Song object and
        // set this resource on the albumImage ImageView.

        assert currentSong != null;
        albumImage.setImageResource(currentSong.getmSongAlbumCover());

        // Find the TextView in the song_item.xml layout with the ID song_title
        TextView songTitle = listItemView.findViewById(R.id.song_title);
        // Get the song title from the current Song object and
        // set this text on the songTitle TextView.
        songTitle.setText(currentSong.getSongTitle());

        // Find the TextView in the song_item.xml layout with the ID album_title
        TextView albumTitle = listItemView.findViewById(R.id.album_title);
        // Get the album title from the current Song object and
        // set this text on the albumTitle TextView.
        albumTitle.setText(currentSong.getSongAlbumTitle());

        // Find the TextView in the song_item.xml layout with the ID artist_name
        TextView artistName = listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Song object and
        // set this text on the artistName TextView.
        artistName.setText(currentSong.getSongArtistName());

        /*
          Return the whole list item layout (containing 3 TextViews and an ImageView)
          so that it can be shown in the ListView
         */
        return listItemView;

    }
}
