/**
 *
 *Linked List. An alternative for dinamic queues on traversal
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class LinkedList implements ADT_LinkedList{
    private Node head=null,tail=null;
    private int size=0;
    public LinkedList(){
        head=null;
        tail=null;
        size=0;
    }
    
    @Override
    public Object addLast(Object x){
        if(x==null){
            return null;
        }try{
            Node newnode=new Node();
            newnode.setValue(x);
            newnode.setNext(null);
            if(head==null){
                head=newnode;
            }else{
                tail.setNext(newnode);
            }
            tail=newnode;
            size++;
            return x;
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public boolean isEmpty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public Object removeFirst(){
        if(head==null){
            return null;
        }
        Object value=head.getValue();
        Node temp=head;
        head=head.getNext();
        if(head==null){
            tail=null;
        }
        temp.setNext(null);
        temp=null;
        size--;
        return value;
    }
}
