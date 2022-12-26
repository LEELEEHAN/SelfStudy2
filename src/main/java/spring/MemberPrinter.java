package spring;

public class MemberPrinter {

    public void print(Member member){
        System.out.printf(
                "id=%d, email=%s, name=%s, date=%tF\n",
                member.getId(),member.getEmail(),
                member.getName(),member.getRegisterDateTime());
    }
}
