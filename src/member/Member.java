package member;

import likes.Likes;

import java.util.List;

/**
 * Member entity
 */
    public class Member {
        String name;
        String address;
    String phoneNum;
    String membershipRoute;
    List<Likes> likes; //스크랩한 게시물
    Role role;

    //회원 가입
    public Member(String name, String address, String phoneNum, String membershipRoute) {
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.membershipRoute = membershipRoute;
        this.role = Role.MEMBER; //회원 가입시에 회원 등급으로 자동 지정
    }

    //스크랩한 게시물 추가
    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }
}
