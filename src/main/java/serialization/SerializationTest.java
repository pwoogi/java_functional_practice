package serialization;

import java.io.*;

class Person implements Serializable {
    String name;
    String job;

    public Person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String toString(){
        return name + ", "+ job;
    }
}


/**
 *  직렬화 :
 *  -> 인스턴스 값을 그대로 저장하거나 전송하거나 복원함
 *
 */
public class SerializationTest {

    public static void main(String[] args) {

        Person personLee = new Person("이순신", "대표이사");
        Person personKim = new Person("김유신", "상무이사");

        try (FileOutputStream fos = new FileOutputStream("serial.txt");
            ObjectOutputStream ois = new ObjectOutputStream(fos)){

            ois.writeObject(personLee);
            ois.writeObject(personKim);

        }catch (IOException e) {
            System.out.println(e);
        }

        try (FileInputStream fos = new FileInputStream("serial.txt");
             ObjectInputStream ois = new ObjectInputStream(fos)){

            Person pLee = (Person) ois.readObject();
            Person pKim = (Person) ois.readObject();

            System.out.println(pLee);
            System.out.println(pKim);

        }catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
