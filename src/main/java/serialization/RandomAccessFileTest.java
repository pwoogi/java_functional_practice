package serialization;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {

        // 읽고쓰고를 모두 할 수 있는 stream, 중간 중간 데이터를 읽어와야하는 경우 사용됨
        RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");

        rf.writeInt(100);
        System.out.println("pos : " + rf.getFilePointer());
        rf.writeDouble(3.14);
        System.out.println("pos : " + rf.getFilePointer());
        rf.writeUTF("안녕"); //한글 3byte 씩 + 보이지않는 nullChar 2byte (Modified UTF-8)
        System.out.println("pos : " + rf.getFilePointer());

        rf.seek(0);


        int i = rf.readInt();
        double d = rf.readDouble();
        String str = rf.readUTF();

        System.out.println(i);
        System.out.println(d);
        System.out.println(str);
    }
}
