package com.javapractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);

    public void determineWordFrequency() {
        String sentence = "To be or not to be";
        HashTable<String, Integer> hashTable = new HashTable<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = hashTable.get(word);
            if (value == null)
                value = 1;
            else
                value = value + 1;
            hashTable.add(word, value);
        }
        log.info("word | frequency");
        hashTable.print();
    }

    public static void main(String[] args) {
        App app = new App();
        app.determineWordFrequency();

    }
}
