package com.lti.training.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.lti.training.hibernate.dao.GenericDao;
import com.lti.training.hibernate.entity.Album;
import com.lti.training.hibernate.entity.Song;
import com.lti.training.hibernate.service.AlbumService;

public class AlbumTest {
	
	@Test
	public void addAlbum() {
		Album alb = new Album();
		AlbumService as = new AlbumService();
		GenericDao dao = new GenericDao();
		alb.setName("AtifAslam");
		alb.setReleaseDate(LocalDate.now());
		alb.setCopyright("ALL RIGHTS RESERVED");
		as.addAlbum(alb);
	}
	
	@Test
	public void addSongToAlbum() {
		AlbumService as = new AlbumService();
		Song s1 = new Song();
		s1.setTitle("Song4");
		s1.setDuration(240.00); 
		s1.setSinger("Singer4");
		as.addSongToAlbum(301,s1);
	}
	
	@Test
	public void addSongsToAlbum() {
		AlbumService service = new AlbumService();
		
		Song s1 = new Song();
		s1.setTitle("Song101");
		s1.setDuration(240.00); 
		s1.setSinger("Singer101");
		
		Song s2 = new Song();
		s2.setTitle("Song102");
		s2.setDuration(240.00); 
		s2.setSinger("Singer102");
		
		Song s3 = new Song();
		s3.setTitle("Song103");
		s3.setDuration(240.00); 
		s3.setSinger("Singer103");
		
		Song s4 = new Song();
		s4.setTitle("Song104");
		s4.setDuration(240.00); 
		s4.setSinger("Singer104");
		
		Set<Song> songs = new HashSet<Song>();
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		
		service.addSongsToAlbum(321, songs);
	}
	
	@Test
	public void fetchSongByName() {
		AlbumService as = new AlbumService();
		List<Song> song = as.fetchSongByName("Song1");
		for (Song s: song) {
			System.out.println(s.getTitle());
			System.out.println(s.getSinger());
			System.out.println( s.getDuration());
			
		
	}

}
}
