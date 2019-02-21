package me.sumitkawatra.java8.concept.lambda.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Chaining Comparator
 * 
 * @author sumkawat
 *
 */
public class Practice2 {
	
	public static void main(String[] args) {
		
		List<Song> playList = Arrays.asList(
				new Song("Z", "A"), 
				new Song("Y", "A"),
				new Song("P", "B"),
				new Song("Q", "A"),
				new Song("X", "B"),
				new Song("R", "A"));
		
		
		playList.sort(Comparator.comparing(Song::getAuthor).thenComparing(Song::getTitle));
		
		playList.stream().forEach((song) -> {System.out.println(song);});
		
	}
}

class Song {

	private String title;
	private String author;

	public Song(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", author=" + author + "]";
	}

}
