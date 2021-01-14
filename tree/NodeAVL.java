/**
 *
 *
 *@author Lucas-M(jiom-0)
 *
*/
package tree;
public class NodeAVL {
    private Object data;
    private NodeAVL father;
    private NodeAVL left;
    private NodeAVL right;
    
    public NodeAVL(){
        this.data=null;
        this.father=null;
        this.left=null;
        this.right=null;
    }
    public NodeAVL(Object datainput){
        this.data=datainput;
        this.father=null;
        this.left=null;
        this.right=null;
    }
}
