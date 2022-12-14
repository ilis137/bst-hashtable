package com.javapractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger log = LogManager.getLogger(App.class);
  LinkedHashTable<String, Integer> linkedHashTable;
  HashTable<String,Integer> hashTable;
    public void determineWordFrequency() {
        log.info("----------Basic Hash Table------------");
        String sentence = "To be or not to be";
        hashTable = new HashTable<>();
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

    public void determineParaWordFrequency(){
        log.info("----------Linked Hash Table------------");
        String sentence = "Paranoids are not paranoid because they are paranoid but "+
                "because they keep putting themselves " +
                "deliberately into paranoid avoidable situations";
       linkedHashTable= new LinkedHashTable<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words){
            Integer value = linkedHashTable.get(word);
            if (value == null)
                value=1;
            else
                value=value+1;
            linkedHashTable.add(word,value);
        }
        log.info("word | frequency");
        linkedHashTable.print();
    }

    public void removeWord(){
        String itemToRemove="avoidable";
        log.info("----------Delete value pair in Linked Hash Table------------");
        boolean success=linkedHashTable.remove(itemToRemove);
        if(success){
            log.info("successfully deleted "+itemToRemove+"from linked hash table");
        }else{
            log.info("unable to delete "+itemToRemove+"from linked hash table");
        }
        log.info("word | frequency");
        linkedHashTable.print();
    }

    public static void main(String[] args) {
        App app = new App();
        app.determineWordFrequency();
        app.determineParaWordFrequency();
        app.removeWord();
    }
}
