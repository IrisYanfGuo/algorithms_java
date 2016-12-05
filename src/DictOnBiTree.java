/**
 * ClassName:DictOnBiTree
 * Version:1.0
 * Time : 11:26 29.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class DictOnBiTree {

    private BinaryTree data;
    public DictOnBiTree() {
        data = new BinaryTree();
    }
    public void add(Object key,Object value){
        DictPair a = new DictPair(key,value);
        data.insertNode((Comparable) a);
    }
   // public Comparable find(Object key){}


    @Override
    public String toString() {
        return data.toString();
    }

    public void print(){
        System.out.println(toString());
    }



    // If do not use generics ,how to solve that??
   // private Object find(Object key,BinaryTree.TreeNode current){


    public Object find(Object key){
        DictPair a = new DictPair(key,null);
        return ((DictPair)data.findTreeNode(a).getValue()).getValue();
    }



}
