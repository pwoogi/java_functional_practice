package exception_custom;

/**
 * Custom Exception 복습해보기 (개발자 정의)
 */
public class PasswordTest {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        if (password == null){
            throw new PassWordException("비밀번호는 null일 수 없습니다");
        }
        else if(password.length() < 5){
            throw new PassWordException("비밀번호는 5자 이상이어야 합니다");
        }
        else if(password.matches("[a-zA-Z]+")){
            throw new PassWordException("비밀번호는 숫자와 특수문자를 포함해야합니다");
        }

        this.password = password;
    }



    public static void main(String[] args) {

        PasswordTest pt = new PasswordTest();
        String password = null;

        try {
            pt.setPassword(password);
            System.out.println("오류없음1");
        }catch (PassWordException e){
            System.out.println(e.getMessage());
        }

        password = "abc";
        try {
            pt.setPassword(password);
            System.out.println("오류없음2");
        }catch (PassWordException e){
            System.out.println(e.getMessage());
        }


        password = "abcde";
        try {
            pt.setPassword(password);
            System.out.println("오류없음3");
        }catch (PassWordException e){
            System.out.println(e.getMessage());
        }


        password = "abcde1#";
        try {
            pt.setPassword(password);
            System.out.println("오류없음4");
        }catch (PassWordException e){
            System.out.println(e.getMessage());
        }
    }
}
