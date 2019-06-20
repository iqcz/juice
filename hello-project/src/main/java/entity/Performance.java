package entity;

import static java.util.stream.Stream.concat;

import java.util.stream.Stream;

/**
 * @author i324779
 */
public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    // TODO: test
    default Stream<Artist> getAllMusicians() {
        return getMusicians()
                .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}
