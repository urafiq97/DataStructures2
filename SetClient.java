import java.util.Scanner;

public class SetClient {
    private static Student inputStudent() {
        Scanner rd = new Scanner(System.in);
        
        System.out.print("Enter a name: ");
        String nm = rd.nextLine();
        System.out.print("Enter " + nm + "'s GPA: ");
        double gp = rd.nextDouble();

        Student s = new Student(nm, gp);
        return s;
    }

    public static void main(String[] args) {
        SetA<Student> course = new SetA<Student>();
        Student s1 = inputStudent();
        Student s2 = inputStudent();
        Student s3 = inputStudent();

        course.add(s1);
        course.add(s2);
        course.add(s3);
        Student s4 = (Student)s3.clone();
        course.add(s4);
    }    
}
