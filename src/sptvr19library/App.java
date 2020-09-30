/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import entity.Reader;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Book[] books = new Book[100];
    
    public void run(){
        System.out.println("--- Библиотека ---");
        boolean repeat = true;
        do{
            System.out.println("Список задач: ");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Посмотреть список книг");
            System.out.println("3. Зарегистрировать нового читателя");
            System.out.println("4. Список читателей");
            
            System.out.println("5. Выдать книгу читателю");
            System.out.println("6. Вернуть книгу в библиотеку");
            System.out.print("Выберите задачу: ");
            Scanner scanner = new Scanner(System.in);
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---- Конец программы ----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---- Добавить новую книгу ----");
                    // создадим объект книги
                    Book book = new Book("Voina i Mir", "L.Tolstoy", 2010);
                    books[0] = book;
                    Book book1 = new Book("Otsi i deti", "I.Turgenjev", 2011);
                    books[1] = book1;
                    break;
                case "2":
                    System.out.println("--- Cписок книг ---");
                    for (int i = 0; i < books.length; i++) {
                        if(books[i]!= null){
                            System.out.printf("%3d. Название книги: %s%nАвтор: %s%n"
                                    ,i+1
                                    ,books[i].getName()
                                    ,books[i].getAuthor()
                            );
                            System.out.println("--------------------------------");
                            
                        }
                    }
                    break;
                case "3":
                    System.out.println("--- Зарегистрировать нового читателя ---");
                    Reader reader = new Reader("Martin", "Tamm", "56565656");
                    System.out.printf("Новый пользователь: %s %s%n", 
                                reader.getName(),
                                reader.getLastname()
                           );
                    break;
                case "4":
                    System.out.println("");
                    break;
                case "5":
                    System.out.println("");
                    break;
                case "6":
                    System.out.println("");
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
