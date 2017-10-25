package hometask4.t04;

import java.io.Serializable;
import java.util.*;

public class Service implements Serializable {
    private Map<Film, Set<Actor>> films;

    public Service() {
        films = new TreeMap<>();

    }

    public void addActor(Film film, Actor actor) {
        Set<Actor> proxySet = new TreeSet<>();
        if (!(films.keySet().contains(film))) {
            proxySet.add(actor);
            films.put(film, proxySet);
        } else {
            for (Film movie : films.keySet()) {
                if (film.getName().equals(movie.getName())) {
                    proxySet = films.get(movie);
                    proxySet.add(actor);
                    films.put(movie, proxySet);
                }
            }
        }
    }

    public Set<Actor> getActorsByFilm(Film movie) {
        Set<Actor> actors = new TreeSet<>();
        for (Film film : films.keySet()) {
            if (film.getName().equals(movie.getName()))
                actors = films.get(film);
        }
        return actors;
    }

    public Set<Film> getFilmsByActor(Actor actor) {
        Set<Film> movies = new HashSet<>();
        for (Film film : films.keySet()) {
            if (films.get(film).contains(actor))
                movies.add(film);
        }
        return movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return films != null ? films.equals(service.films) : service.films == null;
    }

    @Override
    public int hashCode() {
        return films != null ? films.hashCode() : 0;
    }
}
