/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import entity.Reader;
import entity.Book;
import java.util.Scanner;
import tools.BookFactory;
import tools.BookSaver;

/**
 *
 * @author sillamae kutsekool
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];

    public App() {
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile();
    }
    
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
                    Book book;
                    BookFactory bookFactory = new BookFactory();
                    book = bookFactory.createBook();
                    for (int i = 0; i < books.length; i++) {
                        if(books[i] == null){
                            books[i]=book;
                            break;
                        }
                    }
                    BookSaver bookSaver = new BookSaver();
                    bookSaver.saveBooks(books);
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
                    Reader reader1 = new Reader("Nikolay", "Petrov","54455445");
                    readers[0]=reader;
                    readers[1]=reader1;
                    
                    System.out.printf("Новый пользователь: %s %s%n", 
                                reader.getName(),
                                reader.getLastname()
                           );
                    System.out.printf("Новый пользователь: %s %s%n", 
                                reader1.getName(),
                                reader1.getLastname()
                           );
                    break;
                case "4":
                    System.out.println("--- Список читателей ---");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.printf("%d. %s%n",i+1,readers[i].toString());
                        }
                    }
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
