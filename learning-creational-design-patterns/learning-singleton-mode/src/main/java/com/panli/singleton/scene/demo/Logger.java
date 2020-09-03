package com.panli.singleton.scene.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author lipan
 * @date 2020-08-31
 */
public class Logger {
    private FileWriter writer;

    public Logger(){
        File file = new File("/Users/panli/log.txt");
        try {
            writer = new FileWriter(file, true); //true标识追加写入
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message){
        try {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
