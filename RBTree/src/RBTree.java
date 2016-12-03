

/**
 * ClassName:RBTree
 * Version:1.0
 * Time : 11:15 03.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> mRoot;
    private static final boolean RED = false;
    private static final boolean BLACK = true;


    public class RBTNode<T extends Comparable<T>> {
        boolean color;
        T key;
        RBTNode<T> left;
        RBTNode<T> right;
        RBTNode<T> parent;

        public RBTNode(boolean color, T key, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public RBTNode(T key) {
            this(RED,key,null,null,null);
        }

        public T getKey() {
            return key;
        }

        public RBTNode<T> getParent() {
            return parent;
        }

        public boolean isColor() {
            return color;
        }

        public void setParent(RBTNode<T> parent) {
            this.parent = parent;
        }

        public void setLeft(RBTNode<T> left) {
            this.left = left;
        }

        public void setRight(RBTNode<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "" + key + (this.color == RED ? "(R)" : "B");
        }
    }

    public RBTree() {
        mRoot = null;
    }

    public void setmRoot(RBTNode<T> mRoot) {
        this.mRoot = mRoot;
    }

    private void preOrder(RBTNode<T> tree){
        if (tree!=null){
            System.out.print(tree.toString());
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    private void inOrder(RBTNode<T> tree){
        if (tree!=null){
            inOrder(tree.left);
            System.out.print(tree.toString());
            inOrder(tree.right);
        }
    }

    private void postOrder(RBTNode<T> tree){
        if (tree!=null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.toString());
        }
    }


    public void preOrder(){
        preOrder(mRoot);
    }


    public void inOrder(){
        inOrder(mRoot);
    }

    public void postOrder(){
        postOrder(mRoot);
    }

    private RBTNode<T> search(RBTNode<T> current, T key){
        if (current== null) {
            return null;
        }else if(key.compareTo(current.key)<0){
            return search(current.left,key);
        }else if (key.compareTo(current.key)>0){
            return search(current.right,key);
        }else {
            return current;
        }
    }

    public RBTNode<T> search(T key){
        return search(mRoot,key);
    }

    private RBTNode<T> iterativeSearch(RBTNode<T> x, T key){
        while (x!=null){
            if (key.compareTo(x.key)==0){
                break;
            }else if (key.compareTo(x.key)>0){
                x= x.right;
            }else{
                x= x.left;
            }
        }
        return x;

    }

    public RBTNode<T> iterativeSearch(T key){
        return iterativeSearch(mRoot,key);
    }
    private RBTNode<T> minimum(RBTNode<T> current){
        if (current.left!=null){
            minimum(current.left);
        }
        return current;
    }

    public RBTNode<T> minimum(){
        return minimum(mRoot);
    }

    private RBTNode<T> maximum(RBTNode<T> current){
        if (current.right!=null){
            maximum(current.right);
        }
        return current;
    }

    public RBTNode<T> maximum(){
        return maximum(mRoot);
    }

    private void leftRotate(RBTNode<T> current){
        if (current.right==null){
            System.out.println("Do not have right child, can not do left rotate!");
        }
        else{
            if (current == mRoot){
                setmRoot(current.right);
            }
            current.right.setParent(current.parent);
            current.setParent(current.right);
            current.setRight(current.parent.left);
            current.parent.setLeft(current);
        }
    }

    private void rightRotate(RBTNode<T> crt){
        if (crt.left==null){
            System.out.println("Do not have left child, can not do right rotate!");
        }
        else {
            if (crt == mRoot){
                setmRoot(crt.left);
            }

            crt.left.setParent(crt.parent);
            crt.setParent(crt.left);
            crt.setLeft(crt.parent.right);
            crt.parent.setRight(crt);
        }
    }

    private void insertFixup(RBTNode<T> crt){
        RBTNode<T> parent,gparent;
        parent = crt.parent;
        while ((parent!=null)&&(parent.isColor()==RED)){
            {
                gparent = parent.getParent();
                RBTNode<T> uncle;
                if (parent==gparent.left){
                    uncle = gparent.right;
                    if ((uncle!=null)&&uncle.color==RED){
                        // stop here

                    }else if ((uncle!=null)&&(uncle.color==BLACK)){
                        if (parent.right==crt){

                        }else if (parent.left==crt){

                        }
                    }

                }else{

                }
            }
        }
    }

   // insert to the root, use a recursive way
    private void insertAtNode(T key, RBTNode<T> crt, RBTNode<T> parent){
        if (crt==null){
            RBTNode<T> newNode = new RBTNode<T>(key);

            if (parent==null){
                setmRoot(newNode);
            }else {
                if (key.compareTo(parent.key)>0){
                    parent.setRight(newNode);
                }
                else if (key.compareTo(parent.key)<0){
                    parent.setLeft(newNode);
                }
                newNode.setParent(parent);
            }
        }else {
            if (key.compareTo(crt.key)>0){
                insertAtNode(key,crt.right,crt);
            }else if (key.compareTo(crt.key)<0){
                insertAtNode(key,crt.left,crt);
            }else{
                // if it is the same value with current, do nothing
            }
        }
    }

    // use a iterative way
    private void iterInsert(T key){
        RBTNode<T> newNode = new RBTNode<T>(key);
        int cmp;
        RBTNode<T> crt = mRoot;
        RBTNode<T> parent = null;

        // find the position to insert
        while (crt!= null){
            parent = crt;
            cmp=key.compareTo(crt.key);
            if (cmp>0){
                crt = crt.right;
            }else if (cmp<0){
                crt = crt.left;
            }else{
                break;
            }
        }
        // insert ,and now the insert position is
        // if it does not equals to null ,then the tree alreay contains the same key value tree node
        if (crt==null){
            newNode.setParent(parent);
            cmp = key.compareTo(parent.key);
            if (cmp<0){
                parent.setLeft(newNode);
            }else {
                parent.setRight(newNode);
            }
        }
        insertFixup(newNode);
    }
    public void insert(T key){
       // here we use a iterInsert()
        iterInsert(key);
    }


}
