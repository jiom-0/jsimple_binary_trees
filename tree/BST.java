/**
 *
 *Here you can see the main methods of an BST (Binary Search Tree)
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class BST <E extends Comparable<E>>{
    private NodeTree root;
    private int i=0;Object[] vector;
    
    public BST(){
        root=null;
    }
    
    public boolean isEmpty(){
        return(root==null);
    }
    
    public void setRaiz(NodeTree root){
        this.root=root;
    }
    
    public NodeTree getRoot(){
        return root;
    }
    
    public E inserir(E value){
        try{
            NodeTree newnode =new NodeTree(value);
            this.insert(newnode, root);
        }catch (Exception exMemory){
            System.out.println("+exMemory");
            return null;
        }
        return (value);
    }
    
    private NodeTree insert(NodeTree newnode,NodeTree previous){
        if(root==null){
            root=newnode;
            return root;
        }
        if(previous!=null){
            if(newnode.getValue().compareTo(previous.getValue())<0){
                previous.setLeftChild(insert(newnode,previous.getLeftChild()));
            }else{
                previous.setLeftChild(insert(newnode,previous.getRightChild()));
            }
        }else{
            previous=newnode;
        }
        return previous;
    }
    public NodeTree iterativeFind(Object obj){
        if(this.isEmpty()){
            return null;
        }
        NodeTree actual=root;
        while(compare(obj,actual.getValue())!=0){
            if(compare(obj,actual.getValue())<0){
                actual=actual.getLeftChild();
            }else{
                actual=actual.getRightChild();
            }if(actual==null){
                return null;
            }
        }
        return actual;
    }
    
    public NodeTree searchABB(Object obj){
        return searchABB(root, obj);
    }
    private NodeTree searchABB(NodeTree node,Object obj){
        if(node==null){
            return null;
        }else{
            if(((Comparable)obj).compareTo(node.getValue())==0){
                return node;
            }else{
                if(((Comparable)obj).compareTo(node.getValue())<0){
                    return searchABB(node.getLeftChild(),obj);
                }else{
                    return searchABB(node.getRightChild(),obj);
                }
            }
        }
    }
    private int compare(Object ob1,Object ob2){
        return((Comparable)ob1).compareTo(((Comparable)ob2));
    }
    public NodeTree getSmaller(NodeTree node){
        if(isEmpty()||node==null){
            return null;
        }
        if(node.getLeftChild()==null){
            return node;
        }else{
            return getSmaller(node.getLeftChild());
        }
    }
    public NodeTree getBigger(NodeTree node){
        if(isEmpty()||node==null){
            return null;
        }if(node.getRightChild()==null){
            return node;
        }else{
            return getBigger(node.getRightChild());
        }
    }
    
    public E insert(E value){
        NodeTree newnode;
        try{
            newnode=new NodeTree(value);
        }catch(Exception exMemory){
            System.out.println(""+exMemory);
            return null;
        }
        if(isEmpty()){
            root=newnode;
        }else{
            NodeTree atual=root;
            NodeTree father;
            while(true){
                father=atual;
                if(compare(value,atual.getValue())<0){
                    atual=atual.getLeftChild();
                    if(atual==null){
                        father.setLeftChild(newnode);
                        break;
                    }
                }else{
                    atual=atual.getRightChild();
                    if(atual==null){
                        father.setRightChild(newnode);
                        break;
                    }
                }
            }
        }
        return value;
    }
    public boolean delete(Object e){
        return delete(this.root,null,e);
    }
    private boolean delete(NodeTree node,NodeTree fatherRoot,Object e){
        NodeTree aux;
        if(node==null){
            return false;
        }else{
            if(compare(e,node.getValue())==0){
                aux=node;
                if(node.getLeftChild()==null&&node.getRightChild()==null){
                    if(fatherRoot==null){
                        setRaiz(null);
                    }else{
                        if(fatherRoot.getLeftChild()!=null
                                &&compare(fatherRoot.getLeftChild().getValue(),e)==0){
                            fatherRoot.setLeftChild(null);
                        }else if(fatherRoot.getRightChild()!=null
                                &&compare(fatherRoot.getRightChild().getValue(),e)==0){
                            fatherRoot.setRightChild(null);
                        }
                    }
                }
                else if(node.getRightChild()==null){
                    if(fatherRoot!=null){
                        if(fatherRoot.getLeftChild()!=null&&compare(fatherRoot.getLeftChild().getValue(),e)==0){
                            fatherRoot.setLeftChild(node.getLeftChild());
                        }else{
                            fatherRoot.setRightChild(node.getLeftChild());
                        }
                    }else{
                        node.setValue(node.getLeftChild().getValue());
                        node.setLeftChild(node.getLeftChild().getLeftChild());
                        node.setRightChild(node.getLeftChild().getRightChild());
                    }
                }else if(node.getLeftChild()==null){
                    if(fatherRoot!=null){
                        if(fatherRoot.getLeftChild()!=null&&compare(fatherRoot.getLeftChild().getValue(),e)==0){
                            fatherRoot.setLeftChild((node.getRightChild()));
                        }else{
                            fatherRoot.setRightChild(node.getRightChild());
                        }
                    }else{
                        node.setValue(node.getRightChild().getValue());
                        node.setLeftChild(node.getRightChild().getLeftChild());
                        node.setRightChild(node.getRightChild().getRightChild());
                    }
                }else{
                    aux=BST.this.getMax(node.getLeftChild(),node);
                    node.setValue(aux.getValue());
                }
                aux=null;
                return true;
            }
            else{
                if(compare(e,node.getValue())<0){
                    return delete(node.getLeftChild(),node,e);
                }else{
                    return delete(node.getRightChild(),node,e);
                }
            }
        }
    }
    public NodeTree getMax(NodeTree raiz,NodeTree fatherRoot){
        NodeTree aux=getBigger(fatherRoot.getLeftChild());
        this.delete((Object)aux.getValue());
        return aux;
    }
    
    public void balance(){
        i=0;
        int size=Traversal.treeSize(this.getRoot());
        vector =new Object[size];
        loadVector(this.getRoot());
        destroy();
        staticBalance(0,size-1);
    }
    private void loadVector(NodeTree middle){
        if(middle!=null){
            loadVector(middle.getLeftChild());
            vector[i++]=middle.getValue();
            loadVector(middle.getRightChild());
        }
    }
    public void destroy(){
        destroy(this.getRoot());
    }
    private void destroy(NodeTree root){
        if(root!=null){
            destroy(root.getLeftChild());
            destroy(root.getRightChild());
            this.delete(root.getValue());
        }
    }
    private void staticBalance(int start,int end){
        if(start<=end){
            int aftermiddle=(start+end)/2;
            insert((E)vector[aftermiddle]);
            staticBalance(start,aftermiddle-1);
            staticBalance(aftermiddle+1,end);
        }
    }
}