package stream_travel;

/**
 * 여행사에 패키지 여행 상품이 있습니다. 여행 비용은 15세 이상은 100만원, 그 미만은 50만원 입니다.
 * 고객 세 명이 패키지 여행을 떠난다고 했을 때 비용 계산과 고객 명단 검색등에 대한 연산을 스트림을 활용하여 구현해 봅니다.
 * 고객에 대한 클래스를 만들고 ArrayList로 고객을 관리 합니다.
 */

public class TravelCustomer {

    private String name;   //이름
    private int age;       //나이
    private int price;     //가격

    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "name: " + name + "age: " + age + "price: " + price;
    }

}
