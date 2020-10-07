/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ReaderFactory {

    public Reader createReader() {
        Reader reader = new Reader();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Регистрация читателя ---");
        System.out.print("Имя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Фамилия: ");
        reader.setLastname(scanner.nextLine());
        System.out.print("Телефон: ");
        reader.setPhone(scanner.nextLine());
        return reader;
    }
    
}
