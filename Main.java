package com.Main;

import com.GameProcess.Controller;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        Controller gameController = new Controller();
        gameController.startGame();
    }
}
