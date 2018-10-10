package linkedlist;

import java.util.HashSet;

public class linkedList{
	listNode front = null;
        int size_of_stack =0;
        int size_of_queue = 0;
	public linkedList(int data){
		front = new listNode(1);
	}
	public linkedList(){
		front = null;
	}
	public listNode addToEnd(int data) {
		listNode temp = new listNode(data);
		listNode cur;
		/** this is an empty list */
		if(front == null) {
			front = temp;
		}
		else {
			cur = front;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = temp;
		}
                return temp;
	}
        
        
        public listNode addToEndNext(int data,listNode next) {
		listNode temp = new listNode(data,next);
		listNode cur;
		/** this is an empty list */
		if(front == null) {
			front = temp;
		}
		else {
			cur = front;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = temp;
		}
                return temp;
	}
        /*return kth from last element*/
        public listNode lastelement(int k){
            listNode cur = front;
            listNode next = front;
            if(front==null || k<=0){
                return null;
            }
            int n=k;
            while(cur!=null && n>1 ){
                cur = cur.next;
                n--;
            }
            //n=k;
            if(cur==null){
                return null;
            }
            while(cur.next!=null){
                cur = cur.next;
                next = next.next;
            }
            return next;
        }
        
        
        //delete duplicates
        public void deleteduplicates(){
            HashSet<Integer> set =new HashSet<Integer>();
            listNode cur = front;
            listNode prev=null;
            if(front==null){
                return;
            }
            while(cur!=null){
                if(!set.contains(cur.data)){
                    set.add(cur.data);
                    prev = cur;
                    
                }
                else{
                    prev.next = cur.next;
                }
                cur = cur.next;
            }
            return;
        }
        /*delete the node given access only to that*/
        public void deleteMiddle(listNode given){
            listNode cur = given;
            if(given == null){
                return;
            }
            cur = cur.next;
            given.data = cur.data;
            if(cur.next!=null){
                given.next = cur.next;
                cur.next = null;
            }
            else{
                given.next = null;
            }
            return;
            
        }
        public void partition(int x){
            listNode cur = front;
            
            if(front==null){
                return;
            }
            listNode front1 = null;
            listNode front2 = null;
            listNode temp = null;
            listNode ptr1 = front1;
            listNode ptr2 = front2;
            
            while(cur!=null){
                if(cur.data<x){
                    if(front1 ==null) {
                        front1 =cur;
                        ptr1 = front1;
                    }
                    else {
                        ptr1.next = cur;
                        ptr1 = ptr1.next;
                    }
                }
                else if(cur.data>=x){
                    if(front2==null) {
                        front2 =cur;
                        ptr2 = front2;                        
                    }
                    else {
                        ptr2.next = cur;
                        ptr2 = ptr2.next;
                    }
                }
                        temp = cur.next;
                        cur.next = null;
                        cur = temp;
                
            }
            if(front1 !=null){
                front = front1;    
            }
            if(ptr1!=null){
                ptr1.next = front2;
            }
        }
        public listNode circular(){
            listNode cur = front;
            HashSet<listNode> set=new HashSet<listNode>();  
            if(front ==null){
                return null;
            }
            while(cur!=null){
                if(!set.contains(cur)){
                    set.add(cur);
                    
                }
                else{
                    break;
                }
                cur = cur.next;
            }
            return cur;
        }
        
        
        
        
        public listNode getFront(){
            return front;
        }
        public void printlist(){
            listNode cur = front;
            if(front==null){
                System.out.print("empty string");
            }
            while(cur!=null){
                System.out.print(cur + ", ");
                cur = cur.next;
            
            }
            System.out.println();
        } 
        
