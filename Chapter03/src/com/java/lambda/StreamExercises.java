package com.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Author: 王俊超
 * Date: 2015/12/3 16:46
 * All Rights Reserved !!!
 */
public class StreamExercises {
    public static int countBandMembersExternal(List<Artist> artists) {
        int totalMembers = 0;
        for (Artist artist: artists) {
            Stream<Artist> members = artist.getMembers();
            totalMembers += members.count();
        }

        return totalMembers;
    }

    public static <T, R> List<R> map(Stream<T> stream, Function<T, R> mapper) {
        // reduce从一组值在生成一个值
        return stream.reduce(new ArrayList<>(), (acc, value) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(acc);
            result.add(mapper.apply(value));
            return result;
        }, (left, right) -> {
            ArrayList<R> result = new ArrayList<>();
            result.addAll(left);
            result.addAll(right);
            return result;
        });
    }
}
