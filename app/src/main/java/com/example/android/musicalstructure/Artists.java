package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Artists extends AppCompatActivity {

    DATA db = new DATA();
    ImageView buttonPlayerPlay;
    TextView playerSongTitle;
    TextView playerArtist;
    boolean isPlaying;
    static final String STATE_PLAYER_SONG_TITLE = "playerSongTitle";
    static final String STATE_PLAYER_ARTIST = "playerArtist";
    static final String STATE_ISPLAYING = "isPlaying";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);

        playerSongTitle = findViewById(R.id.player_song_title);
        playerArtist = findViewById(R.id.player_artist);
        buttonPlayerPlay = findViewById(R.id.button_player_play);

        //getting the data from the previous activity
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        // get data via the key
        String playerSongTitleString = extras.getString("playerSongTitle");
        String playerArtistString = extras.getString("playerArtist");
        isPlaying = extras.getBoolean("isPlaying");

        playerSongTitle.setText(playerSongTitleString);
        playerArtist.setText(playerArtistString);
        if(isPlaying) {
            buttonPlayerPlay.setImageResource(R.drawable.pause_button);
            buttonPlayerPlay.setTag("R.drawable.pause_button");
        } else {
            buttonPlayerPlay.setImageResource(R.drawable.play_button);
            buttonPlayerPlay.setTag("R.drawable.play_button");
        }

        // Behaviour of bottom player

        buttonPlayerPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!playerSongTitle.getText().equals(getText(R.string.select_a_song))) {

                    if (isPlaying) {
                        buttonPlayerPlay.setImageResource(R.drawable.play_button);
                        buttonPlayerPlay.setTag("R.drawable.play_button");
                        isPlaying = false;
                    } else {
                        buttonPlayerPlay.setImageResource(R.drawable.pause_button);
                        buttonPlayerPlay.setTag("R.drawable.pause_button");
                        isPlaying = true;
                    }

                } else {
                    Toast toast = Toast.makeText(Artists.this, R.string.toast_choose_song,Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        /*
         * Create an {@link android.widget.ArrayAdapter}, whose data source is a list of artists.
         * The adapter knows how to create layouts for each item in the list, using the
         * artist_item.xml layout resource. This list item layout contains a Relative Layout
         * {@link android.widget.RelativeLayout}, which contains a two TextViews and an ImageView
         * the adapter will set to display states of the artist object.
         */
        ArrayList artists = db.getArtists();
        ArtistAdapter adapter = new ArtistAdapter(this, artists);

        /*
         * Find the {@link GridView} object in the view hierarchy of the {@link android.app.Activity}.
         * There should be a {@link GridView} with the view ID called list, which is declared in the
         * activity_albums.xml layout file.
         */
        GridView listView = findViewById(R.id.list);

        /*
          Make the {@link GridView} use the {@link android.widget.ArrayAdapter} we created above,
          so that the {@link GridView} will display list items for each artist in the list of artists.
          Do this by calling the setAdapter method on the {@link GridView} object and pass in
          1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
         */
        listView.setAdapter(adapter);

        // onItmeClickListener gets called when the user clicks on one of the artists in the list.
        // An explicit intent will be called and the Albums activity will be opened.
        // clickedArtistName will be added to the intent as an extra.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final ArrayList<Album> genreAlbums;
                genreAlbums = new ArrayList<>();

                int artistAlbumsCount = 0;

                for(int i = 0; i < db.getAlbums().size(); i++) {

                    String iArtistName = db.getAlbums().get(i).getAlbumArtistName();
                    String clickedArtistName = db.getArtists().get(position).getArtistName();
                    if(iArtistName.equals(clickedArtistName)) {

                        genreAlbums.add(new Album(db.getAlbums().get(i).getAlbumTitle(),
                                db.getAlbums().get(i).getAlbumCover(),
                                db.getAlbums().get(i).getAlbumYear(),
                                db.getAlbums().get(i).getAlbumArtist(),
                                db.getAlbums().get(i).getAlbumGenre()));
                        artistAlbumsCount++;

                    }

                }

                Intent openAlbums = new Intent(Artists.this, Albums.class);
                openAlbums.putExtra("clickedGenreName", db.getArtists().get(position).getArtistName());
                openAlbums.putExtra("genreAlbums", genreAlbums);
                openAlbums.putExtra("playerSongTitle", playerSongTitle.getText());
                openAlbums.putExtra("playerArtist", playerArtist.getText());
                openAlbums.putExtra("isPlaying", isPlaying);
                startActivityForResult(openAlbums, 1);
            }
        });

        //setting the title bar text
        setTitle(getString(R.string.all_artists));
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(STATE_PLAYER_SONG_TITLE, playerSongTitle.getText().toString());
        savedInstanceState.putString(STATE_PLAYER_ARTIST, playerArtist.getText().toString());
        savedInstanceState.putBoolean(STATE_ISPLAYING, isPlaying);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {

            // Set the currently played song's title
            String playerSongTitleString = savedInstanceState.getString(STATE_PLAYER_SONG_TITLE);
            playerSongTitle.setText(playerSongTitleString);

            // Set the artist name of the currently played song
            String playerArtistString = savedInstanceState.getString(STATE_PLAYER_ARTIST);
            playerArtist.setText(playerArtistString);

            // Set the player button state
            isPlaying = savedInstanceState.getBoolean(STATE_ISPLAYING);
            if (isPlaying) {

                buttonPlayerPlay.setImageResource(R.drawable.pause_button);
                buttonPlayerPlay.setTag("R.drawable.pause_button");

            } else {

                buttonPlayerPlay.setImageResource(R.drawable.play_button);
                buttonPlayerPlay.setTag("R.drawable.play_button");

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();

            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent backIntent = new Intent();
        backIntent.putExtra("playerSongTitle", playerSongTitle.getText());
        backIntent.putExtra("playerArtist", playerArtist.getText());
        backIntent.putExtra("isPlaying", isPlaying);
        setResult(Activity.RESULT_OK, backIntent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                String playerSongTitleString = data.getStringExtra("playerSongTitle");
                String playerArtistString = data.getStringExtra("playerArtist");
                isPlaying = data.getBooleanExtra("isPlaying", true);

                playerSongTitle.setText(playerSongTitleString);
                playerArtist.setText(playerArtistString);
                if (isPlaying) {
                    buttonPlayerPlay.setImageResource(R.drawable.pause_button);
                    buttonPlayerPlay.setTag("R.drawable.pause_button");
                } else {
                    buttonPlayerPlay.setImageResource(R.drawable.play_button);
                    buttonPlayerPlay.setTag("R.drawable.play_button");
                }

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult
}
