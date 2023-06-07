import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Actor> actors = Reader.readActors();
        List<Director> directors = Reader.readDirectors();
        List<Film> films = Reader.readFilms();
        List<Play> plays = Reader.readPlays();

        for (Director director : directors) {
            for (Actor actor : actors) {
                List<Integer> filmIds = films.stream()
                        .filter(film -> film.getDirectorId() == director.getId())
                        .map(Film::getId).toList();
                long c = plays.stream()
                        .filter(play -> filmIds.contains(play.getFilmId()) && actor.getId() == play.getActorId())
                        .count();
                System.out.println(director.getName() + " and " + actor.getName() + " : " + c);
            }
        }

        for (Director director : directors) {
            List<Film> filmsFiltered = new ArrayList<>();
            for (Film film : films) {
                int count = 0;
                if (director.getId() == film.getDirectorId()) {
                    for (Play play : plays) {
                        if (film.getId() == play.getFilmId()) {
                            count++;
                        }
                    }
                }
                if (count >= 5 && film.getYear() > 2000) {
                    filmsFiltered.add(film);
                }
            }
            if (!filmsFiltered.isEmpty()) System.out.println(director.getName());
        }

        boolean answer = false;
        for (Actor actor : actors) {
            List<Integer> FilmIDs = plays.stream()
                    .filter(play -> play.getActorId() == actor.getId())
                    .map(Play::getFilmId)
                    .toList();
            List<Integer> DirectorsID = films.stream()
                    .filter(film -> film.getYear() < 1990 && FilmIDs.contains(film.getId()))
                    .map(Film::getDirectorId)
                    .toList();
            long c = directors.stream()
                    .filter(director -> DirectorsID.contains(director.getId()))
                    .count();
            if (c > 3) {
                answer = true;
                break;
            }
        }
        System.out.println(answer);

        DirectorComparator d = new DirectorComparator(films);
        Collections.sort(directors,d);

        for (Director director : directors){
           System.out.println(director.toString());
        }
    }
}
