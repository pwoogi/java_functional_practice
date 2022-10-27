package stream_fileinoutstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest3 {
    public static void main(String[] args) throws FileNotFoundException {

        int i;
        try(FileInputStream fis = new FileInputStream("input2.txt")){

            byte[] bs = new byte[10];

            while ( (i = fis.read(bs)) != -1){
                /**
                 * 아래의 for문 같은 경우 남아있는 QRST의 데이터까지 모두 읽어옴
                 */
//                for(int ch : bs){
//                    System.out.println((char) ch);
//                }

                /**
                 * 아래의 for문의 경우 읽은 개수만큼만 데이터를 읽어옴
                 */
                for(int j = 0; j < i; j++){
                    System.out.println((char) bs[j]);
                }
                System.out.println(" : " + i + "바이트 읽음");
            }

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
