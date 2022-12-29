package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {

    private DateTimeFormatter dateTimeFormatter;
    public void print(Member member){
        if(dateTimeFormatter ==null){
            System.out.printf(
                    "id=%d, email=%s, name=%s, date=%tF\n",
                    member.getId(),member.getEmail(),
                    member.getName(),member.getRegisterDateTime());
        } else {
            System.out.printf(
                    "회원정보 id =%d, email = %s, name = %s, date=%s",
                    member.getId(),member.getEmail(),member.getName(),
                    dateTimeFormatter.format(member.getRegisterDateTime()));

        }
    }
    @Autowired
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter){
        this.dateTimeFormatter =dateTimeFormatter;
    }

    /*스프링 5 자바8 부터 지원하는 Optional이용
    @Autowired(required =false)
    public void setDateTimeFormatter(Optional<DateTimeFormatter> formatterOpt){
        if(formatterOpt.isPresent()){
            this.dateTimeFormatter = formatterOpt.get();
        } else {
            this.dateTimeFormatter = null;
        }
    }
    */
}
