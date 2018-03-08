package com.example.android.musicalstructure;

import java.io.Serializable;

/**
 * {@link Genre} represents a genre.
 * It contains a genre name, a resource id of the genre icon drawable.
 */

public class Genre implements Serializable {

    /**
     * Genre of the song or album of the artist
     */
    private String mGenreName;

    /**
     * Image of the genre icon
     */
    private int mGenreIcon;

    /**
     * Genre constructor.
     *
     * @param genreName Name of the genre.
     * @param genreIcon Resource id of the genre drawable.
     */
    public Genre(String genreName, int genreIcon) {
        mGenreName = genreName;
        mGenreIcon = genreIcon;
    }

    /**
     * Gets the genre name.
     *
     * @return genre name
     */
    public String getGenreName() {
        return mGenreName;
    }

    /**
     * Gets the genre icon.
     *
     * @return genre icon
     */
    public int getGenreIcon() {
        return mGenreIcon;
    }
}



