package entity;

/**
 * A single piece of music
 * @author richard
 */
public final class Track {
    
    // The name of the track (e.g., “Yellow Submarine”)
    private final String name;
    
    // the length of a Track
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the length of the track in milliseconds.
     */
    public int getLength() {
        return length;
    }

    public Track copy() {
        return new Track(name, length);
    }

}
