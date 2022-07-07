import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import java.util.Scanner;



public class Main {
    static final String alfLoginPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxwz0123456789_";
    public static void main(String[] args) {
        boolean result;
       try(Scanner keyboardEnter = new Scanner(System.in)) {
           System.out.println("Придумайте логин. Он может содержать только латинские буквы, цифры и знак подчеркивания.");
           System.out.println("Также длина логина не должна превышать 20 символов:");
           String login = keyboardEnter.nextLine();
           System.out.println("Придумайте пароль. Он может содержать только латинские буквы, цифры и знак подчеркивания.");
           System.out.println("Также длина пароля не должна превышать 20 символов:");
           String password = keyboardEnter.nextLine();
           System.out.println("Подтвердите введенный пароль:");
           String confirmPassword = keyboardEnter.nextLine();
           result = ExceptionCatch.wrongLoginPasswordCatch(login, password, confirmPassword);
           if (result == false) {
               System.out.println("Проверка данных не пройдена.");
           } else {
               System.out.println("Проверка пройдена успешно.");
           }
       }

    }

    public static void register(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{

        String loginLetter;
        String passwordLetter;

        if (login.length() > 20) {
            throw new WrongLoginException("Проверьте логин на соответствие ограничениям по допустимым символам и по длине.");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Проверьте пароль на соответствие ограничениям по допустимым символам и по длине. Проверьте, совпадают ли пароли.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Проверьте пароль на соответствие ограничениям по допустимым символам и по длине. Проверьте, совпадают ли пароли.");
        }

        for (int i = 0; i < login.length(); i++) {
            loginLetter = String.valueOf(login.charAt(i));
            if(!alfLoginPassword.contains(loginLetter)) {
                throw new WrongLoginException("Проверьте логин на соответствие ограничениям по допустимым символам и по длине.");
            }
        }

        for (int i = 0; i < password.length(); i++) {
            passwordLetter = String.valueOf(password.charAt(i));
            if(!alfLoginPassword.contains(passwordLetter)) {
                throw new WrongPasswordException("Проверьте пароль на соответствие ограничениям по допустимым символам и по длине. Проверьте, совпадают ли пароли.");
            }
        }
    }
}



