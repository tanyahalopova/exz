import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTest {
    @Test
    void checkTask1() {

        List<Director> directors = Reader.readDirectors();
        List<Film> films = Reader.readFilms();

        DirectorComparator compare = new DirectorComparator(films);
        directors.sort(compare);

        Assertions.assertEquals(directors.get(0).getName(), "Anna Budrevich");
        Assertions.assertEquals(directors.get(1).getName(), "UIop Oknweqv");
        Assertions.assertEquals(directors.get(2).getName(), "Christofer Nolan");
        Assertions.assertEquals(directors.get(3).getName(), "Artur Bab");
    }

    void checkTask2() {

        List<Actor> actors = Reader.readActors();
        List<Director> directors = Reader.readDirectors();
        List<Film> films = Reader.readFilms();
        List<Play> plays = Reader.readPlays();

        Assertions.assertEquals(directors.get(0).getName(), "Anna Budrevich");
        Assertions.assertEquals(directors.get(1).getName(), "UIop Oknweqv");
        Assertions.assertEquals(directors.get(2).getName(), "Christofer Nolan");
        Assertions.assertEquals(directors.get(3).getName(), "Artur Bab");
    }
}
