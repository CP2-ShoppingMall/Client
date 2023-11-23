package member;

/**
 * 관리자 권한 부여시 ADMIN
 * 일반회원 권한 부여시 MEMBER
 */
public enum Role {
    ADMIN(0), MEMBER(1);
    int itdentifier;
    Role(int identifier){
        this. itdentifier = itdentifier;
    }

    public int getItdentifier() {
        return itdentifier;
    }

    public void setItdentifier(int itdentifier) {
        this.itdentifier = itdentifier;
    }
}
