package org.example;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public Logger logger;
    FileHandler fileHandler;
    public Log(String logger_name) throws SecurityException, IOException {
        File file = new File("logger.log");
        fileHandler = new FileHandler("logger.log", true);
        logger = Logger.getLogger(logger_name);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.WARNING);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }
}
