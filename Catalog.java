import java.util.ArrayList;

//docs.oracle.com

public class Catalog {
    private ArrayList<Course> courses;

    public Catalog() {

        courses = new ArrayList<Course>();

    }

    public void display() {
        System.out.println(courses);

    }

    public void add(Course c) {
        courses.add(c);

    }

    public void remove(Course c) {
        courses.remove(c);
    }

}