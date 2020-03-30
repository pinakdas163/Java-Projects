import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public Song findSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public int findSongIndex(Song song) {
        return songs.indexOf(song);
    }

    public void purchaseSong(String title) {
        Song song = Song.createSong(title, getName());
        songs.add(song);
    }

    public static Album createAlbum(String name, String title) {
        Album album = new Album(name);
        album.purchaseSong(title);
        return album;
    }

    public void listSongs() {
        System.out.println("Song List:___________________");
        for (Song song: songs) {
            System.out.println(song.getTitle());
        }
        System.out.println("###########################");
    }
}
