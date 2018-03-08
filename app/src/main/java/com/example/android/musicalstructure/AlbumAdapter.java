package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Album> {

    DATA db2 = new DATA();
    ArrayList<Album> db;
    String currentAlbumTitle;
    String currentGenreName;
    int allAlbums;
    int allArtists;
    int allSongs;
    int songsOnCurrentAlbum = 0;
    String mSelectedGenre = "";
    ArrayList<Album> mAlbums;
    ImageView list_play_button;
    TextView playerSongTitle;
    TextView playerArtist;
    ImageView buttonPlayerPlay;
    private Context mContext;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param albums A List of Album objects to display in a list.
     * @param selectedGenre A string of the selected genre name from the previous activity.
     */
    public AlbumAdapter(Activity context, ArrayList<Album> albums, String selectedGenre) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, albums);
        mContext = context;

        // get the selected genre from the albums activity.
        mSelectedGenre = selectedGenre;

        // set the selecteGenre state of the db DATA object.

        mAlbums = albums;
        this.db = albums;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return  The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }

        /*
          Get the {@link Album} object located at this position in the list
         */
        final Album currentAlbum = getItem(position);

        // Find the ImageView in the album_item.xml layout with the ID album_image.
        ImageView albumImage = listItemView.findViewById(R.id.album_image);
        // Get the album cover resource id from the current Album object and
        // set this resource on the albumImage ImageView.
        assert currentAlbum != null;
        albumImage.setImageResource(currentAlbum.getAlbumCover());

        // Find the TextView in the album_item.xml layout with the ID album_title
        TextView albumTitle = listItemView.findViewById(R.id.album_title);
        // Get the album title from the current Album object and
        // set this text on the albumTitle TextView.
        albumTitle.setText(currentAlbum.getAlbumTitle());

        // Find the TextView in the album_item.xml layout with the ID artist_name
        TextView artistName = listItemView.findViewById(R.id.artist_name);
        // Get the artist name from the current Album object and
        // set this text on the artistName TextView.
        artistName.setText(currentAlbum.getAlbumArtistName());

        //store the genre name and album title of the current Album object.
        currentGenreName = currentAlbum.getAlbumGenre().getGenreName();
        currentAlbumTitle = currentAlbum.getAlbumTitle();

        // get the count of the Album, Artist and Song objects in the db DATA object.
        allAlbums = db2.getAlbums().size();
        allArtists = db2.getArtists().size();
        allSongs = db2.getSongs().size();

        // count the songs on the current Album object.
        for(int j = 0; j < allSongs; j++){
            String iSongAlbumTitle = db2.getSongs().get(j).getSongAlbumTitle();
            if(iSongAlbumTitle.equals(currentAlbumTitle)) {
                songsOnCurrentAlbum++;
            }
        }

        // Find the TextView in the album_item.xml layout with the ID album_count
        TextView albumCount = listItemView.findViewById(R.id.album_count);
        // set the number of songs on the Album object on the album_count TextView.
        albumCount.setText(songsOnCurrentAlbum + " " + mContext.getString(R.string.song));
        songsOnCurrentAlbum = 0;

        list_play_button = listItemView.findViewById(R.id.list_play_button);
        playerArtist = ((Albums)mContext).findViewById(R.id.player_artist);
        playerSongTitle = ((Albums)mContext).findViewById(R.id.player_song_title);
        buttonPlayerPlay = ((Albums)mContext).findViewById(R.id.button_player_play);

        // "Send" the first song of the selected album to the player.
        list_play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i < db2.getSongs().size(); i++) {
                    String iAlbumTitle = db2.getSongs().get(i).getSongAlbumTitle();
                    String clickedAlbumTitle = currentAlbum.getAlbumTitle();
                    if(iAlbumTitle.equals(clickedAlbumTitle)) {
                        playerSongTitle.setText(db2.getSongs().get(i).getSongTitle());
                        break;
                    }
                }
                playerArtist.setText(currentAlbum.getAlbumArtistName());
                buttonPlayerPlay.setImageResource(R.drawable.pause_button);
                buttonPlayerPlay.setTag("R.drawable.pause_button");
                ((Albums)mContext).isPlaying = true;

            }
        });

        /*
          Return the whole list item layout (containing 3 TextViews and an ImageView)
          so that it can be shown in the ListView
         */
        return listItemView;

    }

}
