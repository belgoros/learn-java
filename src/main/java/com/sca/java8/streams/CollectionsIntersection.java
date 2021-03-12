package com.sca.java8.streams;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CollectionsIntersection {
    public static void main(String[] args) {
        Set<Integer> setA = setOf(1, 2, 3, 4);
        Set<Integer> setB = setOf(2, 4, 6, 8);
        //make a copy of setA called intersectSet.
        Set<Integer> intersectSet = new HashSet<>(setA);
        //use the retainAll method to keep the values that are also in setB,
        // intersectSet is modified directly in-place
        boolean interSetChanged = intersectSet.retainAll(setB);
        System.out.println("Intersection of setA and setB:");
        intersectSet.forEach(System.out::println);

        Post post1 = new Post("post-1").
                addComment(new Comment("com-1")).
                addComment(new Comment("com-2"));

        Post post2 = new Post("post-2").
                addComment(new Comment("com-21")).
                addComment(new Comment("com-22")).
                addComment(new Comment("com-1")).
                addComment(new Comment("com-2"));

        Set<Comment> p1commentsCopy = post1.getComments();
        p1commentsCopy.retainAll(post2.comments);

        System.out.println("Intersection of posts comments: ");
        p1commentsCopy.forEach(c -> System.out.println(c.getText()));
    }

    private static Set<Integer> setOf(Integer... values) {
        return new HashSet<>(Arrays.asList(values));
    }

    @Getter
    @Setter
    private static class Post {
        private String title;
        private Set<Comment> comments = new HashSet<>();


        public Post(String title) {
            this.title = title;
        }

        public Post addComment(Comment comment) {
            getComments().add(comment);
            return this;
        }
    }

    @Getter
    @Setter
    private static class Comment {
        private String text;

        public Comment(String text) {
            this.text = text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comment comment = (Comment) o;
            return Objects.equals(text, comment.text);
        }

        @Override
        public int hashCode() {
            return Objects.hash(text);
        }
    }
}
