/**
 *
 *Simple node to be conteined in a binary tree node on NodeTree.java
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class Node {
    private Object value;
    private Node next;
    
    public Object getValue(){
        return value;
    }
    public void setValue(Object value){
        this.value=value;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next=next;
    }
}
