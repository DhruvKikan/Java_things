import java.util.LinkedList;

public class HW_13July {

    public static class SLNode{
        public int data;
        public SLNode next;
        public SLNode curr=this;

        public SLNode(){this.curr=null;}

        public SLNode(int val){
            this.data=val;
            this.next=null;
        }

        public void print(){
            SLNode iter = this;
            while(iter.next!=null){
                System.out.print(iter.data+" -> ");
                iter=iter.next;
            }
            System.out.println(iter.data);
        }

        public SLNode putbeg(int val){
            SLNode head = new SLNode(val);
            head.next=this;
            return head;
        }

        public SLNode putend(int val){
            SLNode iter = this;
            while(iter.next!=null){
                iter=iter.next;
            }
            iter.next = new SLNode(val);
            return this;
        }

        public SLNode middle(){
            SLNode hare = this;
            SLNode tort = this;
            while(hare.next!=null&&hare.next.next!=null){
                hare=hare.next.next;
                tort=tort.next;
            }
            return tort;
        }

        public SLNode reversed(){
            SLNode prev = null;
            SLNode curr = this;
            while(curr!=null){
                SLNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            return prev;
        }

        public SLNode add1(){
            SLNode tmp = this;
            SLNode iter=tmp.reversed();
            SLNode head=iter;
            int carry=0; int val=1;
            while(iter!=null){
                if(iter.data==9&&(val==1||carry==1)){
                    iter.data=0;
                    carry=1;
                    val=0;
                }
                else{
                    iter.data=iter.data+carry+val;
                    carry=0;
                    val=0;
                }
                iter=iter.next;
            }
            if(carry!=0){
                head.putend(1);
            }
            return head.reversed();
        }

        public SLNode cloned(){
            SLNode iter=this;
            SLNode neu = new SLNode(iter.data);
            SLNode head=neu;
            while(iter.next!=null){
                iter=iter.next;
                SLNode nu = new SLNode(iter.data);
                neu.next=nu;
                neu=nu;
            }
            return head;
        }

        public SLNode includetillind(int ind){
            SLNode head=this;
            SLNode iter=head;
            for(int i=0; i<ind; i++){
                iter=iter.next;
            }
            iter.next=null;
            return head;
        }

    }

    public static class DLNode{
        public int data;

        public DLNode next;

        public DLNode prev;

        public DLNode curr=this;

        public DLNode(){
            this.curr=null;
            this.next=null;
            this.prev=null;
        }

        public DLNode(int val){
            this.next=null;
            this.data=val;
            this.prev=null;
        }


    }


    public static void main(String[] args) {
        HW_13July hw = new HW_13July();

        // SLL things
        /*
        SLNode s1 = new SLNode(6);

        s1=s1.putend(2);
        s1=s1.putend(4);
        s1=s1.putend(7);
        s1=s1.putend(1);
        s1=s1.putend(5);
        s1.print();

        s1.add1().print();
        SLNode s2 = s1.cloned();
        s2.print();
         */
        

        System.out.println("Wow");
    }
}


/*
- [x] Reverse a linked list
    - [ ] For this we need to discuss recursion a little bit


- [x] Singly linked list -> Find the starting point of the loop
- [x] Find the length of the loop in the singly linked list
- [x] Find length of CLL
- [x] Find middle in CLL
- [x] Make middle as head of CLL
 */

//