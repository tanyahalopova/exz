import java.util.Comparator;
import java.util.List;

public class DirectorComparator implements Comparator<Director> {
    private List<Film> films;

    public DirectorComparator(List<Film> films) {
        this.films = films;
    }

    @Override
    public int compare(Director d1, Director d2) {
        long s1 = films.stream()
                .filter(film -> film.getDirectorId() == d1.getId())
                .map(Film::getYear)
                .distinct()
                .count();
        long s2 = films.stream()
                .filter(film -> film.getDirectorId() == d2.getId())
                .map(Film::getYear)
                .distinct()
                .count();
        return Long.compare(s1, s2);
    }
}
