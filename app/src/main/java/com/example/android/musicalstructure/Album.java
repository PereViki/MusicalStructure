package com.example.android.musicalstructure;

import java.io.Serializable;

/**
 * {@link Album} represents an album that the user wants to listen to.
 * It contains an album title, a resource id of the album cover drawable,
 * the release year of the album, an artist object and a genre object.
 */

public class Album implements Serializable {

    /**
     * Title of the album
     */
    private String mAlbumTitle;

    /**
     * Image of the album cover
     */
    private int mAlbumCover;

    /**
     * Year of the album release
     */
    private int mAlbumYear;

    /**
     * Artist object of the album
     */
    private Artist mAlbumArtist;

    /**
     * Genre object of the album
     */
    private Genre mAlbumGenre;

    /**
     * Album constructor.
     *
     * @param albumTitle  Title of the album.
     * @param albumCover  Resource id of the album cover drawable.
     * @param albumYear   Release year of the album.
     * @param albumArtist Artist object index of the album.
     * @param albumGenre  Genre object index of the album.
     */
    public Album(String albumTitle, int albumCover, int albumYear, Artist albumArtist, Genre albumGenre) {
        mAlbumTitle = albumTitle;
        mAlbumYear = albumYear;
        mAlbumCover = albumCover;
        mAlbumArtist = albumArtist;
        mAlbumGenre = albumGenre;
    }

    /**
     * Gets the title of the album
     *
     * @return album title
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    /**
     * Gets the release year of the album
     *
     * @return elease year
     */
    public int getAlbumYear() {
        return mAlbumYear;
    }

    /**
     * Gets the resource id of the Album cover
     *
     * @return album cover res id
     */
    public int getAlbumCover() {
        return mAlbumCover;
    }

    /**
     * Gets the artist object of the album
     *
     * @return artist object
     */
    public Artist getAlbumArtist() {
        return mAlbumArtist;
    }

    /**
     * Gets the artist name of the album.
     *
     * @return artist name
     */
    public String getAlbumArtistName() {
        return mAlbumArtist.getArtistName();
    }

    /**
     * Gets the genre object of the album
     *
     * @return genre naobjectme
     */
    public Genre getAlbumGenre() {
        return mAlbumGenre;
    }

    /**
     * Gets the genre name of the album
     *
     * @return genre name
     */
    public String getAlbumGenreName() {
        return mAlbumGenre.getGenreName();
    }
}
