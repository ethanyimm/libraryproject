import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            try {
                System.out.println("\n===== Library Management System =====");
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search by Title");
                System.out.println("4. Search by Author");
                System.out.println("5. Display Books");
                System.out.println("6. Display Library Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the title of the book: ");
                        String addTitle = scanner.nextLine();
                        System.out.print("Enter the author of the book: ");
                        String addAuthor = scanner.nextLine();
                        Book newBook = new Book(addTitle, addAuthor);
                        library.addBook(newBook);
                        break;

                    case 2:
                        System.out.print("Enter the title of the book to remove: ");
                        String removeTitle = scanner.nextLine();
                        library.removeBook(removeTitle);
                        break;

                    case 3:
                        System.out.print("Enter the title to search for: ");
                        String searchTitle = scanner.nextLine();
                        Book foundBook = library.searchByTitle(searchTitle);
                        if (foundBook != null) {
                            System.out.println("Book found: " + foundBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter the author to search for: ");
                        String searchAuthor = scanner.nextLine();
                        ArrayList<Book> foundBooksByAuthor = library.searchByAuthor(searchAuthor);
                        if (!foundBooksByAuthor.isEmpty()) {
                            System.out.println("Books found by " + searchAuthor + ":");
                            for (Book book : foundBooksByAuthor) {
                                System.out.println(book);
                            }
                        } else {
                            System.out.println("No books found by " + searchAuthor + ".");
                        }
                        break;

                    case 5:
                        library.displayBooks();
                        break;

                    case 6:
                        library.displayLibraryStats();
                        break;

                    case 7:
                        System.out.println("Exiting the Library Management System. Goodbye!");
                        scanner.close(); // Close the scanner before exiting
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}