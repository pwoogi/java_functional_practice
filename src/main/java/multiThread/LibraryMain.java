package multiThread;

import java.util.ArrayList;

class NiceLibrary{

    public ArrayList<String> shelf = new ArrayList<>();

    public NiceLibrary(){
        shelf.add("자바의 정석1");
        shelf.add("자바의 정석2");
        shelf.add("자바의 정석3");
//        shelf.add("자바의 정석4");
//        shelf.add("자바의 정석5");
    }

    public synchronized String lendBook() throws InterruptedException {

        Thread t = Thread.currentThread();
        while (shelf.size() == 0){
            System.out.println(t.getName() + " wait for starting");
            wait();
            System.out.println(t.getName() + " waiting is end");

        }

        if(shelf.size() > 0){
            String book = shelf.remove(0);
            System.out.println(t.getName() + " :" + book + " lend ");
            return book;

        }else return null;

    }

    public synchronized void returnBook(String book){

        Thread t = Thread.currentThread();
        shelf.add(book);
        notifyAll();
        System.out.println(t.getName() + " :" + book + " return");
    }
}

class Student extends Thread{

    public Student(String student) {
        super(student);
    }

    public void run(){

        try {
            String title = LibraryMain.library.lendBook();
            if (title == null) {
                System.out.println(getName() + "  책이 없음");
                return;
            }
            sleep(5000);
            LibraryMain.library.returnBook(title);
        } catch (InterruptedException e) {
            System.out.println(e);;
        }
    }
}

public class LibraryMain {

    public static NiceLibrary library = new NiceLibrary();
    public static void main(String[] args) {

        Student std1 = new Student("학생 1");
        Student std2 = new Student("학생 2");
        Student std3 = new Student("학생 3");
        Student std4 = new Student("학생 4");
        Student std5 = new Student("학생 5");
        Student std6 = new Student("학생 5");

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
        std6.start();
    }
}
