package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * A single release of music, comprising several tracks
 * @author richard
 */
public final class Album implements Performance {

    // The name of the album (e.g., “Revolver”)
    private String name;

    // A list of tracks
    private List<Track> tracks;

    // A list of artists who helped create the music on this album
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
	Objects.requireNonNull(name);
	Objects.requireNonNull(tracks);
	Objects.requireNonNull(musicians);

	this.name = name;
	this.tracks = new ArrayList<>(tracks);
	this.musicians = new ArrayList<>(musicians);
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @return the tracks
     */
    public Stream<Track> getTracks() {
	return tracks.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Track> getTrackList() {
	return unmodifiableList(tracks);
    }

    /**
     * @return the musicians
     */
    @Override
    public Stream<Artist> getMusicians() {
	return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Artist> getMusicianList() {
	return unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
	return musicians.get(0);
    }

    public Album copy() {
	List<Track> tracks = getTracks().map(Track::copy).collect(toList());
	List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
	return new Album(name, tracks, musicians);
    }

}
