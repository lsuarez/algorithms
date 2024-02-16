package com.ca;
/*
Write a class called StringCompare that contains two String fields: 'first' and 'second'.
 */
public class StringCompare {
    private String first;
    private String second;
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getSecond() {
        return second;
    }
    public void setSecond(String second) {
        this.second = second;
    }
    public StringCompare(String first, String second) {
        this.first = first;
        this.second = second;
    }
    public StringCompare() {
    }
}
