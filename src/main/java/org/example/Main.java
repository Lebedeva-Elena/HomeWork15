package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            AuthenticationValidator.checkAuthentication("logGin12", "password",
                    "password1");
            System.out.println("Аутентификация пройдена успешно");
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
