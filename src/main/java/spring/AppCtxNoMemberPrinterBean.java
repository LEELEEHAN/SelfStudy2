package spring;

@Conguration
public class AppCtxNoMemberPrinterBean {
    private MemberPrinter printer = new MemberPrinter(); //빈이 아님

    //... 생략

    @Bean
    public MemberListPrinter listPrinter(){
        return new MemberListPrinter(MemberDao(),printer());
    }

    @Bean
    public MemberInfoPrinter infoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDao(memberDa());
        infoPrinter.setPrinter(printer);
        return infoPrinter;
    }
    //...생략
}
