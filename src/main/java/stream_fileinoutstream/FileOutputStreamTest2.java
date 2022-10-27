package stream_fileinoutstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream("output2.txt", true); // true, false로 덮어쓰기, 이어쓰기
        try(fos){

            byte [] bs = new byte[26];

            byte data = 65;
            for(int i = 0; i < bs.length; i++){
                bs[i] = data++;
            }
            fos.write(bs, 2, 10); // index, length 조절 가능

        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println("end");
    }
}
