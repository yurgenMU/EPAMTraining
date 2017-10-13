package hometask2.t05;


import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student> {
    private final String name;
    private Set<Group> groupsSet;

    public Student(String name) {
        this.name = name;
        groupsSet = new HashSet<>();
    }


    public String getName() {
        return name;
    }

    public Set<Group> getGroupsSet() {
        return groupsSet;
    }


    public void newGroup(Group group) {
        groupsSet.add(group);
    }


    @Override
    public int compareTo(Student o) {
        return (this.getName().compareTo(o.getName()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        sb.append("\n");
        for (Group g : groupsSet) {
            sb.append(g.getDiscipline() + ": " + g.getMarks().get(name) + "\n");
        }
        return sb.toString();
    }
}
