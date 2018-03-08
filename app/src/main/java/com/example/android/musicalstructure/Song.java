package com.example.android.musicalstructure;

import java.io.Serializable;

/**
 * {@link Song} represents a song that the user wants to listen to.
 * It contains a song title, the duration of the song in miliseconds,
 * and an artist object.
 */

public class Song implements Serializable {

    /**
     * Title of the song
     */
    private String mSongTitle;

    /**
     * Duration of the song in milliseconds
     */
    private int mSongDuration;

    /**
     * Album of the song (that contains the artist and the genre as well)
     */
    private Album mSongAlbum;

    /**
     * Song constructor.
     *
     * @param songTitle    Title of the song.
     * @param songDuration Duration of the song in miliseconds.
     * @param songAlbum    Album object of the song.
     */
    public Song(String songTitle, int songDuration, Album songAlbum) {
        mSongTitle = songTitle;
        mSongDuration = songDuration;
        mSongAlbum = songAlbum;
    }

    /**
     * Gets the song title.
     *
     * @return song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Gets the artist name of the song
     *
     * @return artist name
     */
    public String getSongArtistName() {
        return mSongAlbum.getAlbumArtistName();
    }

    /**
     * Gets the album title of the song.
     *
     * @return album title
     */
    public String getSongAlbumTitle() {
        return mSongAlbum.getAlbumTitle();
    }

    /**
     * Gets the genre name of the song.
     *
     * @return genre name
     */
    public String getSongAlbumGenre() {
        return mSongAlbum.getAlbumGenreName();
    }

    /**
     * Gets the album cover resource id of the song.
     *
     * @return album cover resource id
     */
    public int getmSongAlbumCover() {
        return mSongAlbum.getAlbumCover();
    }

    /**
     * Gets the song duration.
     *
     * @return Song duration in miliseconds
     */
    public int getSongDuration() {
        return mSongDuration;
    }

    /**
     * Gets the album of the song
     *
     * @return Album object of the song
     */
    public Album getSongAlbum() {
        return mSongAlbum;
    }

    /**
     * Gets the genre of the song
     *
     * @return Genre object of the song
     */
    public Genre getSongGenre() {
        return mSongAlbum.getAlbumGenre();
    }

}