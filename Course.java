import java.util.ArrayList;
//import java.util.Arrays;

//add semeester hours into here
//(added total) is lambdas 
public class Course {

    private String term;
    private String year;
    private String dept;
    private String number;
    private String name;
    private int enrolled;
    private int cap;
    private ArrayList<String> roster = new ArrayList<>();
    private ArrayList<String> waitList = new ArrayList<>();

    public Course(String term, String year, String dept, String number, String name, String cap) {
        this.term = term;
        this.year = year;
        this.dept = dept;
        this.number = number;
        this.name = name;
        try {
            this.cap = Integer.parseInt(cap);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        this.enrolled = 0;
    }

    public String getCourseString() {
        return this.getTermAndYear() + " " +
                this.getDeptAndNumber() + " " +
                this.getName();
    }

    public String getTermAndYear() {
        return this.term + this.year;
    }

    public String getDeptAndNumber() {
        return this.dept + " " + this.number;
    }

    public String getTerm() {
        return this.term;
    }

    public String getYear() {
        return this.year;
    }

    public String getDept() {
        return this.dept;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public int getCap() {
        return this.cap;
    }

    public int getEnrolled() {
        return this.enrolled;
    }

    public ArrayList<String> getRoster() {
        return this.roster;
    }

    public String getCourseName() {
        return this.name;
    }

    public boolean addStudent(String uid) {
        if (enrolled < cap) {
            if (!roster.contains(uid)) {
                roster.add(uid);
                enrolled++;
                return true;
            }
            System.out.println("student is already registered to this course");
            return false;
        } else {
            if (!roster.contains(uid) && !waitList.contains(uid)) {
                waitList.add(uid);
                System.out.println("adding student to waitlist");
                return true;
            }
            System.out.println("student is already in the course/waitlist");
            return false;
        }
    }

    // this goes above
    public boolean dropStudent(String uid) {
        if (roster.contains(uid)) {
            roster.remove(uid);
        } else {
            System.out.println("student isnt in this course");
            return false;
        }
        if (!waitList.isEmpty()) {
            roster.add(waitList.get(0));
            waitList.remove(0);

        } else {
            System.out.println("Student removed. Waitlist is empty for this course");
            enrolled--;

        }
        return true;
    }

    public void printRoster() {
        int i = 1;
        for (String item : this.roster) {
            System.out.println(i + ". " + item);
            i++;
        }
        return;
    }

    public void printwaitList() {
        int i = 1;
        for (String item : this.waitList) {
            System.out.println(i + ". " + item);
            i++;
        }
        return;
    }

    public String toString() {
        return term + " " + year + " " + dept + " " + number + " " + name;
    }

}