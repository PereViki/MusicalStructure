package com.example.android.musicalstructure;

import java.util.ArrayList;

/**
 * Initializing the database into the DATA class.
 */
public class DATA {

    private ArrayList<Genre> genres = new ArrayList<Genre>();
    private ArrayList<Artist> artists = new ArrayList<Artist>();
    private ArrayList<Album> albums = new ArrayList<Album>();
    private ArrayList<Song> songs = new ArrayList<Song>();
    String selectedGenre = "";
    String selectedAlbum = "";
    String selectedArtist = "";
    String selectedSong = "";

    public DATA() {
        genres.add(new Genre("Rock", R.drawable.genre_rock));
        genres.add(new Genre("Pop", R.drawable.genre_pop));
        genres.add(new Genre("Hip hop", R.drawable.genre_hiphop));
        genres.add(new Genre("Comedy", R.drawable.genre_comedy));
        genres.add(new Genre("Jazz", R.drawable.genre_jazz));
        genres.add(new Genre("Disco", R.drawable.genre_disco));

        artists.add(new Artist("Nine Inch Nails", R.drawable.artist_5));
        artists.add(new Artist("Nirvana", R.drawable.artist_4));
        artists.add(new Artist("Tim Minchin", R.drawable.artist_8));
        artists.add(new Artist("Metallica", R.drawable.artist_image));
        artists.add(new Artist("Linkin Park", R.drawable.artist_image));
        artists.add(new Artist("Marilyn Manson", R.drawable.artist_image));
        artists.add(new Artist("Rage Against the Machine", R.drawable.artist_image));
        artists.add(new Artist("System of a Down", R.drawable.artist_image));
        artists.add(new Artist("Rise Against", R.drawable.artist_image));


        albums.add(new Album("Pretty Hate Machine", R.drawable.cover_0, 1989, artists.get(0), genres.get(0)));
        albums.add(new Album("Head Like a Hole", R.drawable.album_image, 1990, artists.get(0), genres.get(0)));
        albums.add(new Album("The Downward Spiral", R.drawable.album_image, 1994, artists.get(0), genres.get(0)));
        albums.add(new Album("The Fragile", R.drawable.album_image, 1999, artists.get(0), genres.get(0)));
        albums.add(new Album("Metallica", R.drawable.album_image, 1991, artists.get(3), genres.get(0)));
        albums.add(new Album("Load", R.drawable.album_image, 1996, artists.get(3), genres.get(0)));
        albums.add(new Album("St. Anger", R.drawable.album_image, 2003, artists.get(3), genres.get(0)));
        albums.add(new Album("Nevermind", R.drawable.cover_7, 1991, artists.get(1), genres.get(0)));
        albums.add(new Album("In Utero", R.drawable.album_image, 1993, artists.get(1), genres.get(0)));
        albums.add(new Album("Darkside", R.drawable.cover_9, 2005, artists.get(2), genres.get(3)));
        albums.add(new Album("So Rock", R.drawable.cover_10, 2006, artists.get(2), genres.get(3)));

        songs.add(new Song("Head Like a Hole", 299000, albums.get(0)));
        songs.add(new Song("Terrible Lie", 278000, albums.get(0)));
        songs.add(new Song("Down in It", 226000, albums.get(0)));
        songs.add(new Song("Sanctified", 348000, albums.get(0)));
        songs.add(new Song("Something I Can Never Have", 355000, albums.get(0)));
        songs.add(new Song("Kinda I Want To", 274000, albums.get(0)));
        songs.add(new Song("Sin", 245000, albums.get(0)));
        songs.add(new Song("That's What I Get", 270000, albums.get(0)));
        songs.add(new Song("The Only Time", 287000, albums.get(0)));
        songs.add(new Song("Ringfinger", 342000, albums.get(0)));

        songs.add(new Song("Smells Like Teen Spirit", 301000, albums.get(7)));
        songs.add(new Song("In Bloom", 254000, albums.get(7)));
        songs.add(new Song("Come as You Are", 219000, albums.get(7)));
        songs.add(new Song("Breed", 183000, albums.get(7)));
        songs.add(new Song("Lithium", 257000, albums.get(7)));
        songs.add(new Song("Polly", 177000, albums.get(7)));
        songs.add(new Song("Territorial Pissings", 142000, albums.get(7)));
        songs.add(new Song("Drain You", 223000, albums.get(7)));
        songs.add(new Song("Lounge Act", 156000, albums.get(7)));
        songs.add(new Song("Stay Away", 212000, albums.get(7)));
        songs.add(new Song("On a Plain", 196000, albums.get(7)));
        songs.add(new Song("Something in the Way", 1235000, albums.get(7)));

        songs.add(new Song("So Fucking Rock", 402000, albums.get(10)));
        songs.add(new Song("If You Really Loved Me", 238000, albums.get(10)));
        songs.add(new Song("Some People Have It Worse Than I", 296000, albums.get(10)));
        songs.add(new Song("F Sharp", 114000, albums.get(10)));
        songs.add(new Song("Canvas Bags", 291000, albums.get(10)));

        songs.add(new Song("Inflatable You", 352000, albums.get(9)));
        songs.add(new Song("Rock 'n' Roll Nerd", 334000, albums.get(9)));
        songs.add(new Song("Dark Side", 486000, albums.get(9)));
        songs.add(new Song("Not Perfect", 427000, albums.get(9)));

        songs.add(new Song("Head Like a Hole (Copper)", 386000, albums.get(1)));
        songs.add(new Song("Hurt", 374000, albums.get(2)));
        songs.add(new Song("Starfuckers, Inc.", 299000, albums.get(3)));
        songs.add(new Song("Nothing Else Matters", 388000, albums.get(4)));
        songs.add(new Song("Until It Sleeps", 270000, albums.get(5)));
        songs.add(new Song("St. Anger", 441000, albums.get(6)));
        songs.add(new Song("Pennyroyal Tea", 217000, albums.get(8)));
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public String getAlbumsNames() {
        return this.getAlbumsNames();
    }

    public String getSelectedGenre() { return this.selectedGenre; };

    public String getSelectedAlbum() { return selectedAlbum; }

    public String getSelectedArtist() { return selectedArtist; }

    public String getSelectedSong() { return selectedSong; }

    public void setSelectedAlbum(String selectedAlbum) { this.selectedAlbum = selectedAlbum; }

    public void setSelectedArtist(String selectedArtist) { this.selectedArtist = selectedArtist; }

    public void setSelectedGenre(String selectedGenre) { this.selectedGenre = selectedGenre; }

    public void setSelectedSong(String selectedSong) { this.selectedSong = selectedSong; }

    public int getAlbumCount(int artistIndex) {

        int albumCount = 0;
        int allAlbums = DATA.this.getAlbums().size();

        for(int i = 0; i < allAlbums; i++){

            String iAlbumArtist = DATA.this.getAlbums().get(i).getAlbumArtistName();
            String currentArtist = DATA.this.getArtists().get(artistIndex).getArtistName();

            if(iAlbumArtist.equals(currentArtist)) {
                albumCount++;
            }

        }

        return albumCount;
    }

    public int getSongCount(int artistIndex) {

        int songCount = 0;
        int allSongs = DATA.this.getSongs().size();

        for(int i = 0; i < allSongs; i++){

            String iAlbumArtist = DATA.this.getSongs().get(i).getSongArtistName();
            String currentArtist = DATA.this.getArtists().get(artistIndex).getArtistName();

            if(iAlbumArtist.equals(currentArtist)) {
                songCount++;
            }

        }

        return songCount;
    }

}


