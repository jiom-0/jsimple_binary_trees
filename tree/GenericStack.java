/**
 *
 *a generic stack for the Traversal.java file
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class GenericStack<E>{
    private Node top=null;
    
    public Node push(E novo){
        Node node=new Node();
        node.setValue(novo);
        node.setNext(null);
        if(top==null){
            top=node;
        }else{
            node.setNext(top);
            top=node;
        }
        return node;
    }
    public E pop(){
        if(top==null){
            return null;
        }
        E value=(E)top.getValue();
        Node temp=top;
        top=top.getNext();
        temp=null;
        return value;
    }
    public boolean isEmpty(){
        if(top==null){
            return true;
        }else{
            return false;
        }
    }
    public E top(){
        if(top==null){
            return null;
        }else{
            return (E)top.getValue();
        }
    }
    public void print(){
        if(!isEmpty()){
            String resp=top.getValue().toString();
            System.out.println(resp);
        }else{
            System.out.println("Empty stack...");
        }
    }
}
