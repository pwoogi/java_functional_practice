package stream_travel;

import java.util.ArrayList;
import java.util.List;

public class TravelCustomerTest {
    public static void main(String[] args) {

        TravelCustomer customerLee = new TravelCustomer("이름이", 40, 100);
        TravelCustomer customerKim = new TravelCustomer("킴콩콩", 20, 100);
        TravelCustomer customerPark = new TravelCustomer("박아무", 13, 50);

        List<TravelCustomer> customerList = new ArrayList<>();

        customerList.add(customerLee);
        customerList.add(customerKim);
        customerList.add(customerPark);

        System.out.println("-------고객 명단 출력--------");
        customerList.stream().map(c-> c.getName()).forEach(s -> System.out.println(s));

        System.out.println("--------여행 비용 출력---------");
        System.out.println(customerList.stream().mapToInt(c -> c.getPrice()).sum());

        System.out.println("--------20세 이상 고객 이름 정렬해서 출력-------");
        customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(s -> System.out.println(s));

    }
}
