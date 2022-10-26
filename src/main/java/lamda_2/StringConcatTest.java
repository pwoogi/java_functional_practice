package lamda_2;

public class StringConcatTest {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "World";

        StringConcatImpl stringConcat = new StringConcatImpl();
        stringConcat.makeString("Hello", "World");

        StringConcat concat = (s,v) -> System.out.println(s + "," + v);
        concat.makeString(s1, s2);


        StringConcat stringConcat1 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {

                System.out.println(s1 + "...." + s2);
            }
        };
        stringConcat1.makeString(s1, s2);
    }
}
