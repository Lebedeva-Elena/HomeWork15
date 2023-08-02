package org.example;

import java.util.regex.Pattern;

public class AuthenticationValidator {
    public static Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkAuthentication(String login, String password, String confirmPassword)
            throws WrongLoginException,WrongPasswordException {
        checkLogin(login);
        checkPassword(password);
        checkEqualsPassword(password, confirmPassword);
    }

    private static void checkLogin(String login) {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException("Login содержит в себе только латинские буквы," +
                    " цифры и знак подчеркивания," + " должен быть равен или меньше 20 символов");

        }
    }

    private static void checkPassword(String password) throws WrongPasswordException {
            if (!password.matches(regex.pattern())) {
                throw new WrongPasswordException("Password содержит в себе только латинские буквы," +
                        " цифры и знак подчеркивания," + " должен быть равен или меньше 20 символов");
            }
    }
    private static void checkEqualsPassword(String password, String confirmPassword)
    throws WrongPasswordException{
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }
}


