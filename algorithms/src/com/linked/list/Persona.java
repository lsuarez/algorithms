package com.linked.list;

public class Persona {

    private String name;

    public static void nombre(Persona p){
        p= new Persona();
    }
    public static void nombre2(Persona p){
        p.name = "Liz guapa";

    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Persona p = new Persona();
        p.name = "Manuel guapo ";
        nombre(p);
        System.out.println(p);
        nombre2(p);
        System.out.println(p);

    }
}
