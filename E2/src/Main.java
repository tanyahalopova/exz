import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


    public static void main(String[] args) {
        List<Actor> actors = new ArrayList<>();
        for (String s : readFile("Actors.txt")) {
            String[] values = s.split(";");
            actors.add(new Actor(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2])));
        }

        List<Director> directors = new ArrayList<>();
        for (String s : readFile("Directors.txt")) {
            String[] values = s.split(";");
            directors.add(new Director(Integer.parseInt(values[0]), values[1]));
        }

        List<Film> films = new ArrayList<>();
        for (String s : readFile("Films.txt")) {
            String[] values = s.split(";");
            films.add(new Film(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3])));
        }

        List<Play> plays = new ArrayList<>();
        for (String s : readFile("Plays.txt")) {
            String[] values = s.split(";");
            plays.add(new Play(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
        }


        for (Director director : directors) {
            for (Actor actor : actors) {
                List<Integer> filmIds = films.stream().filter(film -> film.getDirectorId() == director.getId()).map(Film::getId).toList();
                long c = plays.stream().filter(play -> filmIds.contains(play.getFilmId()) && actor.getId() == play.getActorId()).count();
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
    }
}
