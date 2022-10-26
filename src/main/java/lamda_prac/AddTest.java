package lamda_prac;

public class AddTest {

    public static void main(String[] args) {

        Add addLamda = (x, y) -> {return x+y;};

        System.out.println(addLamda.add(2, 3));
    }
}
