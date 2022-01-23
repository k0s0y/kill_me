package ru.netology.movie;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FaceOfMovie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    FaceOfMovie first = new FaceOfMovie(1, 1, "Modern Times", "Comedy");
    FaceOfMovie second = new FaceOfMovie(2, 2, "Little Shop of Horrors", "Horror");
    FaceOfMovie third = new FaceOfMovie(3, 3, "Rick and Morty", "Cartoon");
    FaceOfMovie forth = new FaceOfMovie(4, 4, "Whores from the gateway 9", "XXX");
    FaceOfMovie fifth = new FaceOfMovie(5, 5, "A Nightmare on Elm Street", "Thriller");
    FaceOfMovie sixth = new FaceOfMovie(6, 6, "Dogville", "Art-house");
    FaceOfMovie seventh = new FaceOfMovie(7, 7, "The Kid", "Comedy");
    FaceOfMovie eighth = new FaceOfMovie(8, 8, "Scooby-Doo", "Cartoon");
    FaceOfMovie ninth = new FaceOfMovie(9, 9, "Seven", "Cartoon");
    FaceOfMovie tenth = new FaceOfMovie(10, 10, "Little Shop of Horrors", "Horror");
    FaceOfMovie eleventh = new FaceOfMovie(11, 11, "South Park", "Cartoon");
    FaceOfMovie twelveth = new FaceOfMovie(12, 12, "Fight Club", "Thriller");

    private MovieManager manager = new MovieManager();



    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelveth);
    }


    @Test
    void addMovieInEmptyList() {
        manager.add(first);
        assertArrayEquals(new FaceOfMovie[]{first}, manager.getAllMovies());
    }

    @Test
    void addMovieInNotEmptyList() {
        manager.add(first);
        assertArrayEquals(new FaceOfMovie[]{first}, manager.getAllMovies());

        manager.add(second);
        assertArrayEquals(new FaceOfMovie[]{second, first}, manager.getAllMovies());
    }

    @Test
    void OnlyTenMoviesForFeed() {
        setUp();
        FaceOfMovie[] expected = new FaceOfMovie[]{twelveth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third};
        FaceOfMovie[] actual = manager.getLastTenMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    void LessThanTenMoviesForFeed() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        FaceOfMovie[] expected = new FaceOfMovie[]{third, second, first};
        FaceOfMovie[] actual = manager.getLastTenMovies();
        assertArrayEquals(expected, actual);
    }
}