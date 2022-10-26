package stream_prac;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5};

        for(int num : arr){
            System.out.println(num);
        }
        System.out.println();

        IntStream is = Arrays.stream(arr);
        is.forEach(n -> System.out.println(n));

        // 또 다른 연산을 수행하기 위해서는 다시 stream을 생성해야함 (재사용 불가능!)
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
    }
}
