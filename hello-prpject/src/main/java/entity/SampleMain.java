package entity;

import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.List;

public class SampleMain {

    public static void main(String[] args) {
	List<Track> tracks = asList(
		new Track("Bakai", 524), 
		new Track("Violets for Your Furs", 378),
		new Track("Time Was", 451));

	Track shortestTrack = tracks.stream()
		.min(Comparator.comparing(Track::getLength))
		.get();
	// google autoValue
	System.out.println(shortestTrack.getName());
    }
}
