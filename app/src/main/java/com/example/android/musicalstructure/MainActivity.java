package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView seeAllGenres;
    TextView seeAllArtists;
    TextView seeAllAlbums;
    TextView seeAllSongs;
    ImageView buttonPlayerPlay;
    TextView playerSongTitle;
    TextView playerArtist;

    ImageView genreIcon1;
    ImageView genreIcon2;
    ImageView genreIcon3;
    ImageView genreIcon4;

    ImageView artistImage1;
    ImageView artistImage2;
    ImageView artistImage3;
    ImageView artistImage4;

    ImageView albumCover1;
    ImageView albumCover2;
    ImageView albumCover3;
    ImageView albumCover4;

    TextView artistName1;
    TextView artistName2;
    TextView artistName3;
    TextView artistName4;

    TextView artistAlbumCount1;
    TextView artistAlbumCount2;
    TextView artistAlbumCount3;
    TextView artistAlbumCount4;

    TextView albumTitle1;
    TextView albumTitle2;
    TextView albumTitle3;
    TextView albumTitle4;

    TextView albumArtistName1;
    TextView albumArtistName2;
    TextView albumArtistName3;
    TextView albumArtistName4;

    ImageView songImage1;
    ImageView songImage2;
    ImageView songImage3;
    ImageView songImage4;

    TextView songTitle1;
    TextView songTitle2;
    TextView songTitle3;
    TextView songTitle4;

    TextView songArtistName1;
    TextView songArtistName2;
    TextView songArtistName3;
    TextView songArtistName4;

    public boolean isPlaying = false;

    static final String STATE_PLAYER_SONG_TITLE = "playerSongTitle";
    static final String STATE_PLAYER_ARTIST = "playerArtist";
    static final String STATE_ISPLAYING = "isPlaying";

    /**
     * Sets the onClick listener to the passed Genre icon.
     * The onClick method starts an intent to open the albums list
     * of the genre passed.
     *
     * @param genreIcon The ImageView of the genre icon
     * @param genreId   The position of the genre in the database
     * @param db        The database
     */
    private void setGenreOnClick(View genreIcon, final int genreId, final DATA db) {
        genreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<Album> genreAlbums;
                genreAlbums = new ArrayList<>();

                // int genreAlbumsCount = 0;

                for (int i = 0; i < db.getAlbums().size(); i++) {

                    String iGenreName = db.getAlbums().get(i).getAlbumGenreName();
                    String clickedGenreName = db.getGenres().get(genreId).getGenreName();
                    if (iGenreName.equals(clickedGenreName)) {

                        genreAlbums.add(new Album(db.getAlbums().get(i).getAlbumTitle(),
                                db.getAlbums().get(i).getAlbumCover(),
                                db.getAlbums().get(i).getAlbumYear(), db.getAlbums().get(i).getAlbumArtist(), db.getAlbums().get(i).getAlbumGenre()));
                        //       genreAlbumsCount++;

                    }

                }

                Intent openAlbums = new Intent(MainActivity.this, Albums.class);
                openAlbums.putExtra("clickedGenreName", db.getGenres().get(genreId).getGenreName());
                openAlbums.putExtra("genreAlbums", genreAlbums);
                openAlbums.putExtra("playerSongTitle", playerSongTitle.getText());
                openAlbums.putExtra("playerArtist", playerArtist.getText());
                openAlbums.putExtra("isPlaying", isPlaying);
                startActivityForResult(openAlbums, 1);

            }

        });

    }

    /**
     * Sets the onClick listener to the passed Artist image.
     * The onClick method starts an intent to open the albums list
     * of the artist passed.
     *
     * @param artistImage The ImageView of the artist image
     * @param artistId    The position of the artist in the database
     * @param db          The database
     */
    private void setArtistOnClick(View artistImage, final int artistId, final DATA db) {
        artistImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<Album> genreAlbums;
                genreAlbums = new ArrayList<>();

                for (int i = 0; i < db.getAlbums().size(); i++) {

                    String iArtistName = db.getAlbums().get(i).getAlbumArtistName();
                    String clickedArtistName = db.getArtists().get(artistId).getArtistName();
                    if (iArtistName.equals(clickedArtistName)) {

                        genreAlbums.add(new Album(db.getAlbums().get(i).getAlbumTitle(),
                                db.getAlbums().get(i).getAlbumCover(),
                                db.getAlbums().get(i).getAlbumYear(), db.getAlbums().get(i).getAlbumArtist(), db.getAlbums().get(i).getAlbumGenre()));

                    }

                }

                Intent openAlbums = new Intent(MainActivity.this, Albums.class);
                openAlbums.putExtra("clickedGenreName", db.getArtists().get(artistId).getArtistName());
                openAlbums.putExtra("genreAlbums", genreAlbums);
                openAlbums.putExtra("playerSongTitle", playerSongTitle.getText());
                openAlbums.putExtra("playerArtist", playerArtist.getText());
                openAlbums.putExtra("isPlaying", isPlaying);
                startActivityForResult(openAlbums, 1);
            }

        });

    }

    /**
     * Sets the onClick listener to the passed album cover.
     * The onClick method starts an intent to open the songs list
     * of the album passed.
     *
     * @param albumImage The ImageView of the album cover
     * @param albumId    The position of the album in the database
     * @param db         The database
     */
    private void setAlbumOnClick(View albumImage, final int albumId, final DATA db) {
        albumImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<Song> albumSongs;
                albumSongs = new ArrayList<>();

                // int albumSongsCount = 0;

                for (int i = 0; i < db.getSongs().size(); i++) {

                    String iAlbumTitle = db.getSongs().get(i).getSongAlbumTitle();
                    String clickedAlbumTitle = db.getAlbums().get(albumId).getAlbumTitle();
                    if (iAlbumTitle.equals(clickedAlbumTitle)) {

                        albumSongs.add(new Song(db.getSongs().get(i).getSongTitle(),
                                db.getSongs().get(i).getSongDuration(),
                                db.getSongs().get(i).getSongAlbum()));
                        //       albumSongsCount++;

                    }

                }

                Intent openSongs = new Intent(MainActivity.this, Songs.class);
                openSongs.putExtra("clickedAlbumTitle", db.getAlbums().get(albumId).getAlbumTitle());
                openSongs.putExtra("albumSongs", albumSongs);
                openSongs.putExtra("playerSongTitle", playerSongTitle.getText());
                openSongs.putExtra("playerArtist", playerArtist.getText());
                openSongs.putExtra("isPlaying", isPlaying);
                startActivityForResult(openSongs, 1);
            }
        });

    }

    private void setSongOnClick(View songImage, final int songId, final DATA db) {
        songImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerSongTitle = findViewById(R.id.player_song_title);
                playerArtist = findViewById(R.id.player_artist);
                playerSongTitle.setText(db.getSongs().get(songId).getSongTitle());
                playerArtist.setText(db.getSongs().get(songId).getSongArtistName());
                buttonPlayerPlay.setImageResource(R.drawable.pause_button);
                buttonPlayerPlay.setTag("R.drawable.pause_button");
                isPlaying = true;

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        seeAllGenres = findViewById(R.id.see_all_genres);
        seeAllArtists = findViewById(R.id.see_all_artists);
        seeAllAlbums = findViewById(R.id.see_all_albums);
        seeAllSongs = findViewById(R.id.see_all_songs);
        buttonPlayerPlay = findViewById(R.id.button_player_play);
        playerSongTitle = findViewById(R.id.player_song_title);
        playerArtist = findViewById(R.id.player_artist);

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

        if (buttonPlayerPlay.getTag().equals("R.drawable.play_button")) {
            isPlaying = false;
        } else {
            isPlaying = true;
        }

        // Explicit intent to open Genres
        seeAllGenres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent genresIntent = new Intent(MainActivity.this, Genres.class);
                genresIntent.putExtra("playerSongTitle", playerSongTitle.getText());
                genresIntent.putExtra("playerArtist", playerArtist.getText());
                genresIntent.putExtra("isPlaying", isPlaying);
                startActivityForResult(genresIntent, 1);
            }
        });

        // Explicit intent to open Artists
        seeAllArtists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent artistsIntent = new Intent(MainActivity.this, Artists.class);
                artistsIntent.putExtra("playerSongTitle", playerSongTitle.getText());
                artistsIntent.putExtra("playerArtist", playerArtist.getText());
                artistsIntent.putExtra("isPlaying", isPlaying);
                startActivityForResult(artistsIntent, 1);
            }
        });

        // Explicit intent to open Albums
        seeAllAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent albumsIntent = new Intent(MainActivity.this, Albums.class);
                albumsIntent.putExtra("playerSongTitle", playerSongTitle.getText());
                albumsIntent.putExtra("playerArtist", playerArtist.getText());
                albumsIntent.putExtra("isPlaying", isPlaying);
                startActivityForResult(albumsIntent, 1);
            }
        });

        // Explicit intent to open Songs
        seeAllSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songsIntent = new Intent(MainActivity.this, Songs.class);
                songsIntent.putExtra("playerSongTitle", playerSongTitle.getText());
                songsIntent.putExtra("playerArtist", playerArtist.getText());
                songsIntent.putExtra("isPlaying", isPlaying);
                startActivityForResult(songsIntent, 1);
            }
        });

        // Behaviour of bottom player
        buttonPlayerPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!playerSongTitle.getText().equals(getText(R.string.select_a_song))) {

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
                    Toast toast = Toast.makeText(MainActivity.this, R.string.toast_choose_song, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // Setting the items on the Main Activity

        final DATA db = new DATA();

        // Genres row
        int genreId1 = 1;
        int genreId2 = 0;
        int genreId3 = 3;
        int genreId4 = 2;

        genreIcon1 = findViewById(R.id.genre_icon_1);
        genreIcon2 = findViewById(R.id.genre_icon_2);
        genreIcon3 = findViewById(R.id.genre_icon_3);
        genreIcon4 = findViewById(R.id.genre_icon_4);

        genreIcon1.setImageResource(db.getGenres().get(genreId1).getGenreIcon());
        genreIcon2.setImageResource(db.getGenres().get(genreId2).getGenreIcon());
        genreIcon3.setImageResource(db.getGenres().get(genreId3).getGenreIcon());
        genreIcon4.setImageResource(db.getGenres().get(genreId4).getGenreIcon());

        setGenreOnClick(genreIcon1, genreId1, db);
        setGenreOnClick(genreIcon2, genreId2, db);
        setGenreOnClick(genreIcon3, genreId3, db);
        setGenreOnClick(genreIcon4, genreId4, db);

        // Artists row
        int artistId1 = 1;
        int artistId2 = 2;
        int artistId3 = 0;
        int artistId4 = 3;

        artistImage1 = findViewById(R.id.artist_image_1);
        artistImage2 = findViewById(R.id.artist_image_2);
        artistImage3 = findViewById(R.id.artist_image_3);
        artistImage4 = findViewById(R.id.artist_image_4);

        artistName1 = findViewById(R.id.artist_name_1);
        artistName2 = findViewById(R.id.artist_name_2);
        artistName3 = findViewById(R.id.artist_name_3);
        artistName4 = findViewById(R.id.artist_name_4);

        artistAlbumCount1 = findViewById(R.id.album_count_1);
        artistAlbumCount2 = findViewById(R.id.album_count_2);
        artistAlbumCount3 = findViewById(R.id.album_count_3);
        artistAlbumCount4 = findViewById(R.id.album_count_4);

        artistImage1.setImageResource(db.getArtists().get(artistId1).getArtistImage());
        artistImage2.setImageResource(db.getArtists().get(artistId2).getArtistImage());
        artistImage3.setImageResource(db.getArtists().get(artistId3).getArtistImage());
        artistImage4.setImageResource(db.getArtists().get(artistId4).getArtistImage());

        artistAlbumCount1.setText(db.getAlbumCount(artistId1) + " " + getString(R.string.album) +
                " / " + db.getSongCount(artistId1) + " " + getString(R.string.song));
        artistAlbumCount2.setText(db.getAlbumCount(artistId2) + " " + getString(R.string.album) +
                " / " + db.getSongCount(artistId2) + " " + getString(R.string.song));
        artistAlbumCount3.setText(db.getAlbumCount(artistId3) + " " + getString(R.string.album) +
                " / " + db.getSongCount(artistId3) + " " + getString(R.string.song));
        artistAlbumCount4.setText(db.getAlbumCount(artistId4) + " " + getString(R.string.album) +
                " / " + db.getSongCount(artistId4) + " " + getString(R.string.song));

        artistName1.setText(db.getArtists().get(artistId1).getArtistName());
        artistName2.setText(db.getArtists().get(artistId2).getArtistName());
        artistName3.setText(db.getArtists().get(artistId3).getArtistName());
        artistName4.setText(db.getArtists().get(artistId4).getArtistName());

        setArtistOnClick(artistImage1, artistId1, db);
        setArtistOnClick(artistImage2, artistId2, db);
        setArtistOnClick(artistImage3, artistId3, db);
        setArtistOnClick(artistImage4, artistId4, db);

        // Albums row
        final int albumId1 = 0;
        int albumId2 = 7;
        int albumId3 = 9;
        int albumId4 = 10;

        albumCover1 = findViewById(R.id.album_cover_1);
        albumCover2 = findViewById(R.id.album_cover_2);
        albumCover3 = findViewById(R.id.album_cover_3);
        albumCover4 = findViewById(R.id.album_cover_4);

        albumTitle1 = findViewById(R.id.album_title_1);
        albumTitle2 = findViewById(R.id.album_title_2);
        albumTitle3 = findViewById(R.id.album_title_3);
        albumTitle4 = findViewById(R.id.album_title_4);

        albumArtistName1 = findViewById(R.id.album_artist_1);
        albumArtistName2 = findViewById(R.id.album_artist_2);
        albumArtistName3 = findViewById(R.id.album_artist_3);
        albumArtistName4 = findViewById(R.id.album_artist_4);

        albumCover1.setImageResource(db.getAlbums().get(albumId1).getAlbumCover());
        albumCover2.setImageResource(db.getAlbums().get(albumId2).getAlbumCover());
        albumCover3.setImageResource(db.getAlbums().get(albumId3).getAlbumCover());
        albumCover4.setImageResource(db.getAlbums().get(albumId4).getAlbumCover());

        albumTitle1.setText(db.getAlbums().get(albumId1).getAlbumTitle());
        albumTitle2.setText(db.getAlbums().get(albumId2).getAlbumTitle());
        albumTitle3.setText(db.getAlbums().get(albumId3).getAlbumTitle());
        albumTitle4.setText(db.getAlbums().get(albumId4).getAlbumTitle());

        albumArtistName1.setText(db.getAlbums().get(albumId1).getAlbumArtistName());
        albumArtistName2.setText(db.getAlbums().get(albumId2).getAlbumArtistName());
        albumArtistName3.setText(db.getAlbums().get(albumId3).getAlbumArtistName());
        albumArtistName4.setText(db.getAlbums().get(albumId4).getAlbumArtistName());

        setAlbumOnClick(albumCover1, albumId1, db);
        setAlbumOnClick(albumCover2, albumId2, db);
        setAlbumOnClick(albumCover3, albumId3, db);
        setAlbumOnClick(albumCover4, albumId4, db);

        setAlbumOnClick(albumTitle1, albumId1, db);
        setAlbumOnClick(albumTitle2, albumId2, db);
        setAlbumOnClick(albumTitle3, albumId3, db);
        setAlbumOnClick(albumTitle4, albumId4, db);

        setAlbumOnClick(albumArtistName1, albumId1, db);
        setAlbumOnClick(albumArtistName2, albumId2, db);
        setAlbumOnClick(albumArtistName3, albumId3, db);
        setAlbumOnClick(albumArtistName4, albumId4, db);

        // Songs row
        int songId1 = 1;
        int songId2 = 6;
        int songId3 = 22;
        int songId4 = 15;

        songImage1 = findViewById(R.id.song_image_1);
        songImage2 = findViewById(R.id.song_image_2);
        songImage3 = findViewById(R.id.song_image_3);
        songImage4 = findViewById(R.id.song_image_4);

        songTitle1 = findViewById(R.id.song_title_1);
        songTitle2 = findViewById(R.id.song_title_2);
        songTitle3 = findViewById(R.id.song_title_3);
        songTitle4 = findViewById(R.id.song_title_4);

        songArtistName1 = findViewById(R.id.song_artist_1);
        songArtistName2 = findViewById(R.id.song_artist_2);
        songArtistName3 = findViewById(R.id.song_artist_3);
        songArtistName4 = findViewById(R.id.song_artist_4);

        songTitle1.setText(db.getSongs().get(songId1).getSongTitle());
        songTitle2.setText(db.getSongs().get(songId2).getSongTitle());
        songTitle3.setText(db.getSongs().get(songId3).getSongTitle());
        songTitle4.setText(db.getSongs().get(songId4).getSongTitle());

        songArtistName1.setText(db.getSongs().get(songId1).getSongArtistName());
        songArtistName2.setText(db.getSongs().get(songId2).getSongArtistName());
        songArtistName3.setText(db.getSongs().get(songId3).getSongArtistName());
        songArtistName4.setText(db.getSongs().get(songId4).getSongArtistName());

        setSongOnClick(songImage1, songId1, db);
        setSongOnClick(songImage2, songId2, db);
        setSongOnClick(songImage3, songId3, db);
        setSongOnClick(songImage4, songId4, db);

        setSongOnClick(songTitle1, songId1, db);
        setSongOnClick(songTitle2, songId2, db);
        setSongOnClick(songTitle3, songId3, db);
        setSongOnClick(songTitle4, songId4, db);

        setSongOnClick(songArtistName1, songId1, db);
        setSongOnClick(songArtistName2, songId2, db);
        setSongOnClick(songArtistName3, songId3, db);
        setSongOnClick(songArtistName4, songId4, db);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(STATE_PLAYER_SONG_TITLE, playerSongTitle.getText().toString());
        savedInstanceState.putString(STATE_PLAYER_ARTIST, playerArtist.getText().toString());
        savedInstanceState.putBoolean(STATE_ISPLAYING, isPlaying);

        super.onSaveInstanceState(savedInstanceState);

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



