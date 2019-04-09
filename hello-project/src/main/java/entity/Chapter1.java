package entity;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author richard
 */
public class Chapter1 extends MusicChapter {

    /**
     * 使用lambda的方式获取名字列表
     * @return
     */
    public List<String> getNamesOfArtists_Lambda() {
        return artists.stream().map(artist -> artist.getName()).collect(Collectors.toList());
    }

    /**
     * 使用方法引用的方式获取名字列表
     * @return
     */
    public List<String> getNamesOfArtists_MethodReference() {
        return artists.stream().map(Artist::getName).collect(Collectors.toList());
    }

    /**
    * filter 方法的使用
    * @return
    */
    public List<Artist> artistsLivingInLondon() {
        return artists.stream().filter(artist -> "London".equals(artist.getNationality()))
                .collect(Collectors.toList());
    }

}
