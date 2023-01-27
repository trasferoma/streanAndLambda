package it.studio_java8.esercitazioni.grouping_by;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
class BlogPost {
    String title;
    String author;
    BlogPostType type;
    int likes;
}
