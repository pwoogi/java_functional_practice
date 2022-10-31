package sync;

class Bank{
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 이 method가 포함된 객체에 lock을 걸어두는 것(synchronized)
    // 이 경우는 접근권을 하나의 쓰레드가 먼저 가지고 있고 처리를 기다린 후에 수행한다.
    public synchronized void saveMoney(int save){

        int m = getMoney();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        setMoney(m + save);
    }

    public synchronized void minusMoney(int minus){

        int m = getMoney();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e){

            e.printStackTrace();
        }
        setMoney(m - minus);
    }
}

class Park extends Thread{

    public void run(){

        System.out.println("start save");
        SyncMain.myBank.saveMoney(3000);
        System.out.println("saveMoney(3000) : " + SyncMain.myBank.getMoney());
    }
}

class ParkWife extends Thread{

    public void run(){

//        synchronized (SyncMain.myBank){} : 이런식으로도 활용이 가능함 -  deadLock 주의!

        System.out.println("start mius");
        SyncMain.myBank.minusMoney(1000);
        System.out.println("minusMoney(1000) : " + SyncMain.myBank.getMoney());
    }
}

public class SyncMain {

    public static  Bank myBank = new Bank();

    public static void main(String[] args) {

        Park p = new Park();
        // TODO : saveMoney가 먼저 호출이 되고
        p.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ParkWife pw = new ParkWife();
        // TODO : minusMoney 메서드가 실행이됨
        pw.start();
    }
}
