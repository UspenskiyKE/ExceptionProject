import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class ExceptionCatch {
    public static boolean wrongLoginPasswordCatch(String login, String password, String confirmPassword) {
        boolean catchResult=true;
        try {
            Main.register(login,password,confirmPassword);

        } catch (WrongLoginException e) {
            e.printStackTrace();
            catchResult=false;

        } catch (WrongPasswordException e) {
            e.printStackTrace();
            catchResult=false;

        }
        return catchResult;
    }
}



