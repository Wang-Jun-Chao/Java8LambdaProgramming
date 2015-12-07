package com.java.lambda;

import java.util.List;
import java.util.stream.Collectors;

import rx.Observable;
import rx.Observer;

/**
 * Author: 王俊超
 * Date: 2015-12-07 20:59
 * Declaration: All Rights Reserved !!!
 */
public class RxExamples {
    private final List<Artist> savedArtists;
    private final List<String> savedArtistNames;

    public RxExamples(List<Artist> savedArtists) {
        this.savedArtists = savedArtists;
        savedArtistNames = savedArtists.stream()
                .map(Artist::getName)
                .collect(Collectors.toList());
    }

    public Observable<Artist> search(String searchedName,
                                     String searchedNationality,
                                     int maxResults) {
        return getSavedArtists()
                .filter(name->name.contains(searchedName))
                .flatMap(this::lookupArtist)
                .filter(artist -> artist.getNationality().contains(searchedNationality))
                .take(maxResults);
    }

    private Observable<Artist> lookupArtist(String name) {
        Artist required = savedArtists.stream()
                .filter(artist -> artist.getName().equals(name))
                .findFirst()
                .get();
        return Observable.from(required);
    }
    public Observable<String> getSavedArtists() {
        return Observable.from(savedArtistNames);
    }

    public void creationCodeSample() {
        Observer<String> observer = null;
        observer.onNext("a");
        observer.onNext("b");
        observer.onNext("c");
        observer.onNext("d");
        observer.onCompleted();

        observer.onError(new Exception());
    }
}
