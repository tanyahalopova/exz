import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
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

    public static List<Actor> readActors(){
        List<Actor> actors = new ArrayList<>();
        for (String s : readFile("Actors.txt")) {
            String[] values = s.split(";");
            actors.add(new Actor(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2])));
        }
        return actors;
    }

    public static List<Director> readDirectors(){
        List<Director> directors = new ArrayList<>();
        for (String s : readFile("Directors.txt")) {
            String[] values = s.split(";");
            directors.add(new Director(Integer.parseInt(values[0]), values[1]));
        }
        return directors;
    }

    public static List<Film> readFilms(){
        List<Film> films = new ArrayList<>();
        for (String s : readFile("Films.txt")) {
            String[] values = s.split(";");
            films.add(new Film(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3])));
        }
        return films;
    }

    public static List<Play> readPlays(){
        List<Play> plays = new ArrayList<>();
        for (String s : readFile("Plays.txt")) {
            String[] values = s.split(";");
            plays.add(new Play(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
        }
        return plays;
    }

}
