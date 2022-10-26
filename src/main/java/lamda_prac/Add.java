package lamda_prac;

@FunctionalInterface // 메서드 2개 선언 방지
public interface Add {

    public int add(int x, int y);
//    public int sum(int x, int y); 사용할 수 없음
}
