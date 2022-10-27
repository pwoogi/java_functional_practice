package stream_object;

import java.io.*;

public class BufferedStreamTest {

    public static void main(String[] args) {

        long millisecond = 0;

        try(FileInputStream fis = new FileInputStream("a.zip");
            FileOutputStream fos = new FileOutputStream("copy.zip");
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos)){

            millisecond = System.currentTimeMillis();

            int i;
            while( ( i = bis.read()) != -1){
                bos.write(i);
            }

            millisecond = System.currentTimeMillis() - millisecond;
        }catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("파일 복사 하는 데 " + millisecond + " milliseconds 소요되었습니다.");
    }

    /**
     *  Socket 을 사용할 때도 마찬가지로 BufferReader 보조스트림으로 감싸서
     *  readLine 등의 메서드를 사용하면 속도를 개선할 수 있고 영어->한글을 읽어올 수 있음.
     */

}
