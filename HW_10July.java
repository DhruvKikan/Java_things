public class HW_10July {

    public static class LLNode{
        int data;
        public LLNode next;

        public LLNode addr;

        LLNode(){ // No arg constructor
            this.next=null;
        }

        LLNode(int val){ // 1 arg constructor
            this.data=val;
            this.next=null;
            this.addr=this;
        }

        public LLNode addvalatstart(int num){
            LLNode tmp = new LLNode(num);
            tmp.next = this;
            return tmp;
        }

        public LLNode addvalatend(int num){
            LLNode iter = this;
            while(iter.next!=null){
                iter=iter.next;
            }
            iter.next = new LLNode(num);
            return this;
        }

        public int searchbyval(int val){
            LLNode tmp=this;
            while(tmp.next!=null){
                if(tmp.data==val){
                    return val;
                }
                tmp=tmp.next;
            }
            return -1;
        }

        public int searchbyind(int ind){
            int i=0;
            LLNode tmp=this;
            while(tmp.next!=null){
                if(i==ind){
                    return tmp.data;
                }
                i++;
            }
            if(i==ind){
                return tmp.data;
            }
            return -1;
        }

        public int len(){
            int l=1;
            LLNode tmp=this;
            while(tmp.next!=null){
                l++;
                tmp=tmp.next;
            }
            return l;
        }

        public void print(){
            LLNode iter=this;
            while(iter.next!=null){
                System.out.print(iter.data+" -> ");
                iter=iter.next;
            }
            System.out.println(iter.data);
        }

        public LLNode reversed(){
            LLNode prev = null;
            LLNode curr = this;
            while(curr!=null){
                LLNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            return prev;
        }

        public int kthend(int key){
            LLNode iter = this;
            LLNode ender = this;
            if(key>this.len()){
                return -1;
            }
            for(int i=0; i<key-1; i++){
                ender=ender.next;
            }
            while(ender.next!=null){
                iter=iter.next;
                ender=ender.next;
            }
            return iter.data;
        }

    }

    public static void main(String[] args) {
        HW_10July hw = new HW_10July();

        LLNode ll = new LLNode();

        for(int i=0; i<13; i++){
            ll=ll.addvalatend(i+10);
        }
        ll.print();
        System.out.println("Kth element from end: "+ll.kthend(3));
        System.out.println();
        ll=ll.addvalatstart(42);
        ll.print();
        System.out.println("Kth element from end: "+ll.kthend(3));


        /*
        for(int i=0; i<13; i++){
            ll=ll.addvalatstart(i+10);
        }
        hw.printll(ll);
        ll=ll.addvalatend(42);
        hw.printll(ll);
         */

    }
}


/*
Basic Operations:
Linked List Deletion (Deleting a given key)
Linked List Deletion (Deleting a key at given position)
Write a function to delete a Linked List
*/


/*
HW:
- [x] Find Middle Node in a linked list
- [x] Reverse a linked list
    - [ ] For this we need to discuss recursion a little bit
- [ ] Add 1 to a number represented by linked list

- [ ] How to implement Stack Using an array
- [ ] Implement 2 stacks using 1 array
- [ ] Use of Queue in java
- [ ] Implement Queue using array

 */


/*
Easy:
Print the middle of a given linked list
Write a function that counts the number of times a given int occurs in a Linked List
Check if a linked list is Circular Linked List
Count nodes in Circular linked list
Convert singly linked list into circular linked list
Exchange first and last nodes in Circular Linked List
Reverse a Doubly Linked List
Program to find size of Doubly Linked List
An interesting method to print reverse of a linked list
Can we reverse a linked list in less than O(n)?
Circular Linked List Traversal
Delete a node in a Doubly Linked List
*/

/*
Medium:
Detect loop in a linked list
Find length of loop in linked list
Remove duplicates from a sorted linked list
Intersection of two Sorted Linked Lists
QuickSort on Singly Linked List
Split a Circular Linked List into two halves
Deletion from a Circular Linked List
Merge Sort for Doubly Linked List
Find pairs with given sum in doubly linked list
Insert value in sorted way in a sorted doubly linked list
Remove duplicates from an unsorted doubly linked list
Rotate Doubly linked list by N nodes
Given only a pointer to a node to be deleted in a singly linked list, how do you delete it?
Modify contents of Linked List
*/

/*
Hard:
Intersection point of two Linked Lists.
Circular Queue | Set 2 (Circular Linked List Implementation)
Josephus Circle using circular linked list
The Great Tree-List Recursion Problem.
Copy a linked list with next and arbit pointer
Convert a given Binary Tree to Doubly Linked List | Set
Priority Queue using doubly linked list
Reverse a doubly linked list in groups of given size
Reverse a stack without using extra space in O(n)
Linked List representation of Disjoint Set Data Structures
Sublist Search (Search a linked list in another list)
Construct a linked list from 2D matrix
Partitioning a linked list around a given value and If we don’t care about making the elements of the list “stable”
 */

//