public class Song {
    private String title;
    private String album;

    public Song(String title, String album) {
        this.title = title;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public static Song createSong(String title, String album) {
        return new Song(title, album);
    }
}
