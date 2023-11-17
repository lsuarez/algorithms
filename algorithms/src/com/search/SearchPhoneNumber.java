package com.search;

import java.util.ArrayList;
import java.util.List;

public class SearchPhoneNumber {
    //You have a name, and you want to find the person’s phone number in the phone book

    public static String findPhoneByName(String name, List<Person> list){
        return list.stream().filter(p-> p.getName().equals(name)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No data found")).getPhone();
    }
    //You have a phone number, and you want to ind the person’s name in the phone book. (Hint: You’ll have to search through the whole book!)
    public static String findNameByPhone(String phone, List<Person>list){
        return list.stream().filter(p-> p.getPhone().equals(phone))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No data found")).getName();
    }

    //You want to read the numbers of every person in the phone book.
    public static void readPhoneNumbers(List<Person>list){
        list.stream().forEach(p-> System.out.println("Name:"+p.getName()+"  phone:"+p.getPhone()));
    }
    public static void main(String args[]){
        Person p1 = new Person("Liz","5585304512");
        Person p2 = new Person("Ezra","87986253");
        Person p3 = new Person("Anita","777872553");
        Person p4 = new Person("Dany","8889990933");
        List<Person> listPeople= new ArrayList<>();
        listPeople.add(p1);
        listPeople.add(p2);
        listPeople.add(p3);
        listPeople.add(p4);
        System.out.println(SearchPhoneNumber.findPhoneByName("Ezra", listPeople));
        System.out.println(SearchPhoneNumber.findNameByPhone("5585304512", listPeople));
        SearchPhoneNumber.readPhoneNumbers(listPeople);
    }
}
