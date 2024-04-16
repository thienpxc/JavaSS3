package bt9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {
    private List<Book> books = new ArrayList<>();
    private File file;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager("books.txt");
    while (true) {
        System.out.println("1. Add a book");
        System.out.println("2. Update a book");
        System.out.println("3. Delete a book");
        System.out.println("4. Display all books");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                Book book = bookManager.inputData(scanner);
                bookManager.addBook(book);
                break;
            case 2:
                Book book1 = bookManager.inputData(scanner);
                bookManager.updateBook(book1);
                break;
            case 3:
                System.out.println("Enter the title of the book you want to delete: ");
                String title = scanner.nextLine();
                bookManager.deleteBook(title);
                break;
            case 4:
                bookManager.displayAllBooks();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice");
        }
    }
    }
    public Book inputData(Scanner scanner) {
        System.out.println("Enter the title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the author: ");
        String author = scanner.nextLine();
        System.out.println("Enter the publisher: ");
        String publisher = scanner.nextLine();
        System.out.println("Enter the price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        return new Book(title, author, publisher, price);
    }
    public BookManager(String filePath) {
        file = new File(filePath);
        if (file.exists()) {
            readFromFile();
        }
    }

    public void addBook(Book book) {
        books.add(book);
        writeToFile();
    }

    public void updateBook(Book book) {
        if (books.isEmpty()) {
            System.out.println("No books to update");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(book.getTitle())) {
                books.set(i, book);
                writeToFile();
                return;
            }
        }
    }

    public void deleteBook(String title) {
        if (books.isEmpty()) {
            System.out.println("No books to delete");
            return;
        }
        books.removeIf(book -> book.getTitle().equals(title));
        writeToFile();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to display");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private void readFromFile() {
        if (file.length() == 0) {
            System.out.println("File is empty. No data to read.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            books = (List<Book>) ois.readObject();
        } catch (EOFException e) {
            System.out.println("Reached end of file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}