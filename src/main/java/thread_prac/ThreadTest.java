package thread_prac;

class MyThread implements Runnable{

    @Override
    public void run() {
        int i;
        for(i = 0; i<200; i++){
            System.out.println(i + "\t");
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread() + "start");

        MyThread runnable = new MyThread();

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);

        th1.start();
        th2.start();


        System.out.println(Thread.currentThread() + "end");

        Runnable run  = () -> System.out.println("1");

        run.run();
    }
}
