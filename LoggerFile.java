package com.company.Commands;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

public class LoggerFile {
    static Handler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("java.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Handler GetFile() {
        return fileHandler;
    }
}
