package stream_object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) {

        // 보조스트림으로 감싸서 읽으면 UTF-8 한글이 깨지지 않음!
        // byte -> string 으로 변환해준다
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("reader.txt"))){
            int i;

            while ((i = isr.read()) != -1){
                System.out.print((char) i);
            }
        }catch (IOException e){

        }
    }
}
