package hometask4.t04;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Film implements Comparable, Serializable {
    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return name != null ? name.equals(film.name) : film.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }


    public Film(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Object o) {
        Film f = (Film) o;
        return this.getName().compareTo(f.getName());
    }
}
