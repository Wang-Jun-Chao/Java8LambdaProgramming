package com.java.lambda;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 创作音乐的个人或者团体
 * All Rights Reserved !!!
 * Author: 王俊超
 * Date: 2015-12-03 08:27
 */
public class Artist {
    // 艺术家的名字（如果是团体就是团体名字，如果是个人就是个人名字）
    private String name;
    // 团体成员集合，每一个元素代表一个成员，可以为空，为空表示这人是乐队成员或者是单独的个人
    private List<Artist> members;
    // 乐队或者个人来自哪里
    private String nationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);

        this.name = name;
        this.members = members;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public String getNationality() {
        return nationality;
    }

    /**
     * 判断是是否是乐队成员
     *
     * @return true:是乐队成员，反之false
     */
    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(Collectors.toList());
        return new Artist(name, members, nationality);
    }
}
