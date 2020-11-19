package com.happyhouse.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Search {

    private String key;
    private String word;
    private List<Integer> types = new ArrayList<>();

    public Search() {
    }

    public Search(String key, String word, List<Integer> type) {
        this.key = key;
        this.word = word;
        this.types = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Integer> getType() {
        return types;
    }

    public void setType(List<Integer> type) {
        this.types = type;
    }

    public String toString() {
        return "key: " + key + ", word: " + word + "type: " + types.toString() +"\n";
    }
}
