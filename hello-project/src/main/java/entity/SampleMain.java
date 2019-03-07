package entity;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;

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
	
	Set<String> origins = SampleData.sampleShortAlbum.getMusicians()
                .filter(artist -> artist.getName().startsWith("John"))
                .map(Artist::getNationality)
                .collect(toSet());
	System.out.println(origins);
	
	printTrackLengthStatistics(SampleData.manyTrackAlbum);

    }
    
    public Set<String> findLongTracks(List<Album> albums) {
	return albums.stream()
		.flatMap(Album::getTracks)
		.filter(track -> track.getLength() > 60)
		.map(Track::getName)
		.collect(toSet());
    }
    
    /**
     * It’s a good idea to use the primitive specialized functions wherever possible
     * because of the performance benefits. 
     * 
     * It’s also possible to calculate the individual summary statistics 
     * if you don’t need all of them through the min, max, average, 
     * and sum methods, which are all also available on all three primitive specialized Stream variants.
     * 
     * @param album
     */
    public static void printTrackLengthStatistics(Album album) {
	    IntSummaryStatistics trackLengthStats
	            = album.getTracks()
	                   .mapToInt(Track::getLength)
	                   .summaryStatistics();

	    System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
	                      trackLengthStats.getMax(),
	                      trackLengthStats.getMin(),
	                      trackLengthStats.getAverage(),
	                      trackLengthStats.getSum());
	}
    
    /**
     * 基本类型的运算不要使用装箱再拆箱，
     * API中有专门针对基本类型操作的类，
     * 例如下面使用的OptionalInt
     * @param album
     * @return 最长的音频
     */
    public static int printTrackMaxLength(Album album) {
	 OptionalInt maxLength = album.getTracks()
		 .mapToInt(Track::getLength)
		 .max();
	 
	 return maxLength.orElse(0);
    }
}
