import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamPractice {


    public static void selectDisticnt(){
        Student s1 =new Student("java","aju");
        Student s2 =new Student("c","deepak");
        Student s3 =new Student("java","anju");


        List<Student> students = Arrays.asList(s1,s2);

        students.stream().map(student -> student.getCourse()).forEach(course-> System.out.println(course));

    }



    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aju", "Anju", "Amit","Anand");
        List<String> names2 = new ArrayList<>();


        names.stream().findFirst().ifPresent(s->  System.out.println(s));




      /*  selectDisticnt();
*/


    }
}

class Student{

    String course;
    String name;

    public Student(String course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}