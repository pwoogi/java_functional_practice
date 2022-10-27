package stream_fileinoutstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest1 {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fis = null;
        try{
            fis = new FileInputStream("input.txt");
            System.out.println((char)fis.read()); //read 함수는 더이상 읽을값이 없으면 -1을 반환하기 때문에 type이 int
            System.out.println((char)fis.read());
            System.out.println((char)fis.read());

        }catch (IOException e){
            e.printStackTrace();
            try {
                fis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception e2){
                System.out.println(e2);
            }
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2){
                System.out.println(e2);
            }
        }
        System.out.println("end");
    }
}
