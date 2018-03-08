package com.example.android.musicalstructure;

import java.io.Serializable;

/**
 * {@link Artist} represents an artist who has albums.
 * It contains an artist name, a resource id of the artist image drawable.
 */

public class Artist implements Serializable {

    /**
     * Name of the artist
     */
    private String mArtistName;

    /**
     * Image of the artist
     */
    private int mArtistImage;

    /**
     * Artist constructor.
     *
     * @param artistName  Name of the artist.
     * @param artistImage Resource id of the artist image drawable
     */
    public Artist(String artistName, int artistImage) {
        mArtistName = artistName;
        mArtistImage = artistImage;
    }

    /**
     * Gets the artist name.
     *
     * @return artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Gets the artist image.
     *
     * @return artist image
     */
    public int getArtistImage() {
        return mArtistImage;
    }

}
