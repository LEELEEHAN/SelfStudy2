package spring;

@Configuration
@Import({AppConf1.class,AppConf2.class}) //이부분 주목
public class AppConfImport {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }

}
