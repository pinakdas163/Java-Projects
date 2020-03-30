import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();
    private static boolean goingForward = true;
    private static ListIterator iterator = null;

    public static void main(String[] args) {
        System.out.println("Music Player App:");
        printOptions();
        boolean exit = false;
        int input = 0;
        Album album = null;
        while (exit != true) {
            System.out.println("Select an option:");
            if (scanner.hasNextInt() == true) {
                input = scanner.nextInt();
            } else {
                input = 100;
            }

            scanner.nextLine();
            switch (input) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    exit = true;
                    break;
                case 2:
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter album name:");
                    String albumName = scanner.nextLine();
                    album = findAlbum(albumName);
                    if (album != null) {
                        Song song = album.findSong(title);
                        if (song == null) {
                            album.purchaseSong(title);
                            System.out.println("Added song \"" + title + "\" in the album \"" + albumName + "\"");
                        } else {
                            System.out.println("Song \"" + title + "\" already present in the album \"" + albumName + "\"");
                        }
                    } else {
                        Album alb = Album.createAlbum(albumName, title);
                        albums.add(alb);
                        System.out.println("Added song \"" + title + "\" in the new album \"" + albumName + "\"");
                    }
                    break;
                case 3:
                    System.out.println("Enter album name to view songs:");
                    String albName = scanner.nextLine();
                    album = findAlbum(albName);
                    if (album != null) {
                        album.listSongs();
                    } else {
                        System.out.println("No album present with this name");
                    }
                    break;
                case 4:
                    System.out.println("Enter title:");
                    String tit = scanner.nextLine();
                    Song song = findSongInAlbums(tit);
                    if (song != null) {
                        boolean added = addSongToPlayList(song);
                        if (added == true) {
                            System.out.println("Successfully added song in the playlist");
                        }
                    } else {
                        System.out.println("Song \"" + tit + "\" is not present in any album");
                    }
                    break;
                case 5:
                    playlistSongs();
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        playSong("n");
                    } else {
                        System.out.println("Playlist is empty");
                    }
                    break;
                case 7:
                    if (playlist.size() > 0) {
                        playSong("p");
                    } else {
                        System.out.println("Playlist is empty");
                    }
                    break;
                case 8:
                    if (playlist.size() > 0) {
                        playSong("r");
                    } else {
                        System.out.println("Playlist is empty");
                    }
                    break;
                default:
                    System.out.println("Invalid input pressed - Try again");
            }
        }
    }

    public static void printOptions() {
        System.out.println("0 - Print Options\n" +
                "1 - Exit the application\n" +
                "2 - Add a song\n" +
                "3 - Display songs in an album\n" +
                "4 - Add song to the playlist\n" +
                "5 - Print songs in the playlist\n" +
                "6 - Play next song\n" +
                "7 - Play previous song\n" +
                "8 - Repeat current song");
    }

    public static Album findAlbum(String name) {
        for (Album album: albums) {
            if (album.getName().equals(name)) {
                return album;
            }
        }

        return null;
    }

    public static Song findSongInAlbums(String title) {
        for (Album album: albums) {
            Song song = album.findSong(title);
            if (song != null) {
                return song;
            }
        }

        return null;
    }

    public static int getTrackingNumber(Song song) {
        for (Album album: albums) {
            if (album.getName() == song.getAlbum()) {
                return album.findSongIndex(song);
            }
        }

        return -1;
    }

    public static boolean addSongToPlayList(Song song) {
        int newSongIndex = getTrackingNumber(song);
        //ListIterator listIterator = playlist.listIterator();

        for (Song currSong: playlist) {
            int currSongIndex = getTrackingNumber(currSong);
            if (currSongIndex == newSongIndex) {
                if (currSong.getTitle().equals(song.getTitle())) {
                    System.out.println("Song already present in the playlist");
                    return false;
                } else {
                    Song lastSong = playlist.getLast();
                    playlist.add(playlist.lastIndexOf(lastSong), song);
                    return true;
                }
            } else if (currSongIndex > newSongIndex) {
                playlist.add(newSongIndex, song);
                return true;
            }
        }

        playlist.add(song);
        iterator = playlist.listIterator(0);
        goingForward = true;
        return true;
    }

    public static void playlistSongs() {
        System.out.println("Playlist Songs:___________________");
        for (Song song: playlist) {
            System.out.println(song.getTitle());
        }
        System.out.println("###########################");
    }

    public static void playSong(String option) {
        Song song = null;
        switch (option) {
            case "n":
                if (!goingForward) {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                    goingForward = true;
                }

                if (iterator.hasNext()) {
                    song = (Song) iterator.next();
                    System.out.println("Playing song: " + song.getTitle());
                } else {
                    System.out.println("Reached end of the list");
                }
                break;
            case "p":
                if (goingForward) {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    goingForward = false;
                }

                if (iterator.hasPrevious()) {
                    song = (Song) iterator.previous();
                    System.out.println("Playing song: " + song.getTitle());
                } else {
                    System.out.println("Reached start of the list");
                }
                break;
            case "r":
                if (goingForward) {
                    song = (Song) iterator.previous();
                    System.out.println("Playing song: " + song.getTitle());
                    goingForward = false;
                } else {
                    iterator.next();
                    song = (Song) iterator.previous();
                    System.out.println("Playing song: " + song.getTitle());
                }
                break;
            default:
                System.out.println("wrong option selected");
        }
    }
}
