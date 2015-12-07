package com.java.lambda;


import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: 王俊超
 * Date: 2015-12-07 20:40
 * Declaration: All Rights Reserved !!!
 */
public class CompletableAlbumLookup implements AlbumLookup {

    private static final ExecutorService service = Executors.newFixedThreadPool(4);
    private final List<Track> tracks;
    private final List<Artist> artists;

    private Track track;
    private Artist artist;

    public CompletableAlbumLookup(List<Track> tracks, List<Artist> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    @Override
    public Album lookupByName(String albumName) {
        return null;
    }

    CompletableFuture<Track> lookupTrack(String id) {
        return CompletableFuture.supplyAsync(() -> {
            return track;
        }, service);
    }

    CompletableFuture<Artist> createFuture(String id) {
        CompletableFuture<Artist> future = new CompletableFuture<>();
        startJob(future);
        return future;
    }



    private void startJob(CompletableFuture<Artist> future) {
        future.complete(artist);
    }

    private void processExceptionally(CompletableFuture<Album> future, String name) {
        future.completeExceptionally(new AlbumLookupException("Unable to find " + name));
    }

    private CompletableFuture<List<Artist>> lookupArtists(String albumName, Credentials credentials) {
        return CompletableFuture.completedFuture(artists);
    }

    private CompletableFuture<Credentials> loginTo(String serviceName) {
        return CompletableFuture.supplyAsync(() -> {
            if ("artist".equals(serviceName)) {
                sleep(1000);
            }

            return new Credentials();
        }, service);
    }

    private CompletableFuture<List<Track>> lookupTracks(String albumName, Credentials credentials) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return tracks;
        }, service);
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
