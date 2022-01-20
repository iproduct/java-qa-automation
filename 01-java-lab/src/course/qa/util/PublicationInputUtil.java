package course.qa.util;

import course.qa.model.Book;
import course.qa.model.Publication;
import course.qa.model.User;

import java.util.Scanner;

public class PublicationInputUtil {
    public static Publication inputNewPublication() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input title (2-80 characters): ");
        String ansStr = sc.nextLine();
        return new Book();
    }
}
