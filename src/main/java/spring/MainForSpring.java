package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {

    private static ApplicationContext ctx = null;

    public static void main(String[] args)throws IOException{

        ctx= new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("명령어를 입력하세요");
            String command = reader.readLine();
            printHelp();
        } else if(command.equals("list")){
            processListCommand();
            continue;
        } else if(command.startWith("info ")){
            processInfoCommand(command.split(" "));
            continue;
        } else if(command.equals("version")){
            processVersionCommand();
            continue;
        }
        printHelp();
    }

    private static void processNewCommand(String[]arg){
        if(arg.length!=5){
            printHelp();
            return;
        }
        MemberRegisterService regSvc=
                ctx.getBean("memberRegSvc",MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호와 활인이 일치하지 않습니다");
            return;
        }
        try{
            regSvc.regist(req);
            System.out.println("등록했습니다");
         } catch (AlreadyExistingMemberException e){
            System.out.println("error");
        }
    }

    private static void processChangeCommand(String[] arg){
        if (arg.length !=4){
            printHelp();
            return;
        }
        ChangePasswordService changeSvc =
                ctx.getBean("changePwdSvc",ChangePasswordService.class);
        try {
            changeSvc.changePassword(arg[1],arg[2],arg[3]);
            System.out.println("success");
        } catch (MemberNotFoundException e){
            System.out.println("not Found user");
        } catch (WrongIdPasswordException e) {
            System.out.println("wrong password");
        }
    }
    private static void printHelp() {
        System.out.println("fuck you");
    }
    private static void processInfoCommand(Stirng[] arg){
        if(arg.length !=2){
            printHelp();
            return;
        }
        MemberInfoPrinter infoPrinter =
                ctx.getBean("infoPrinter",MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(arg[1]);
    }
    private static void processVersionCommand(){
        VersionPrinter versionPrinter=
                ctx.getBean("versionPrinter",VersionPrinter.class);
        versionPrinter.print();

    }
}


