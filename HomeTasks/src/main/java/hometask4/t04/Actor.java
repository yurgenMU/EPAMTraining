package hometask4.t04;

import java.io.Serializable;
import java.util.Set;

public class Actor implements Comparable, Serializable {
    private String name;
    private Set<Film> films;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;
        return films != null ? films.equals(actor.films) : actor.films == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (films != null ? films.hashCode() : 0);
        return result;
    }

    public String getName() {

        return name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    @Override
    public int compareTo(Object o) {
        Actor actor = (Actor) o;
        return this.getName().compareTo(actor.getName());
    }
}
