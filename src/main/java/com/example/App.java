package com.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.err.printf("%s %s, %s %s" + System.lineSeparator(),
                          System.getProperty("os.name"),
                          System.getProperty("os.version"),
                          System.getProperty("java.vm.name"),
                          System.getProperty("java.vm.version")
        );
        System.out.println("Hello World.");
    }
}
