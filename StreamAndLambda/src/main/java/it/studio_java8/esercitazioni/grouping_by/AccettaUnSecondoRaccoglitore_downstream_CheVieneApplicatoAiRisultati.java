package it.studio_java8.esercitazioni.grouping_by;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class AccettaUnSecondoRaccoglitore_downstream_CheVieneApplicatoAiRisultati {
    public static void main(String[] args) {
        List<BlogPost> posts = CaricatoreDati.get();

        raccoglitoreSet(posts);
        raccoglitoreSecondario(posts);
        mediaRisultati(posts);
        sommaRisultati(posts);
        minimoRisultati(posts);
        riepilogoRisultati(posts);
    }

    private static void riepilogoRisultati(List<BlogPost> posts) {
        Map<BlogPostType, IntSummaryStatistics> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        summarizingInt(BlogPost::getLikes)));

        System.out.println(collect);
    }

    private static void minimoRisultati(List<BlogPost> posts) {
        Map<BlogPostType, Optional<BlogPost>> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        minBy(comparingInt(BlogPost::getLikes))));

        System.out.println(collect);
    }

    private static void sommaRisultati(List<BlogPost> posts) {
        Map<BlogPostType, Integer> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));

        System.out.println(collect);
    }

    private static void mediaRisultati(List<BlogPost> posts) {
        Map<BlogPostType, Double> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));

        System.out.println(collect);
    }

    private static void raccoglitoreSecondario(List<BlogPost> posts) {
        Map<String, Map<BlogPostType, List<BlogPost>>> collect = posts.stream()
                .collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));

        System.out.println(collect);
    }

    private static void raccoglitoreSet(List<BlogPost> posts) {
        Map<BlogPostType, Set<BlogPost>> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType, toSet()));

        System.out.println(collect);
    }
}
