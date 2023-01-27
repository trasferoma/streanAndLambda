package it.studio_java8.esercitazioni.grouping_by;

import java.util.Arrays;
import java.util.List;

public class CaricatoreDati {
    public static List<BlogPost> get() {
        return Arrays.asList(
                new BlogPost("titoloA_diA", "Autore A", BlogPostType.NEWS, 1),
                new BlogPost("titoloB_diA", "Autore A", BlogPostType.GUIDE, 2),
                new BlogPost("titoloA_diB", "Autore B", BlogPostType.NEWS, 3),
                new BlogPost("titoloB_diB", "Autore B", BlogPostType.GUIDE, 4));
    }
}
