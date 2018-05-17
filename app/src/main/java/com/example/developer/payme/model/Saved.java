package com.example.developer.payme.model;

public class Saved {
    private String savedName;
    private String savedNumber;

    public Saved(String savedName, String savedNumber) {
        this.savedName = savedName;
        this.savedNumber = savedNumber;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getSavedNumber() {
        return savedNumber;
    }

    public void setSavedNumber(String savedNumber) {
        this.savedNumber = savedNumber;
    }
}
