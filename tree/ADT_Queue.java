/**
 *
 *ADT Queue for correct implementation
 *********resume on Queue_Dinamic.java
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public interface ADT_Queue {
    public boolean isEmpty();
    public boolean isFull();
    
    public Object enqueue(Object x);
    
    public Object dequeue();
    
    public Object peek();
    
    @Override
    public String toString();
}
