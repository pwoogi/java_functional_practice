package stream_1;

import java.util.Arrays;

public class ReduceTest {
    public static void main(String[] args) {

        String greetings[] = {"안녕하십니까~~~", "hello", "Gooood Morning", "반가워요"};

        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
            if( s1.getBytes().length >= s2.getBytes().length) return s1;
            else return s2;
                }));
    }
}
