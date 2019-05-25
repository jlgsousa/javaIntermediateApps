package scrap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicScrapper {
    private final static Logger LOGGER = Logger.getLogger(BasicScrapper.class.getName());
    private static Scanner scanner;

    public static void main(String[] args) throws IOException {
        LOGGER.setUseParentHandlers(false);

        scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reddit basic scrapper");
        System.out.println("Let's see how bored you are in a scale from 1 to massive procrastinator");

        System.out.println("*******************************");
        System.out.println("*  Reddit front page's titles *");
        System.out.println("*******************************");
        System.out.println("\n\n\n");

        int page = 1;
        while (true) {
            scrap("https://www.reddit.com/?page=" + page);

            System.out.println("Want some more? (y/n)");
            if (!scanner.nextLine().equals("y")) {
                evaluateUser(page);
                System.out.println("Thank you have a nice day \uD83D\uDE09");
                break;
            }
            page++;
        }
    }

    private static void scrap(String url) throws IOException {
        Connection connection = Jsoup.connect(url);

        Document page = connection.get();
        LOGGER.log(Level.INFO,"Getting 2x-container");
        Element mainContainer = page.getElementById("2x-container");

        Element firstStep = getFirstChildInLevel(mainContainer, 3);
        LOGGER.log(Level.INFO, "Getting 3rd child of " + firstStep.tagName());
        LOGGER.log(Level.INFO, "Deeper 3 levels in " + firstStep.tagName());

        Element secondStep = getFirstChildInLevel(firstStep.children().get(3), 3);
        LOGGER.log(Level.INFO, "Getting 2nd child of " + secondStep.tagName());
        LOGGER.log(Level.INFO, "Getting 2nd child of " + secondStep.children().get(1).tagName());
        LOGGER.log(Level.INFO, "Getting 4th child of " + secondStep.children().get(1).children().get(3).tagName());

        Element divWithSections = getFirstChildInLevel(secondStep.children().get(1).children().get(3), 2);

        Elements sections = divWithSections.children();

        for (Element element : sections) {

            Element scrollerItem = getFirstChildInLevel(element, 2);

            if (!scrollerItem.className().contains("scrollerItem")) continue;

            LOGGER.log(Level.INFO, "Getting 2nd child of " + scrollerItem.tagName());
            LOGGER.log(Level.INFO, "Getting 2nd child of " + scrollerItem.children().get(1).children().get(1));

            Element fourthStep = scrollerItem.children().get(1).children().get(1);
            LOGGER.log(Level.INFO, "Deeper 3 levels in " + fourthStep.tagName());

            Element fifthStep = getFirstChildInLevel(fourthStep, 3);

            if (!fifthStep.text().equals("")) {
                System.out.println("-" + fifthStep.text() + "\n ");
            }
        }
    }

    private static Element getFirstChildInLevel(Element element, int level) {
        Element element1 = element.clone();
        try {
            for (int i = 0; i < level; i++) {
                LOGGER.log(Level.INFO, "Deeper 1 level in " + element1.tagName());
                if (("h2").equals(element1.tagName())) break;
                element1 = element1.child(0);
            }
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            LOGGER.log(Level.SEVERE, "Exception reached in level " + level + " of element" +
                    element1);
        }
        return element1;
    }

    private static void evaluateUser(int requestedPages) {
        if (requestedPages <= 5) {
            System.out.println("Ok off you go now, there's work to do");
        } else if (requestedPages <= 10) {
            System.out.println("Are you sure you don't want to see some more?");
            scanner.next();
            System.out.println("Well now it's too late haha");
        } else if (requestedPages > 10) {
            System.out.println("Dude, get a life...");
        }
    }
}
