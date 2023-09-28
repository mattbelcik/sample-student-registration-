import java.math.BigDecimal;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;

// example object messaging

//ask to pick user
//ask them what they want to do

public class Main {
    public static void main(String[] args) {

        Scanner money = new Scanner(System.in);

        Catalog catalog = new Catalog();

        String courseString = "F2022 CSIS 3701 Advanced Object-Oriented Programming 32";
        String pattern = "(S|X|F)(2[0-9]{3})\\s+([A-Z]{3,})\\s+([1-4][0-9]{3})\\s+(([A-Za-z-]+\\s)+([A-Za-z]+))\\s+([0-9]{1,})";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(courseString);

        try {
            Scanner input = new Scanner(Paths.get("./Courses.txt"));
            while (input.hasNextLine()) {
                courseString = input.nextLine();
                m = r.matcher(courseString);
                if (m.find()) {
                    Course c = new Course(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(8));
                    catalog.add(c);
                    System.out.println("Course: " + c.getCourseString());

                } else {
                    System.out.println("NO MATCH");
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String line = "H00123456 Jane Doe";
        String pattern2 = "(H[0-9]{8})\\s+(\\w+)\\s(\\w+)\\s?";

        Pattern p = Pattern.compile(pattern2);
        Matcher o = r.matcher(line);

        try {
            Scanner input2 = new Scanner(Paths.get("./Student.txt"));
            while (input2.hasNextLine()) {
                line = input2.nextLine();
                o = p.matcher(line);
                if (o.find()) {

                    Student ex1 = new Student(o.group(2), o.group(3), o.group(1));

                    // System.out.println(ex1.getName());
                    Account account = new Account();
                    List<Student> list = Arrays.asList(ex1);
                    list.stream().forEach(System.out::println);

                    System.out.println("enter credit hours for selected student");

                    int creditH = money.nextInt();
                    account.EvalHours(creditH);

                    System.out.println("enter how much you are paying for tuition (credit) ");

                    int Paid = money.nextInt();
                    account.addMoney(Paid);

                } else {
                    System.out.println("NO MATCH");
                }
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}