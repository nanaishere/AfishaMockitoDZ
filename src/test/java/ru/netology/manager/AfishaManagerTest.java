package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Afisha;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager;
    AfishaManager managerCustom;


    private Afisha first = new Afisha(1, "Bloodshot", "action movie");
    private Afisha second = new Afisha(2, "Forward", "cartoon");
    private Afisha third = new Afisha(3, "Hotel Belgrade", "comedy");
    private Afisha fourth = new Afisha(4, "Gentlemen", "action movie");
    private Afisha fifth = new Afisha(5, "Invisible Man", "horror");
    private Afisha sixth = new Afisha(6, "Trolls. World tour", "cartoon");
    private Afisha seventh = new Afisha(7, "Number one", "comedy");
    private Afisha eighth = new Afisha(8, "lion king", "cartoon");
    private Afisha ninth = new Afisha(9, "Hannibal Lecter", "horror");
    private Afisha tenth = new Afisha(10, "The hills have eyes", "horror");
    private Afisha eleventh = new Afisha(11, "The hills have eyes", "horror");

    @BeforeEach
    void setUp() {
        manager = new AfishaManager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);//


        managerCustom = new AfishaManager(5);
        managerCustom.addMovie(first);
        managerCustom.addMovie(second);
        managerCustom.addMovie(third);
        managerCustom.addMovie(fourth);
        managerCustom.addMovie(fifth);

    }


    @Test
    void getLastTenDefaultManager() {
        manager.addMovie(tenth);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastTenFromElevenDefaultManager() {
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getAllMoviesDefaultManager() {
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFiveCustomManager() {
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomManagerIfAddMore() {
        managerCustom.addMovie(sixth);
        managerCustom.addMovie(seventh);
        managerCustom.addMovie(eighth);
        managerCustom.addMovie(ninth);
        managerCustom.addMovie(tenth);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{tenth, ninth, eighth, seventh, sixth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfEqualsNull() {
        manager = new AfishaManager(0);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfIncorrectUnderMax() {
        manager = new AfishaManager(100);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastFiveCustomAfishaLengthIfOverMin() {
        manager = new AfishaManager(-20);
        Afisha[] actual = managerCustom.getAll();
        Afisha[] expected = new Afisha[]{fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    void getLastDefaultAfishaLengthIfOnlyOneFilm() {
        manager = new AfishaManager(1);
        manager.addMovie(fifth);
        Afisha[] actual = manager.getAll();
        Afisha[] expected = new Afisha[]{fifth};
        assertArrayEquals(expected, actual);
    }


}
