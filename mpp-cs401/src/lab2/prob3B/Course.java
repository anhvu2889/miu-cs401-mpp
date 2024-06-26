package lab2.prob3B;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String id;
    private final String name;
    private final List<Course> prerequisites;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        prerequisites = new ArrayList<>();
    }

    public Course(String id, String name, List<Course> prerequisites) {
        this.id = id;
        this.name = name;
        this.prerequisites = prerequisites;
    }

    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }
}
