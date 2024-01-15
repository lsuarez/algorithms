package com.tree;


import java.util.ArrayList;
import java.util.List;

public class PrintLeavesByLevel {


    static List<String> levels= new ArrayList<>();
    public static void printLeavesByLevel(BinaryNode node, int level){

        if(node == null){
            level=0;
            return;
        }
        String history;
        if(levels.size()==level){
            levels.add(node.getData()+"");
        }else {
            history = levels.get(level) + " ";
            levels.remove(levels.get(level));
            levels.add(level, history + node.getData());
        }
        level++;
        printLeavesByLevel(node.getLeft(), level);
        printLeavesByLevel(node.getRight(),level);
    }
    public static void main(String[] args) {
        BinaryNode tn =
                new BinaryNode(new BinaryNode(new BinaryNode(3), new BinaryNode(5),4) , new BinaryNode(new BinaryNode(12), new BinaryNode(null, null,9),8), 11);
        printLeavesByLevel(tn,0);
        levels.stream().forEach(System.out::println);
        /*
        11
    4   |  8
 3 | 5  |  12  | 9
 */
    }
}
