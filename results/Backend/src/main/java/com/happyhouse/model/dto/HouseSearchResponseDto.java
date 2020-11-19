package com.happyhouse.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HouseSearchResponseDto {

    private List<HouseDeal> houseDeal = new ArrayList<>();
    private String key;
    private String word;
    private List<Integer> types = new ArrayList<>();

    public List<HouseDeal> getHousedeal() {
        return houseDeal;
    }

    public void setHousedeal(List<HouseDeal> housedeal) {
        this.houseDeal = housedeal;
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

    public List<Integer> getTypes() {
        return types;
    }

    public void setTypes(List<Integer> types) {
        this.types = types;
    }
}
