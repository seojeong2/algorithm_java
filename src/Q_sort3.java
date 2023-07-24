import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q_sort3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> list = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<n; i++) {
            String str = sc.nextLine();
            list.add(new Student(str.split(" ")[0], Integer.parseInt(str.split(" ")[1])));
        }
        Collections.sort(list);

        for (Student student : list) {
            System.out.print(student.name+" ");
        }

    }
}
class Student implements Comparable<Student>{
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 점수가 낮은 순서
    @Override
    public int compareTo(Student o) {
        if(this.score < o.score) {
            return -1;
        }
        return 1;

    }
}
