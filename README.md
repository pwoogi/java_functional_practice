# Lamda, Stream, Thread 복습하기

## 함수형 인터페이스 선언하기

- 람다식을 선언하기 위한 인터페이스

- 익명 함수와 매개 변수만으로 구현되므로 인터페이스는 단 하나의 메서드만을 선언해야함

- @FunctionalInterface 애노테이션(annotation)

  함수형 인터페이스라는 의미, 내부에 여러 개의 메서드를 선언하면 에러남 

<img src = "https://gitlab.com/easyspubjava/javacoursework/-/raw/master/Chapter6/6-03/img/error.png">

## 객체 지향 프로그래밍과 람다식 비교

- 문자열 두 개를 연결하여 출력하는 예제를 두 가지 방식으로 구현해 보자

- 인터페이스 선언

```
public interface StringConcat {
	
	public void makeString(String s1, String s2);

}
```

- 객체 지향 프로그래밍으로 구현하기

인터페이스를 구현한 클래스 만들기

```
public class StringConCatImpl implements StringConcat{

	@Override
	public void makeString(String s1, String s2) {
		System.out.println( s1 + "," + s2 );
	}
}
```
클래스를 생성하고 메서드 호출하기

```
public class TestStringConcat {

	public static void main(String[] args) {

		String s1 = "Hello";
		String s2 = "World";
		StringConCatImpl concat1 = new StringConCatImpl();
		concat1.makeString(s1, s2);
    }
}
```

- 람다식으로 구현하기

```
StringConcat concat2 = (s, v)->System.out.println(s + "," + v ); //System.out.println(i);
concat2.makeString(s1, s2);
```

## 익명 객체를 생성하는 람다식

- 자바에서는 객체 없이 메서드가 호출 될 수 없음

- 람다식을 구현하면 익명 내부 클래스가 만들어지고, 이를 통해 익명 객체가 생성됨

```
StringConcat concat3 = new StringConcat() {
			
	@Override
	public void makeString(String s1, String s2) {
			
		System.out.println( s1 + "," + s2 );
	}
};
		
concat3.makeString(s1, s2);
```

- 익명 내부 클래스에서와 마찬가지로 람다식 내부에서 에서도 외부에 있는 지역 변수의 값을 변경하면 오류가 발생함

## 함수를 변수처럼 사용하는 람다식

변수는...

	특정 자료형으로 변수를 선언 한 후 값을 대입함   int a = 10;

	매개 변수로 전달하여 사용함 		int add(int x, int y)

	메서드의 반환 값으로 반환 하기		return num;


- 인터페이스형 변수에 람다식 대입하기

  함수형 인터페이스
```
interface PrintString{
	
	void showString(String str);
}
```

```
PrintString lambdaStr = s->System.out.println(s);  //람다식을 변수에 대입
lambdaStr.showString("hello lambda_1");
```

- 매개변수로 전달하는 람다식
```
showMyString(lambdaStr); 

public static void showMyString(PrintString p) {
	p.showString("hello lambda_2");
}
```

- 반환 값으로 쓰이는 람다식

```
public static PrintString returnString() {         //반환 값으로 사용
		return s->System.out.println(s + "world");
}


PrintString reStr = returnString();  
reStr.showString("hello ");
```

## 스트림 이란?

- 자료의 대상과 관계없이 동일한 연산을 수행

  배열, 컬렉션을 대상으로 연산을 수행 함

  일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 함

  자료 처리에 대한 추상화가 구현되었다고 함

- 한번 생성하고 사용한 스트림은 재사용 할 수 없음

  자료에 대한 스트림을 생성하여 연산을 수행하면 스트림은 소모됨

  다른 연산을 수행하기 위해서는 스트림을 다시 생성해야 함

- 스트림 연산은 기존 자료를 변경하지 않음

  자료에 대한 스트림을 생성하면 스트림이 사용하는 메모리 공간은 별도로 생성되므로 연산이 수행되도 기존 자료에 대한 변경은 발생하지 않음

