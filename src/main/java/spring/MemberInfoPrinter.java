package spring;

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email){
        Member member = memberDao.selectByEmail(email);
        if(member == null){
            System.out.println("no data");
            return;
        }
        printer.print(member);
        System.out.println();
    }

    public void setMemberDao(MemberDao memberDao){
                //세터 메서드 작성
        this.memberDao = memberDao;
    }

    public void setPrinter(MemberPrinter printer){
                //세터 메서드 작성
        this.printer =printer;
    }
}
