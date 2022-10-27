package stream_systemIn;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemInTest {
    public static void main(String[] args) {

        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");
        System.out.print(">>");

        int i;

        try {
            //한글을 읽을 수 있는 보조 스트림
            InputStreamReader irs = new InputStreamReader(System.in);
            while ((i = irs.read()) != '\n') {
//                System.out.println(i);
                System.out.print((char) i);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
