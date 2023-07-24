import java.util.Locale;

public class Temp {

    public static void main(String[] args) {
        String temp = "SeoJeong";

        temp = temp.toLowerCase();

        System.out.println("소문자 변환: "+temp);

        temp = temp.toUpperCase();

        System.out.println("대문자 변환: " + temp);
    }
}
