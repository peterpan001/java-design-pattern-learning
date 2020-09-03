package com.panli.singleton.scene.optimize;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lipan
 * @date 2020-08-31
 * @desc 饿汉模式
 */
public class Logger {

    private FileWriter writer;

    private static final Logger instance = new Logger();

    private Logger() {
        File file = new File("/Users/panli/log.txt");
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance(){
        return instance;
    }

    public void log(String message){
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
