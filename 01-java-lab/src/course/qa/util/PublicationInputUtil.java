package course.qa.util;

import course.qa.model.Book;
import course.qa.model.Paper;
import course.qa.model.Publication;
import course.qa.model.User;

import java.util.Scanner;

public class PublicationInputUtil {
    public static Publication inputNewPublication() {
        Scanner sc = new Scanner(System.in);
        Publication publication;

        while_choice:
        while(true) {
            System.out.println("Choose publication type [1 - for Book, 2 - for Paper]: ");
            String ansStr = sc.nextLine();
            int choice = Integer.parseInt(ansStr);
            switch (choice) {
                case 1: publication = new Book(); break while_choice;
                case 2: publication = new Paper(); break while_choice;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        while(true) {
            System.out.println("Input title (2-80 characters): ");
            String ansStr = sc.nextLine();
            if(ansStr.length() >= 2 && ansStr.length() <= 80) {
                publication.setTitle(ansStr);
                break;
            } else {
                System.out.println("Invalid title. Please try again.");
            }
        }

        return publication;
    }
}
