import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner keyboardEnter = new Scanner(System.in);
        System.out.println("Придумайте логин. Он может содержать только латинские буквы, цифры и знак подчеркивания.");
        System.out.println("Также длина логина не должна превышать 20 символов:");
        String login = keyboardEnter.nextLine();
        System.out.println("Придумайте пароль. Он может содержать только латинские буквы, цифры и знак подчеркивания.");
        System.out.println("Также длина пароля не должна превышать 20 символов:");
        String password = keyboardEnter.nextLine();
        System.out.println("Подтвердите введенный пароль:");
        String confirmPassword = keyboardEnter.nextLine();
        String result = exceptionCatch(login, password, confirmPassword);
    }

    public static boolean Register(String login, String password, String confirmPassword) {
        String alfLoginPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxwz0123456789_";
        String loginLetter;
        String passwordLetter;
        String passwordConfirmLetter;

        boolean loginLength = true;
        boolean passwordLength = true;
        boolean passwordsMatching = false;
        boolean loginSymbols = true;
        boolean passwordSymbols = true;
        boolean loginSymbolsMutex=true;
        boolean passwordSymbolsMutex=true;

        if (login.length() > 20) {
            loginLength = false;
        }


        if (password.length() > 20) {
            passwordLength = false;
        }

        if (password.equals(confirmPassword)) {
            passwordsMatching = true;
        }

        for (int i = 0; i < login.length(); i++) {
            loginLetter = login.substring(i, i + 1);
            loginSymbols = alfLoginPassword.contains(loginLetter);
            if(!loginSymbols) {loginSymbolsMutex=false;}
        }

        for (int i = 0; i < password.length(); i++) {
            passwordLetter = password.substring(i, i+1);
            passwordSymbols = alfLoginPassword.contains(passwordLetter);
            if(!passwordSymbols) {passwordSymbolsMutex=false;}
        }

        if (loginSymbolsMutex == false||loginLength==false) {
            throw new WrongLoginException("Проверьте логин на соответствие ограничениям по допустимым символам и по длине.");
        }

        if (passwordSymbolsMutex == false||passwordLength==false||passwordsMatching==false) {
            throw new WrongPasswordException("Проверьте пароль на соответствие ограничениям по допустимым символам и по длине. Также проверьте, совпадают ли пароли.");
        }


        boolean methodResult;
        if (loginLength == false || passwordLength == false || passwordsMatching == false || loginSymbols == false || passwordSymbols == false) {
            methodResult = false;
        } else {
            methodResult = true;
        }

        return methodResult;
    }

    public static String exceptionCatch(String login, String password, String confirmPassword) {
        try {
            boolean result = Register(login, password, confirmPassword);

        } catch (WrongLoginException e) {
            e.printStackTrace();
            return "Проверьте логин на соответствие ограничениям по допустимым символам и по длине.";
        } catch (WrongPasswordException e) {
            e.printStackTrace();
            return "Проверьте пароль на соответствие ограничениям по допустимым символам и по длине.";
        }
        finally {
            boolean result = Register(login, password, confirmPassword);
            String registerResult=String.valueOf(result);
            return "Обработка исключений завершена. Метод Register() вернул значение "+registerResult;
        }
    }
}



