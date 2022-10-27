package stream_fileinoutstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {
    public static void main(String[] args) {

        // OutputStream의 경우 해당파일을 찾지 못하면 파일을 생성까지 해준다
        try(FileOutputStream fos = new FileOutputStream("output.txt")){

            fos.write(65);
            fos.write(66);
            fos.write(67);

        }catch (IOException e){
            System.out.println(e);
        }
        System.out.println("end");
    }
}
