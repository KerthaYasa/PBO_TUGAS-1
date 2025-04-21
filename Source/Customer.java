package model;

import java.util.*;

public class Customer extends Account {
    private Map<Saham, Integer> sahamOwned = new HashMap<>();
    private Map<SuratBerhargaNegara, Double> sbnOwned = new HashMap<>();

    public Customer(String username, String password) {
        super(username, password);
    }

    public Map<Saham, Integer> getSahamOwned() {
        return sahamOwned;
    }

    public Map<SuratBerhargaNegara, Double> getSbnOwned() {
        return sbnOwned;
    }
}