- 스트림 연산은 중간 연산과 최종 연산으로 구분 됨

  스트림에 대해 중간 연산은 여러 개의 연산이 적용될 수 있지만 최종 연산은 마지막에 한 번만 적용됨

  최종연산이 호출되어야 중간 연산에 대한 수행이 이루어 지고 그 결과가 만들어짐

  따라서 중간 연산에 대한 결과를 연산 중에 알수 없음

  이를 '지연 연산'이라 함

## 스트림 생성하고 사용하기

- 정수 배열에 스트림 생성하여 연산을 수행 하는 예

```
public class IntArrayTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		int sumVal = Arrays.stream(arr).sum();
		long count = Arrays.stream(arr).count();
		
		System.out.println(sumVal);
		System.out.println(count);
	}

}
```

## 중간 연산과 최종 연산

- 중간 연산의 예 - filter(), map(), sorted() 등

  조건에 맞는 요소를 추출(filter)하거나 요소를 변환 함(map)

- 최종 연산이 호출될 때 중간 연산이 수행되고 결과가 생성 됨

- 문자열 리스트에서 문자열의 길이가 5 이상인 요소만 출력하기

```
  sList.stream().filter(s->s.length() >= 5).forEach(s->System.out.println(s));
```
filter()는 중간 연산이고, forEach()는 최종 연산임

- 고객 클래스 배열에서 고객 이름만 가져오기
```
  customerList.stream().map(c->c.getName()).forEach(s->System.out.println(s));
```
map()은 중간 연산이고, forEach()는 최종 연산임

- 중간 연산과 최종 연산에 대한 구현은 람다식을 활용함

- 최종 연산의 예 - forEach(), count(), sum() 등

  스트림이 관리하는 자료를 하나씩 소모해가며 연산이 수행 됨

  최종 연산 후에 스트림은 더 이상 다른 연산을 적용할 수 없음

  forEach() : 요소를 하나씩 꺼내 옴

  count() : 요소의 개수

  sum() : 요소들의 합

## reduce() 연산

- 정의된 연산이 아닌 프로그래머가 직접 구현한 연산을 적용
```
T reduce(T identify, BinaryOperator<T> accumulator)
```

- 최종 연산으로 스트림의 요소를 소모하며 연산을 수행

- 배열의 모든 요소의 합을 구하는 reduce() 연산 구현 예

```
Arrays.stream(arr).reduce(0, (a,b)->a+b));
```
- reduce() 메서드의 두 번째 요소로 전달되는 람다식에 따라 다양한 기능을 수행 할 수 있음

- 람다식을 직접 구현하거나 람다식이 긴 경우 BinaryOperator를 구현한 클래스를 사용 함

<br />

## 🔐 입출력 스트림

1. 자바의 입출력을 위한 I/O 스트림 [상세보기 - WIKI](https://github.com/pwoogi/java_functional_practice/wiki/%EC%9E%90%EB%B0%94%EC%9D%98-%EC%9E%85%EC%B6%A5%EB%A0%A5%EC%9D%84-%EC%9C%84%ED%95%9C-I-O-%EC%8A%A4%ED%8A%B8%EB%A6%BC)
2. 표준 입출력 스트림 [상세보기 - WIKI](https://github.com/pwoogi/java_functional_practice/wiki/%ED%91%9C%EC%A4%80-%EC%9E%85%EC%B6%9C%EB%A0%A5-%EC%8A%A4%ED%8A%B8%EB%A6%BC)
3. 바이트 단위 입출력 스트림 [상세보기 - WIKI](https://github.com/pwoogi/java_functional_practice/wiki/%EB%B0%94%EC%9D%B4%ED%8A%B8-%EB%8B%A8%EC%9C%84-%EC%9E%85%EC%B6%9C%EB%A0%A5-%EC%8A%A4%ED%8A%B8%EB%A6%BC)
4. 문자 단위 입출력 스트림 [상세보기 - WIKI](https://github.com/pwoogi/java_functional_practice/wiki/%EB%AC%B8%EC%9E%90-%EB%8B%A8%EC%9C%84-%EC%B6%9C%EB%A0%A5-%EC%8A%A4%ED%8A%B8%EB%A6%BC)