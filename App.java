package com.company;

import com.company.Commands.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;

public class App {

    private static final Control control = new Control();

    private static final Develop develop = new Develop(
            new CreateNewGameRoom(control),
            new CreateNewToy(control),
            new ListOfToys(control),
            new OverallWeightBySize(control),
            new OverallValueInPrice(control),
            new SortToysByValue(control),
            new SortToysByWeight(control),
            new PricecRange(control)
    );

    public static class MyFilter implements Filter {

        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("IN_FILE");

        }
    }

    static int select;
    static Scanner scanner = new Scanner(System.in);
    static Logger LOGGER = Logger.getLogger(App.class.getName());

    public void Work() throws IOException {
        Handler fileHandler = new LoggerFile().GetFile();
        fileHandler.setFilter(new MyFilter());
        LOGGER.addHandler(fileHandler);

        while (true) {
            printMenu();
            menuCommands();
        }
    }

    private static void printMenu() {
        System.out.println(
                "\n1. CreateNewGameRoom" +
                        "\n2. CreateNewToy" +
                        "\n3. ListOfToys" +
                        "\n4. OverallWeightBySize" +
                        "\n5. OverallValueInPrice" +
                        "\n6. SortToysByValue" +
                        "\n7. SortToysByWeight" +
                        "\n8. PriceRange" +
                        "\n9. Exit\n" +
                        "\nSelect Command:");
    }

    private static void menuCommands() {

        select = scanner.nextInt();
        if (select <= 0 || select > 9) {
            LOGGER.warning("The value cannot be less than 0 or greater than 9");
            LOGGER.setUseParentHandlers(false);
            LOGGER.info("An error occurred while selecting the menu itemIN_FILE");
            LOGGER.setUseParentHandlers(true);
        }
        switch (select) {
            case 1 -> develop.CreateNewGameRoom();
            case 2 -> develop.CreateNewToy();
            case 3 -> develop.ListOfToys();
            case 4 -> develop.OverallWeightBySize();
            case 5 -> develop.OverallValueInPrice();
            case 6 -> develop.SortToysByValue();
            case 7 -> develop.SortToysByWeight();
            case 8 -> develop.PricecRange();
            case 9 -> System.exit(0);
        }
    }
}