        //return middle of the linked list in O(n)
        public listNode middle(){
            listNode slow = null;
            listNode fast = front;
            if(front==null || front.next==null){
                return null;
            }
            
            while(fast!=null && fast.next!=null){
                if(fast != front){
                    fast = fast.next;
                }
                if(slow ==null){
                    slow = front;
                }
                else{
                    slow = slow.next;
                }
                
                    fast = fast.next;
                
            }
            return slow;
        }
        public listNode middle_vishak(){
            listNode slow = null;
            listNode fast = front;
            if(front==null || front.next==null){
                return null;
            }
            fast = front.next;
            slow = front;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next;
                fast = fast.next;
            }
            return slow;
        }
        
        /*merges two sorted linked list to a single one, without addtional memory 
        and returns front of the new list */
        public listNode mergeLinkedList(linkedList list2){
            listNode front1 = this.front;
            listNode front2 = list2.front;
            listNode front3 = null;
            listNode cur = null;
            
            while(front1!=null && front2!=null){
                if(front1.data<front2.data){
                    if(front3==null){
                        front3 = front1;
                    }
                    else{
                        cur.next=front1;
                    }
                    front1 = front1.next;
                }
                else{
                    if(front3==null){
                        front3 = front2;
                    }
                    else{
                        cur.next = front2;
                    }
                    front2 = front2.next;
                }
                if(cur==null){
                    cur = front3; 
                }
                else{
                    cur = cur.next;
                }
                cur.next= null;
            }
            if(front1!=null){
                cur.next = front1;
            }
            if(front2!=null){
                cur.next = front2;
            }
        
            return front3;
        }
        
        //switch pairs
        public void switchPairs(){
            listNode cur = front;
            listNode prev =null;
            if(front==null){
                return;
            }
            listNode next = cur.next;
            listNode temp = null;
            while(cur!=null && next!=null){
                if(prev==null){
                    front = next;
                    temp = front.next;
                    front.next = cur;
                }
                else{
                    prev.next = next;
                    if(next.next!=null){
                        temp = next.next;
                    }
                    else{
                        temp =null;
                    }
                    next.next = cur;
                }
                prev = cur;
                prev.next = temp;
                cur = prev.next;
                if(cur!=null){
                    next = cur.next;
                }
            }
        }
        
        //rotate by n
        public void rotateByN(int n){
            listNode first_ptr = front;
            listNode second_ptr = front;
            listNode newfront = front;
            listNode temp = null;
            int size =1,index = 0,i=0;
            if(front==null){
                return;
            }
            while(first_ptr.next != null){
                size++;
                first_ptr = first_ptr.next;
            }
            index = size-n;
            if(n==0 || index ==0){
                return;
            }
            while(second_ptr.next!=null){
                i++;
                temp = second_ptr.next;
                if(i==index){
                    second_ptr.next = null;
                    //if(temp!=null){
                        newfront = temp;
                    //}
                }
                second_ptr = temp;
            }
            second_ptr.next = front;
            front = newfront;
        }
        
        //delete alternate nodes of a linked list
        public void deleteAlternate(){
            listNode prev=front;
            if(front ==null){
                return;
            }
            listNode cur = front.next;
            while(cur!=null && cur.next!=null){
                prev.next = cur.next;
                cur.next = null;
                prev = prev.next;
                cur = prev.next;
            }
            if(cur!=null){
                cur.next = null;
                prev.next = null;
            }
        }
        
        //reverse a linked list
        public void reverse(){
            listNode cur = front;
            if(front == null){
                return;
            }
            listNode next = cur.next;
            listNode temp = cur;
            while(next!=null){
                if(cur == front){
                    cur.next = null;
                }
                temp = next.next;
                next.next = cur;
                cur = next;
                next = temp;
                
            }
            front=cur;
        }
        
        //reverse a range of nodes in linkedlist
        public void reverseRange(listNode lower,listNode upper){
            listNode cur = front;
            listNode prev = null;
            if(front == null){
                return;
            }
            while(cur.next!=null){
                if(cur==lower){
                    listNode next = cur.next;
                    listNode temp = cur;
                    while(cur!=upper){
                        if(cur == front){
                            cur.next = null;
                        }
                        temp = next.next;
                        next.next = cur;
                        cur = next;
                        next = temp;
                    }
                    if(prev!=null){
                        prev.next = upper;
                    }
                    else{
                        front = upper;
                    }
                    lower.next = next;
                    break;
                }
                
                    prev = cur;
                
                cur = cur.next;
            }
            
        }
        
        
        //Stack implementation
        
        //add new element to end of linked list
        public void push(int data){
            listNode temp = new listNode(data);
		listNode cur;
		/** this is an empty list */
		if(front == null) {
			front = temp;
                        size_of_stack++;
		}
		else {
			cur = front;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = temp;
                        size_of_stack++;                        
		}
        }
        
        //removes and return last element inserted into the linked list
        public int pop(){
            listNode prev = null;
            if(front==null){
                return Integer.MAX_VALUE;
            }
            if(front.next==null){
                int temp = front.data;
                front = null;
                size_of_stack--;
                return temp;
            }
            listNode cur = front;
            while(cur.next!=null){
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            size_of_stack--;
            return cur.data;
        }
        
        //returns the last element in the linked list
        public int peek(){
            if(front==null){
                return Integer.MAX_VALUE;
            }
            listNode cur = front;
            while(cur.next!=null){
                cur = cur.next;
            }
            return cur.data;
        }
        
        //returns boolean if linked list has value
        public boolean isEmpty(){
            if(front==null){
                return true;
            }
            else{
                return false;
            }
        } 
        
        //returns the position of the element from the end of the linked list
        public int search(listNode element){
            int index=0;
            if(front==null){
                return Integer.MAX_VALUE;
            }
            listNode cur = front;
            while(cur!=null){
                if(cur.data==element.data){
                    return size_of_stack-index;
                }
                
                cur = cur.next;
                index++;
            }
            return Integer.MAX_VALUE;
        }
        
        
        //Queue implementation
        public void q_add(int data){
            listNode temp = new listNode(data);
		listNode cur;
		/** this is an empty list */
		if(front == null) {
			front = temp;
                        size_of_queue++;
		}
		else {
			cur = front;
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.next = temp;
                        size_of_queue++;                        
		}
        }
        
        //removes and return last element inserted into the linked list
        public int remove(){
            int temp = Integer.MAX_VALUE;
            listNode cur = null;
            if(front!=null){
                cur = front.next;
                temp = front.data;
                front = cur; 
                size_of_queue--;
            }
            
            return temp;
        }
        
        //returns the last element in the linked list
        public int q_peek(){
            if(front==null){
                return Integer.MAX_VALUE;
            }
            else{
                return front.data;
            }
        }
        
        //returns boolean if linked list has value
        public boolean q_isEmpty(){
            if(front==null){
                return true;
            }
            else{
                return false;
            }
        }
        
     

   
        
        
  
/* redo */
    public listNode[] splitListToParts(listNode front, int k) {
        listNode[] arr = new listNode[k];
        int size=0;
        int i=0;
        int cap=0;
        int flag=1;
        listNode cur = front;
        listNode prev = null;

        if(front==null){
            return arr;
        }
        while(cur!=null){
            size++;
            cur = cur.next;
        }
        int index = size/k;
        if(size%k!=0){
            int reminder = size%k;
            while(cur!=null){
                    if(prev==null && i<index){
                        front = cur; 
                        arr[i]=front;
                        i++;
                    }
                    else{
                        break;
                    }
                    while(cap<k+1 && reminder>0){
                        prev = cur;
                        cur = cur.next;
                        cap++;
                    }
                    cap=0;
                    reminder--;
                    prev.next = null;
                    prev=null;
            }
            while(cur!=null){
                front = cur; 
                arr[i]=front;
                prev = cur;
                cur = cur.next;
            }
            
        }
        
        
        else{
            while(cur!=null){
                if(prev==null && i<index){
                    front = cur; 
                    arr[i]=front;
                }
                while(cap<k){
                    prev = cur;
                    cur = cur.next;
                    cap++;
                }
                cap=0;
                prev.next = null;
                prev=null;
            }
        }
        
        return arr;
    }

        
}