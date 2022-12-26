package spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainAssembler {

    public static void main(String[] args) throws IOException{
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("명령어 입력");
            String command =reader.readLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("종료");
                break;
            }
            if(command.startsWith("new ")){
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")){
                processChangeCommand(command.split(" "));
                continue;
            }

            printHelp();
        }
    }
    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[] arg){
        if(arg.length != 5){
            printHelp();
        }
        MemberRegisterService regSvg = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호 불일치");
            return;
        }
        try {
            regSvg.regist(req);
            System.out.println("등록했습니다");
        } catch (DuplicateMemberException e){
            System.out.println("이미 존재하는 아이디입니다");
        }
    }
    private static void processChangeCommand(String[] arg){
        if(arg.length!=4){
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc =
                assembler.getChangePasswordService();
        try {
            changePwdSvc.changePassword(arg[1],arg[2],arg[3]);
            System.out.println("암포 변경");

        } catch (MemberNotFoundException e){
            System.out.println("존재하지않는 아이디");
        } catch (WrongIdPasswordException e){
            System.out.println("아이디와 패스워드 다름");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명력");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println();
    }
}
