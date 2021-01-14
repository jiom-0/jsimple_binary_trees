/**
 *
 *The container of a simple node to make a binary tree
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class NodeTree<E extends Comparable<E>>{
    public static void main(String[] args){}
    private E value;
    private NodeTree leftchild;
    private NodeTree rightchild;
    
    @Override
    public String toString(){
        return value.toString();
    }
    public NodeTree(E value){
        this.value=value;
        this.rightchild=null;
        this.leftchild=null;
    }
    public E getValue(){
        return value;
    }
    public void setValue(E value){
        this.value=value;
    }
    public NodeTree getLeftChild(){
        return leftchild;
    }
    public void setLeftChild(NodeTree leftchild){
        this.leftchild=leftchild;
    }
    public NodeTree getRightChild(){
        return rightchild;
    }
    public void setRightChild(NodeTree rightchild){
        this.rightchild=rightchild;
    }
}