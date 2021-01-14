/**
 *
 *Dinamic Queue for Traversal.java file
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class Queue_Dinamic implements ADT_Queue{
    private Node head=null, tail=null;
    
    public Queue_Dinamic(){
        head=null;tail=null;
    }
    
    @Override
    public boolean isEmpty(){
        if(head==null)return true;
        return false;
    }
    
    @Override
    public boolean isFull(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Object must be non-null...
    @Override
    public Object enqueue(Object x){
        if(x==null){
            return null;
        }
        try {
            Node newnode=new Node();
            newnode.setValue(x);
            newnode.setNext(null);
            if(tail==null){
                head=newnode;
                tail=newnode;
            }else{
                tail.setNext(newnode);
                tail=newnode;
            }
            return x;
        }catch(Exception ex){
            return null;
        }
    }
    
    @Override
    public Object dequeue(){
        if(isEmpty())return null;
        Object value=head.getValue();
        Node temp=head;
        head=head.getNext();
        if(head==null){
            tail=null;
        }
        temp=null;
        return value;
    }
    
    @Override
    public Object peek(){
        if(isEmpty())return null;
        else return head.getValue();
    } 
    
    public String toString(){
        if(!isEmpty()){
            String output="";
            Node aux=head;
            while(aux!=null){
                output+=aux.getValue().toString();
                aux=aux.getNext();
                if(aux!=null){
                    output+=",";
                }
            }
            return ("f:["+output+"]");
        }else{
            return("f:[]");
        }
    }
}
