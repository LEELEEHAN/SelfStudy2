package spring;


import java.beans.BeanProperty;

@Configuration
public class AppConf1 {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
}
