package com.lti.training.hibernate.service;

import java.util.List;
import java.util.Set;

import com.lti.training.hibernate.dao.AccountDao;
import com.lti.training.hibernate.dao.AlbumDao;
import com.lti.training.hibernate.entity.Account;
import com.lti.training.hibernate.entity.Album;
import com.lti.training.hibernate.entity.Song;


public class AlbumService {

	public void addAlbum(Album album) {
		AlbumDao dao = new AlbumDao();
		dao.upsert(album);
	}
	
	public void addSongToAlbum(int albumId, Song song) {
		AlbumDao dao = new AlbumDao();
		Album album = (Album) dao.fetchById(Album.class, albumId);
		song.setAlbum(album);
		dao.upsert(song);
	}
	
	public void addSongsToAlbum(int albumId, Set<Song> songs) {
		AlbumDao dao = new AlbumDao();
		Album album = (Album) dao.fetchById(Album.class, albumId);
		album.setSongs(songs);
		for (Song s: songs) {
			s.setAlbum(album);
		}
		dao.upsert(album);
	}
	
	public List<Song> fetchSongByName(String type) {
		return new AlbumDao().fetchSongByName(type);
	
}
}
