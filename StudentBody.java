import java.util.ArrayList;

//docs.oracle.com
//

public class StudentBody {

    private ArrayList<Student> studentbodies;

    public StudentBody() {

        studentbodies = new ArrayList<Student>();
    }

    public void display() {
        System.out.println(studentbodies);

    }

    public void add(Student c) {
        studentbodies.add(c);

    }

    // should be similar for is registered

    public boolean isEnrolled(String uid) {

        for (int i = 0; i < studentbodies.size(); i++)

            if (studentbodies.get(i).getUid() == uid) {
                System.out.println("student is enrolled");
                return true;
            }
        System.out.println("student isnt enrolled");
        return false;
    }
    /*
     * public String getStudentName(String uid){
     * for(int i = 0; i<studentbodies.size();i++){
     * if(studentbodies.get(i).getUid() == uid){
     * return studentbodies.get(i).getName();
     * }
     * 
     * }
     * return uid;
     * }
     */

}