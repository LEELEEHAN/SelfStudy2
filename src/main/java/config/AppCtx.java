package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.*;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService();
    }
    @Bean
    public ChangePasswordService changePwdSvc(){
        return new ChangePasswordService();
    }
    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
    @Bean
    public MemberInfoPrinter infoPrinter(){
        return new MemberInfoPrinter();
    }
    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return new VersionPrinter();
    }
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1(){
        return new MemberPrinter();
    }
    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }
}
