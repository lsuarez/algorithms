package com.tree;

public class AlphabetTrie {

    public static boolean isValidWord(Trie alphabet, String word, int index){

        if( index == word.length() && alphabet.getLeaves()[0].getCharacter()=='*'  ) {
            return true;
        }
        int i=0;
        while(i<alphabet.getLeaves().length){
            if(alphabet.getLeaves()[i] != null && alphabet.getLeaves()[i].getCharacter() == word.charAt(index)){
               return  isValidWord(alphabet.getLeaves()[i], word, index+1);
            }
            i++;
        }
        return false;
    }


    public static void main(String[] args) {
        Trie initial= new Trie();
        Trie[] childern1= new Trie[3];
        Trie a= new Trie('A');
        Trie terminator = new Trie('*');
        Trie[] childernA = new Trie[1];
        childernA[0]=terminator;
        a.setLeaves(childernA);
        childern1[2]=a;

        Trie l= new Trie('L');
        Trie[] childernL = new Trie[1];

        Trie i =new Trie('I');
        Trie[] childerni = new Trie[1];

        Trie e =new Trie('E');
        Trie[] childerne = new Trie[1];

        Trie m =new Trie('M');
        Trie[] childernm = new Trie[2];

        childerne[0]=terminator;
        childerni[0]=e;
        childernL[0]=i;

        Trie y =new Trie('Y');
        Trie[] childerny = new Trie[1];
        childerny[0]=terminator;
        y.setLeaves(childerny);

        Trie n =new Trie('N');
        Trie[] childernn = new Trie[2];
        childernn[0]=y;
        childernn[1]=terminator;
        n.setLeaves(childernn);

        Trie a2 =new Trie('A');
        Trie[] childerna2 = new Trie[1];
        childerna2[0]= n;
        a2.setLeaves(childerna2);



        childernm[0]=a2;
        childernm[1]=y;

        e.setLeaves(childerne);
        i.setLeaves(childerni);
        l.setLeaves(childernL);
        m.setLeaves(childernm);

        childern1[1]=l;
        childern1[0]=m;
        initial.setLeaves(childern1);

        System.out.println(isValidWord(initial, "LIE", 0));//true
        System.out.println(isValidWord(initial, "MANY", 0));//true
        System.out.println(isValidWord(initial, "MY", 0));//true
        System.out.println(isValidWord(initial, "MANO", 0));//false
    }
}
