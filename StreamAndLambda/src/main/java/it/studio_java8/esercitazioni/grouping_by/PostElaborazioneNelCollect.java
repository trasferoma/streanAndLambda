package it.studio_java8.esercitazioni.grouping_by;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PostElaborazioneNelCollect {
    public static void main(String[] args) {
        List<BlogPost> posts = CaricatoreDati.get();

        conCollectingAndThen(posts);

        conMapping(posts);

        cambiaMappaDiRitorno(posts);
    }

    private static void cambiaMappaDiRitorno(List<BlogPost> posts) {
        EnumMap<BlogPostType, List<BlogPost>> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        () -> new EnumMap<>(BlogPostType.class),
                        toList()));

        System.out.println(collect);
    }

    private static void conMapping(List<BlogPost> posts) {
        Map<BlogPostType, String> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]"))));

        System.out.println(collect);
    }

    private static void conCollectingAndThen(List<BlogPost> posts) {
        Map<String, String> collect = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, collectingAndThen(toList(), list -> f(list))));

        System.out.println(collect);
    }

    private static String f(List<BlogPost> f) {
        return "xx";
    }
}
