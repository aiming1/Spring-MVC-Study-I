package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;  // 얘는 DB에 저장할 때 발급이 되는 key가 될 거임
    private String username;
    private int age;

    public Member(){
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
