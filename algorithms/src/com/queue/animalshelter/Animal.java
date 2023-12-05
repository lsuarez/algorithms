package com.queue.animalshelter;

public class Animal {
    private String name;
    private ExtraInformation extraInformation= new ExtraInformation();
    public void speak(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public ExtraInformation getExtraInformation() {
        return extraInformation;
    }

    public void setExtraInformation(ExtraInformation extraInformation) {
        this.extraInformation = extraInformation;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", extraInformation=" + extraInformation +
                '}';
    }
}
