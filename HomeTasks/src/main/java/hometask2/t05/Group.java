package hometask2.t05;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Group {
    private String name;
    private Discipline discipline;
    private Set<Student> students;
    private Map<String, Number> marks;

    public Group(Discipline discipline) {
        this.discipline = discipline;
        students = new TreeSet<>();
        marks = new TreeMap<>();
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;

    }

    public String getName() {
        return name;
    }

    public Map<String, Number> getMarks() {
        return marks;
    }

    public void setMark(String student, Number mark) {
        if (discipline.getHighestScore().getClass().equals(mark.getClass()))
            marks.replace(student, mark);
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        marks.put(student.getName(), 0);
        student.getGroupsSet().add(this);
    }


}
