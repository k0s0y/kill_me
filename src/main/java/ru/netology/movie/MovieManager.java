package ru.netology.movie;

import ru.netology.domain.FaceOfMovie;

public class MovieManager {
    public FaceOfMovie[] movies = new FaceOfMovie[0];
    private int feedCount = 10;

    public MovieManager() {
    } // конструктор без параметров/аргументов

    public MovieManager(int feedCount) {
        this.feedCount = feedCount;
    } // конструктор с параметром, значением которого выставляется лимит

    public MovieManager(FaceOfMovie[] movies, int feedCount) {
        this.movies = movies;
        this.feedCount = feedCount;
    }

    // add new movie
    public void add(FaceOfMovie movie) {
        int length = movies.length + 1;
        FaceOfMovie[] tmp = new FaceOfMovie[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    //show all list of movies
    public FaceOfMovie[] getAllMovies() {
        FaceOfMovie[] result = new FaceOfMovie[movies.length];
        for (int i = 0; i < movies.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    //show last ten movies
    public FaceOfMovie[] getLastTenMovies() {
        int count = this.feedCount;
        if (count > movies.length) count = movies.length;
        FaceOfMovie[] result = new FaceOfMovie[count];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}

