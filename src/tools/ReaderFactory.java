/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

<<<<<<< HEAD
=======
import entity.Book;
>>>>>>> 9d87868fbefe3083b557a62470d8feff6f02f7c9
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderFactory {
<<<<<<< HEAD
    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Добавление пользователя ---");
=======

    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Регистрация читателя ---");
>>>>>>> 9d87868fbefe3083b557a62470d8feff6f02f7c9
        System.out.print("Имя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Фамилия: ");
        reader.setLastname(scanner.nextLine());
<<<<<<< HEAD
        System.out.print("Номер: ");
=======
        System.out.print("Телефон: ");
>>>>>>> 9d87868fbefe3083b557a62470d8feff6f02f7c9
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
}
