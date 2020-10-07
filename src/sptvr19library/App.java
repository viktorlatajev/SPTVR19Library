/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19library;


import entity.Reader;
import entity.Book;
import entity.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.BookFactory;
import tools.BookSaver;
import tools.HistorySaver;
import tools.ReaderFactory;
import tools.ReaderSaver;

/**
 *
 * @author user
 */
class App {
    private Book[] books = new Book[100];
    private Reader[] readers = new Reader[100];
    private History[] histories = new History[100];
    
    public App() {
        BookSaver bookSaver = new BookSaver();
        books = bookSaver.loadFile();
    
        ReaderSaver readerSaver = new ReaderSaver();
        readers = readerSaver.loadFile();
        
        HistorySaver historySaver = new HistorySaver();
        histories = historySaver.loadFile();
        
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
            System.out.println("7. Список читаемых книг");
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
                    Reader reader1 = new Reader("Nikolay", "Petrov", "54455445");
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
                    ReaderFactory readerFactory = new ReaderFactory();
                    reader = readerFactory.createReader();
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] == null){
                            readers[i]=reader;
                            break;
                        }
                    }
                    ReaderSaver readerSaver = new ReaderSaver();
                    readerSaver.saveReaders(readers);
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
                    System.out.println("--- Выдать книгу ---");
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
                    System.out.print("Выберите номер книги: ");
                    int bookNumber = scanner.nextInt();
                    book = books[bookNumber - 1];
                    System.out.println("--- Список читателей ---");
                    for (int i = 0; i < readers.length; i++) {
                        if(readers[i] != null){
                            System.out.printf("%d. %s%n",i+1,readers[i].toString());
                        }
                    }
                    System.out.print("Выберите номер читателя:");
                    int readerNumber = scanner.nextInt();
                    reader = readers[readerNumber - 1];
                    Calendar c = new GregorianCalendar();
                    History history = new History();
                    history.setBook(book);
                    history.setReader(reader);
                    history.setTakeOnDate(c.getTime());
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                            histories[i]=history;
                            break;
                        }
                    }
                    HistorySaver historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    System.out.println("Читателю "
                            +history.getReader().getLastname()
                            +" выдана книга "
                            +history.getBook().getName()
                    );
                    break;
                case "6":
                    System.out.println("--- Возврат книги ---");
                    System.out.println("--- Список читаемых книг ---");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null
                               && histories[i].getReturnDate() == null){
                            System.out.printf(
                              "%d. Книгу \"%s\" читает %s %s%n",
                              i+1,
                              histories[i].getBook().getName(),
                              histories[i].getReader().getName(),
                              histories[i].getReader().getLastname()
                            );
                        }
                        
                    }
                    System.out.print("Выберите номер возвращаемой книги: ");
                    int historyNumber = scanner.nextInt();
                    c = new GregorianCalendar();
                    histories[historyNumber - 1].setReturnDate(c.getTime());
                    historySaver = new HistorySaver();
                    historySaver.saveHistories(histories);
                    break;
                case "7":
                    System.out.println("--- Список читаемых книг ---");
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] != null
                               && histories[i].getReturnDate() == null){
                            System.out.printf(
                              "%d. Книгу \"%s\" читает %s %s%n",
                              i+1,
                              histories[i].getBook().getName(),
                              histories[i].getReader().getName(),
                              histories[i].getReader().getLastname()
                            );
                        }
                        
                    }
                    break;
                default:
                    System.out.println("Нет такой задачи.");
            }
        }while(repeat);
    }
}
