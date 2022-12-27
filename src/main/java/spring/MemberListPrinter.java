package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;
    @Autowired
    public MemberListPrinter(MemberPrinter printer){
        this.printer = printer;
    }
    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    @Autowired
    @Qualifier("printer")
    public void setMemberPrinter(MemberPrinter printer){
        this.printer = printer;
    }
    public void printAll(){
        Collection<Member> members = memberDao.selectByAll();
        members.forEach(m-> printer.print(m));
    }
}
