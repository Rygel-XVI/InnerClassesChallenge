package com.udemymasterclass;

import java.util.ArrayList;
import java.util.Iterator;

public class Album {
    private String title;
    private SongList songs;

    public Album(String title) {
        this.title = title;
        SongList songList = new SongList();
        this.songs = songList;
    }

    public String getTitle() {
        return title;
    }

    public Song getSong(String title) {
        return this.songs.getSong(title);
    }

    public boolean addSong(String title, String duration) {
        return songs.addSong(title, duration);
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList(ArrayList<Song> songs) {
            this.songs = songs;
        }
        public SongList() {
            this(new ArrayList<Song>());
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }

        public Song getSong(String title) {
            Iterator<Song> i = getSongs().iterator();
            while(i.hasNext()) {
                Song s = i.next();
                if (s.getTitle().equals(title)) {
                    return s;
                }
            }
            return null;
        }

        public boolean addSong(String title, String duration) {
            if (findSong(title)) {
                System.out.println(title + " already exists.");
                return false;
            } else {
                songs.add(new Song(title, duration));
                System.out.println(title + " added to album " + getTitle());
                return true;
            }
        }

        public boolean findSong(String title) {
            Iterator<Song> i = getSongs().iterator();
            while(i.hasNext()) {
                Song s = i.next();
                if (s.getTitle().equals(title)) {
                    return true;
                }
            }
            return false;
        }

    }

}
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.