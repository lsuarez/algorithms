package com.queue.animalshelter;

import java.util.EmptyStackException;

/**
 * An Animal Shelter, which holds only dogs and cats, operates on a strictly "first in, first out"
 * basis. People must adopt either the oldest (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat ( and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like. Create a data structure to maintain this system
 * and implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may use the build-in
 * LinkedList data structure.
 */
public class AnimalShelter {
    private SinglyLinkedList<Dog> dogs = new SinglyLinkedList<>();
    private SinglyLinkedList<Cat> cats = new SinglyLinkedList<>();

    public void enqueue(Animal pet){
        if(pet instanceof Cat)
            cats.insert((Cat)pet);
        else
            dogs.insert((Dog)pet);
    }
    public void currentAnimals(){

        System.out.println("****** DOGS ******");
        dogs.displayList();
        System.out.println("****** CATS ******");
        cats.displayList();
    }
    public Cat dequeueCat() throws Exception{
        Cat cat = null;
        if(!cats.isEmpty()){
            cat = cats.remove();
            System.out.println("            CAT ADOPTED: " + cat.toString());
        } else
            System.out.println("WE DON'T HAVE CATS A THIS MOMENT....");
        return cat;
    }
    public Dog dequeueDog() throws Exception {
        Dog dog = null;
        if(!dogs.isEmpty()) {
            dog = dogs.remove();
            System.out.println("            DOG ADOPTED:" + dog.toString());
        }else
            System.out.println("WE DON'T HAVE DOGS A THIS MOMENT....");
        return dog;
    }
    public Animal dequeueAny()throws Exception{
        Animal petCat =null, petDog = null, pet =null;
        if(dogs.isEmpty() && cats.isEmpty())
            System.out.println("WE DON'T HAVE ANY PET TO BE ADOPTED... ");
        else{

        }
        if(!dogs.isEmpty())
            return dequeueDog();
        if(!cats.isEmpty())
            return dequeueCat();
        petCat = cats.peek();
        petDog = dogs.peek();

        if(petCat.getExtraInformation().getArrivalDate().isAfter(petDog.getExtraInformation().getArrivalDate()))
            try {
                pet = dequeueDog();
            }catch(Exception e){
                pet = dequeueCat();
            }
        else {
            try {
                pet = dequeueCat();
            }catch(Exception e) {
                pet = dequeueDog();
            }
        }
        return pet;
    }

    public static void main(String args[]) throws Exception{
        AnimalShelter shelter = new AnimalShelter();
        Animal snuffy= new Cat("1. snuffy");
        Animal logan= new Cat("2. logan");
        Animal morcita= new Dog("1. morcita");
        Animal harry= new Dog("2. harry");
        shelter.enqueue(snuffy);
        shelter.enqueue(logan);
        shelter.enqueue(morcita);
        shelter.enqueue(harry);
        shelter.currentAnimals();
        shelter.dequeueCat();
        shelter.dequeueAny();
        shelter.currentAnimals();

    }
}
