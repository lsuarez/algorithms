package com.arrays;

import java.util.*;

public class FraudulentActivity {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        int notifications = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] pastActivity = new int[201];
        for(int i = 0; i < d; i++)
        {
            int transaction = expenditure.get(i);
            queue.offer(transaction);
            pastActivity[transaction] = pastActivity[transaction]+1;
        }

        for(int i = 0; i < expenditure.size()-d; i++)
        {
            int newTransaction = expenditure.get(i+d);

            if(newTransaction >= (2* median(pastActivity, d)))
                notifications++;
            int oldestTransaction = queue.poll();
            pastActivity[oldestTransaction] = pastActivity[oldestTransaction]-1;
            queue.offer(newTransaction);
            pastActivity[newTransaction] = pastActivity[newTransaction]+1;
        }

        return notifications;
    }

    static double median(int[] array, int elements)
    {
        int index = 0;
        int counter = (elements / 2);
        if(elements % 2 == 0) {
            while(counter > 0)
            {
                counter -= array[index];
                index++;
            }
            index--;
            if(counter <= -1) {
                return index;
            }
            else{
                int firstIndex = index;
                int secondIndex = index+1;
                while(array[secondIndex] == 0){
                    secondIndex++;
                }
                return (double) (firstIndex + secondIndex) / 2.0;
            }
        }
        else{
            while(counter >= 0)
            {
                counter -= array[index];
                index++;
            }
            return (double) index-1;
        }
    }

/*
BigO -> NK
 */
    public static void main(String[] args) {
        //2 3 4 2 3 6 8 4 5
        List<Integer>list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(4);
        list.add(5);
        System.out.println(activityNotifications(list,5)); //2

        List<Integer>list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(4);

        System.out.println(activityNotifications(list2,4)); //0
    }


}
