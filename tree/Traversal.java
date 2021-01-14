/**
 *
 *Main methods for traversal on a binary tree or a BST
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class Traversal<E> {
    public static void preOrder(NodeTree node){
        if(node!=null){
            System.out.print(node.getValue()+" ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }       
    }
    public static void inOrder(NodeTree node){
        if(node!=null){          
            inOrder(node.getLeftChild());
            System.out.print(node.getValue()+ " ");
            inOrder(node.getRightChild());
        }
    }
    public static void postOrder(NodeTree node){
        if(node!=null){
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.print(node.getValue()+ " ");
        }
    }
    public static void byLevel(NodeTree node){
       NodeTree nodeAux;
       Queue_Dinamic queue=new Queue_Dinamic();
       
       queue.enqueue(node);
       while(!queue.isEmpty()){
           nodeAux=(NodeTree)queue.dequeue();
           if(nodeAux.getLeftChild()!=null)
               queue.enqueue(nodeAux.getLeftChild());
           if(nodeAux.getRightChild()!=null)
               queue.enqueue(nodeAux.getRightChild());
           
           System.out.print(nodeAux.getValue() +" ");
       }
   }
    public static void byLevelLinkedList(NodeTree node){
       NodeTree noAux;
       LinkedList fila=new LinkedList();
       fila.addLast(node);
       while(!fila.isEmpty()){
           noAux=(NodeTree)fila.removeFirst();
           if(noAux.getLeftChild()!=null){
               fila.addLast(noAux.getLeftChild());
           }
           if(noAux.getRightChild()!=null){
               fila.addLast(noAux.getRightChild());
           }
           System.out.print(noAux.getValue()+" ");
       }
   }
    
    private static int nodeCount(int n, NodeTree node){
        if(node!=null){
            n++;
            n=+nodeCount(n,node.getLeftChild());
            n=+nodeCount(n,node.getRightChild());
        }
        return n;
    }
    private static int nodeHeight(NodeTree node){
        if(node==null)return 0;
        else{
            int d=0+nodeHeight(node.getRightChild());
            int e=0+nodeHeight(node.getLeftChild());
            return Math.max(e,d)+1;
        }
    }
    private static int countLeaf(NodeTree node){
        if(node==null)return 0;
        int d=countLeaf(node.getRightChild());
        int e=countLeaf(node.getLeftChild());
        if(d==0&&e==0){
            return 1;
        }else{
            return d+e;
        }
    }
    
    public static int treeSize(NodeTree root){
        int j=0;
        return nodeCount(j,root);
    }
    public static void treeHeight(NodeTree node){
        System.out.print(nodeHeight(node)-1);
    }
    public static void treeLeafCount(NodeTree node){
        System.out.println(countLeaf(node));
    }
    
    private static GenericStack byLevelReverseP(NodeTree node){
       NodeTree nodeAux;
       Queue_Dinamic queue=new Queue_Dinamic();
       GenericStack p=new GenericStack();
       queue.enqueue(node);
       while(!queue.isEmpty()){
           nodeAux=(NodeTree)queue.dequeue();
           if(nodeAux.getLeftChild()!=null)
               queue.enqueue(nodeAux.getLeftChild());
           if(nodeAux.getRightChild()!=null)
               queue.enqueue(nodeAux.getRightChild());
           
           p.push(nodeAux.getValue());
       }
       return p;
   }
    public static void byLevelReverse(NodeTree node){
        GenericStack p=byLevelReverseP(node);
        while(!p.isEmpty()){
            System.out.print(p.pop()+" ");
        }
    }
    
    private static int sumNodes(NodeTree nodo,int soma){
        if(nodo!=null){
            soma=+(int)nodo.getValue();
            soma=+sumNodes(nodo.getLeftChild(),soma);
            soma=+sumNodes(nodo.getRightChild(),soma);
        }
        return soma;
    }
    public static void average(NodeTree node){
        System.out.println(sumNodes(node,0)/treeSize(node));
    }
} 