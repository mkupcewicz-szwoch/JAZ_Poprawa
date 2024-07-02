package com.example.jaz_s29467_nbp;

import java.util.List;
public class ResponseNBP {

    private gold gold;
    private String code;
    private List<Rate> rates;
    private double avg_total;


    public ResponseNBP(gold gold, String code, List<Rate> rates, double avg_total) {
        this.gold = gold;
        this.code = code;
        this.rates = rates;
        this.avg_total = avg_total;
    }

    public gold getGold() {
        return gold;
    }
    public void setGold(gold gold) {
        this.gold = gold;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


    public List<Rate> getRates() {
        return rates;
    }
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }


    public double getAvg_total() {
        return avg_total;
    }
    public void setAvg_total(double avg_total) {
        this.avg_total = avg_total;
    }
}
