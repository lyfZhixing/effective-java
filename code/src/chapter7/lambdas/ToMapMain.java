package chapter7.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toMap;

/**
 * toMap方法的几种参数使用形式
 */
public class ToMapMain {

    public static void main(String[] args) {
        List<Album> albums = initAlbums();
        System.out.println(toMapMerge(albums));
    }

    /**
     * 每个歌手销量最大的专辑
     */
    static Map<String, Album> toMapMerge(List<Album> albums) {
        return albums.stream().collect(toMap(Album::getArtist, v -> v, maxBy(Comparator.comparingInt(Album::getSales))));
    }



    static List<Album> initAlbums() {
        return List.of(new Album("周杰伦", "八度空间", 20),
                new Album("周杰伦", "七里香", 34),
                new Album("周杰伦", "东风破", 12),
                new Album("林俊杰", "曹操", 10),
                new Album("林俊杰", "背对背拥抱", 20),
                new Album("孙燕姿", "天黑黑", 24),
                new Album("陶喆", "大锦鲤", 43),
                new Album("陶喆", "小镇姑娘", 20)
                );
    }

    /**
     * 专辑
     */
    static class Album {
        private String artist;

        private String name;

        private int sales;

        @Override
        public String toString() {
            return "Album{" +
                    "artist='" + artist + '\'' +
                    ", name='" + name + '\'' +
                    ", sales=" + sales +
                    '}';
        }

        public String getArtist() {
            return artist;
        }

        public String getName() {
            return name;
        }

        public int getSales() {
            return sales;
        }

        public Album(String artist, String name, int sales) {
            this.artist = artist;
            this.name = name;
            this.sales = sales;
        }
    }
}
