package it.studio_java8.esercitazioni.grouping_by;

import static java.util.stream.Collectors.groupingBy;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutablePair;

public class AccettaSoloUnaFunzioneDiClassificazioneComeParametro {
    public static void main(String[] args) {
        List<BlogPost> posts = CaricatoreDati.get();

        chiaveSemplice(posts);
        chiaveComposta(posts);
    }

    private static void chiaveSemplice(List<BlogPost> posts) {
        Map<BlogPostType, List<BlogPost>> collect = posts.stream()
                .collect(groupingBy(BlogPost::getType));

        System.out.println(collect);
    }

    private static void chiaveComposta(List<BlogPost> posts) {
        Map<ImmutablePair<BlogPostType, String>, List<BlogPost>> collect = posts.stream()
                .collect(groupingBy(post -> new ImmutablePair<>(post.getType(), post.getAuthor())));

        System.out.println(collect);
    }
}
