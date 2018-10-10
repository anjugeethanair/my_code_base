/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author Anju
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //TestCase for problem2
        	System.out.println("Hello World");
		linkedList list1 = new linkedList();
                linkedList list2 = new linkedList();
                linkedList list3 = new linkedList();
                linkedList list4 = new linkedList();

		listNode val = list1.addToEnd(7);
                list1.addToEnd(11);
                list1.addToEnd(6);
                //list1.addToEnd(5);
                //list1.addToEnd(4);
                //list1.addToEnd(9);
                //list1.addToEnd(2);
                //list1.addToEnd(1);
                /*
                //for merge
                list1.addToEnd(10);
                list1.addToEnd(20);
                list1.addToEnd(30);
                list1.addToEnd(40);
                list1.addToEnd(60);
                list1.addToEnd(80);
                
                list2.addToEnd(5);
                list2.addToEnd(15);
                list2.addToEnd(25);
                list2.addToEnd(35);
                list2.addToEnd(65);
                list2.addToEnd(90);
                list2.addToEnd(95);
                /*
                list1.addToEnd(45);
                list1.addToEnd(35);
                list1.addToEnd(25);
                list1.addToEnd(15);
                list1.addToEnd(5);
                list1.addToEnd(40);
                list1.addToEnd(30);
                list1.addToEnd(30);*/
               // System.out.println(list1.middle().data);
               // System.out.println(list1.middle_vishak().data);
                //list1.addToEndNext(9,val);
                //list1.addToEnd(3);
                //System.out.println(list1.lastelement(5));
                //list1.printlist();
                //list1.deleteMiddle(val);
                //System.out.println();
                //list1.printlist();
                //list1.partition(1);
                //System.out.println();
                //list1.printlist();
                //linkedList list3 = sum(list1,list2);
                //list3.printlist();
                //System.out.println(list1.circular());
                //listNode front3 = list1.mergeLinkedList(list2);
                //list2.printlist();
                //list1.switchPairs();
                list1.printlist();
                
                list1.rotateByN(1);
                //System.out.println();
                list1.printlist();
                //System.out.println();
                //list1.deleteAlternate();
                //list1.printlist();
                
                
                list1.reverse();
                list1.printlist();
                
                //test case for delete duplicates
                list4.addToEnd(5);
                list4.addToEnd(15);
                list4.addToEnd(20);
                list4.addToEnd(5);
                list4.addToEnd(15);
                list4.addToEnd(20);
                list4.printlist();
                list4.deleteduplicates();
                list4.printlist();
                
                //test case for reverse
                System.out.println("hello");
                
                list3.addToEnd(95);
                listNode lower = list3.addToEnd(15);
                list3.addToEnd(20);
                list3.addToEnd(5);
                list3.addToEnd(75);
                list3.addToEnd(40);
                listNode upper = list3.addToEnd(85);
                list3.addToEnd(90);
                list3.printlist();
                list3.reverseRange(lower, upper);
                list3.printlist();
                System.out.println("hello");
                
                linkedList list5 = new linkedList();
                list5.addToEnd(1);
                list5.addToEnd(2);
                list5.addToEnd(3);
                list5.addToEnd(4);
                list5.addToEnd(5);
                list5.addToEnd(6);
                

                //list5.splitListToParts(list5,2);
                
    }
    public static linkedList sum(linkedList list1,linkedList list2){
        linkedList list3 = new linkedList();
        listNode front1 = list1.getFront();
        listNode front2 = list2.getFront();
        double num1=0,num2=0;
        int sum = 0,val =0,i=0;
        if(front1==null && front2==null){
            return null;
        }
        listNode last1 = front1;
        listNode last2 = front2;
     /* seperate loops*/   
        while(last1 != null){
            val = last1.data;
            num1 = (int)(num1 + (val* Math.pow(10,i)));
            i++;
            last1 = last1.next;
        }
        i=0;
        while(last2 != null){
            val = last2.data;
            num2 = (int)(num2 + (val* Math.pow(10,i)));
            i++;
            last2 = last2.next;
        }
        sum = (int) num1+ (int) num2;
        while(sum>0){
            val = sum %10;
            sum = sum/10;
            list3.addToEnd(val);
        }
     
        
        return list3;
        }
}
