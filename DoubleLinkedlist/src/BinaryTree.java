/**
 * The type Binary tree.
 * the latest version: Dec 5,2016
 * <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 *
 * @param <K,V>the type parameter
 */
public class BinaryTree<K extends Comparable<K>, V> {


    /**
     * The type Tree node.
     *
     * @param <K,V> the type parameter
     */
    public class TreeNode<K extends Comparable<K>, V> {
        /**
         * The Value.
         */
        protected K key;
        protected V value;  // associated data
        protected TreeNode<K, V> leftNode;
        protected TreeNode<K, V> rightNode;
        protected TreeNode<K, V> parentNode;


        /**
         * Instantiates a new Tree node.
         *
         * @param key        the key
         * @param leftNode   the left node
         * @param rightNode  the right node
         * @param parentNode the parent node
         */
        public TreeNode(K key, V value, TreeNode<K, V> leftNode, TreeNode<K, V> rightNode, TreeNode<K, V> parentNode) {
            this.key = key;
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.parentNode = parentNode;
        }


        public void setValue(K key, V value) {
            this.value = value;
            this.key = key;
        }

        /**
         * Instantiates a new Tree node.
         *
         * @param key the key
         */
        public TreeNode(K key, V value) {
            this(key, value, null, null, null);
        }

        public TreeNode(K key, TreeNode<K, V> leftNode, TreeNode<K, V> rightNode, TreeNode<K, V> parentNode) {
            this.key = key;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.parentNode = parentNode;
        }

        // if it is a tree without value
        public TreeNode(K key) {
            this(key,null,null,null);
        }

        public TreeNode<K, V> getLeftTree() {
            return leftNode;
        }


        public TreeNode<K, V> getRightTree() {
            return rightNode;
        }


        public TreeNode<K, V> getParentNode() {
            return parentNode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


        public void setLeftTree(TreeNode<K, V> leftNode) {
            this.leftNode = leftNode;
        }


        public void setRightTree(TreeNode<K, V> rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            String s = "";
            if (parentNode == null) {
                s += "root:";
            } else {
                s += "(prt:" + parentNode.key + " ";
                if (parentNode.leftNode == this) {
                    s += "left:";
                } else {
                    s += "right:";
                }
            }
            s += key + ") ";
            return s;
        }

        /**
         * the compare to method
         *
         * @param o ,it is the treeNode
         * @return if key
         * is smaller than
         */
        public int compareTo(TreeNode<K, V> o) {
            if (key.compareTo(o.key
            ) > 0) {
                return 1;
            } else if (key.compareTo(o.key
            ) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * The Root.
     */
    TreeNode<K, V> root;

    /**
     * Instantiates a new Binary tree.
     */
    public BinaryTree() {
        root = null;
    }


    //in a recursive way, and also can use a not recursive way
    private TreeNode<K, V> findTreeNode(K key1, TreeNode<K, V> current) {
        if (current == null) {
            return null;
        } else if (key1.compareTo(current.key) < 0) {
            return findTreeNode(key1, current.getLeftTree());
        } else if (key1.compareTo(current.key) == 0) {
            return current;
        } else {
            return findTreeNode(key1, current.getRightTree());
        }
    }


    public TreeNode<K, V> findTreeNode(K key1) {
        return findTreeNode(key1, root);
    }

    //used in insertNode, insert the node in a recursive way
    private void insertAtNode(K key1, V value, TreeNode<K, V> current, TreeNode<K, V> parent) {
        if (current == null) {
            TreeNode<K, V> newNode = new TreeNode<K, V>(key1, value);
            // if the node is empty, but we have a parent
            if (parent != null) {
                if (parent.compareTo(newNode) > 0) {
                    parent.setLeftTree(newNode);
                } else {
                    parent.setRightTree(newNode);
                }
            } else {
                root = newNode;
            }

            newNode.parentNode = parent;
        } else if (key1.compareTo(current.key) == 0) {

        } else if (key1.compareTo(current.key) > 0) {
            insertAtNode(key1, value, current.getRightTree(), current);
        } else {
            insertAtNode(key1, value, current.getLeftTree(), current);
        }
    }


    private void insertAtNode(K key1, TreeNode<K, V> current, TreeNode<K, V> parent) {
        if (current == null) {
            TreeNode<K, V> newNode = new TreeNode<K, V>(key1);
            // if the node is empty, but we have a parent
            if (parent != null) {
                if (parent.compareTo(newNode) > 0) {
                    parent.setLeftTree(newNode);
                } else {
                    parent.setRightTree(newNode);
                }
            } else {
                root = newNode;
            }

            newNode.parentNode = parent;
        } else if (key1.compareTo(current.key) == 0) {

        } else if (key1.compareTo(current.key) > 0) {
            insertAtNode(key1,  current.getRightTree(), current);
        } else {
            insertAtNode(key1,  current.getLeftTree(), current);
        }
    }
    /**
     * Insert node.
     *
     * @param
     */
    public void insertNode(K key, V value) {
        insertAtNode(key, value, root, null);
    }

    // only insert key ,without other data or value
    public void insertNode(K key){
        insertAtNode(key,root,null);
    }
    // used in remove the node
    private TreeNode<K, V> minNode(TreeNode<K, V> current) {
        if (current == null) {
            return null;
        } else if (current.getLeftTree() == null) {
            return current;
        } else {
            return minNode(current.getLeftTree());
        }
    }

    /**
     * find the max key1
     * in the subtree
     *
     * @param current the current
     * @return the tree node
     */
// used in remove the node
    public TreeNode<K, V> maxNode(TreeNode<K, V> current) {
        if (current == null) {
            return null;
        } else if (current.getRightTree() == null) {
            return current;

        } else {
            return maxNode(current.getRightTree());
        }


    }

    // print the node from middle-> left->right
    private void preOrder(TreeNode<K, V> n) {
        if (n != null) {

            System.out.print(n);
            System.out.print(" ");
            preOrder(n.getLeftTree());
            preOrder(n.getRightTree());

        }
    }

    /**
     * Pre order.
     */
    public void preOrder() {
        System.out.print("[");
        preOrder(root);
        System.out.print("]");
        System.out.println();

    }

    private void inOrder(TreeNode<K, V> n) {
        if (n != null) {
            inOrder(n.getLeftTree());
            System.out.print(n);
            System.out.print(" ");
            inOrder(n.getRightTree());

        }
    }

    /**
     * In order.
     */
    public void inOrder() {
        System.out.print("[");
        inOrder(root);
        System.out.print("]");

        System.out.println();
    }

    private void postOrder(TreeNode<K, V> current) {
        if (current != null) {
            postOrder(current.leftNode);
            postOrder(current.rightNode);
            System.out.print(current);
        }
    }

    /**
     * Post order.
     */
    public void postOrder() {
        System.out.print("[");
        postOrder(root);
        System.out.print("]");

        System.out.println();
    }


    /**
     * use the stack to print
     */
    public void recPrint() {
        System.out.print("[");

        Stack t = new Stack();
        t.push(root);
        while (t.size() > 0) {
            TreeNode<K, V> n = (TreeNode<K, V>) t.pop();
            System.out.print(n);

            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }

        }
        System.out.print("]");

        System.out.println();
    }


    private void printLayer(Stack<TreeNode<K, V>> n) {
        Stack t = new Stack();
        // where bug appears, lack of the statement if n.size()<=0, infinite recursive funtion.
        if (n.size() <= 0) {
            return;
        }
        while (n.size() > 0) {
            TreeNode<K, V> temp = n.pop();
            System.out.print(temp);
            System.out.print(" ");
            if (temp.getLeftTree() != null) {
                t.push(temp.getLeftTree());
            }
            if (temp.getRightTree() != null) {
                t.push(temp.getRightTree());
            }
        }
        printLayer(t);
    }

    /**
     * use the queue to print ,print layer by layer
     */
    public void printLayer() {
        System.out.print("[");
        Stack troot = new Stack();
        troot.push(root);
        printLayer(troot);
        System.out.print("]");
        System.out.println();
    }


    /**
     * Remove.
     *
     * @param key1 the key1
     */
    public void remove(Comparable key1) {
        myRemoveNode1(key1, root);

    }


    //use traverse from left->middle->right
    private String toString(TreeNode<K, V> current) {
        String s = "";
        if (current != null) {
            s = s + toString(current.leftNode);
            s = s + current + " ";
            s = s + toString(current.rightNode);
        }
        return s;
    }

    // First,you need to get full understanding of transplant.
    // the same as in PPT, divided the situation into three kind
    private void removeNode(Comparable key1, TreeNode<K, V> current) {
        if (current == null) return;
        else if (key1.compareTo(current.key) == 0) {
            if (current.leftNode == null) {
                transplant(current, current.rightNode);
            } else if (current.rightNode == null) {
                transplant(current, current.rightNode);
            } else {
                TreeNode<K, V> y = minNode(current.rightNode);

                if (y.parentNode != current) {
                    transplant(y, y.rightNode);
                    y.rightNode = current.rightNode;
                    y.rightNode.parentNode = y;
                }
                transplant(current, y);
                y.leftNode = current.leftNode;
                y.leftNode.parentNode = y;
            }
        } else if (key1.compareTo(current.key) > 0) {
            removeNode(key1, current.getRightTree());
        } else {
            removeNode(key1, current.getLeftTree());
        }
    }

    // transplant two trees
    private void transplant(TreeNode<K, V> oldNode, TreeNode<K, V> newNode) {
        if (oldNode == root) {
            root = newNode;
        } else if (oldNode.parentNode.getLeftTree() == oldNode) {
            oldNode.parentNode.setLeftTree(newNode);
        } else {
            oldNode.parentNode.setRightTree(newNode);
        }
        if (newNode != null) {
            newNode.parentNode = oldNode.parentNode;
        }
    }

    // use the smallest key1
    //in the right tree to substitute
    private void myRemoveNode(Comparable key1, TreeNode<K, V> current) {
        if (current == null) return;
        if (key1.compareTo(current.key) == 0) {
            if (current.rightNode == null) {
                transplant(current, current.leftNode);
            } else {
                TreeNode<K, V> y = minNode(current.rightNode);

                transplant(y, y.rightNode);
                y.rightNode = current.rightNode;
                if (y.rightNode != null) {
                    //must consider the situation of if the rightNode is null，
                    y.rightNode.parentNode = y;
                }

                transplant(current, y);
                y.leftNode = current.leftNode;
                if (y.leftNode != null) {
                    y.leftNode.parentNode = y;
                }
            }
        } else if (key1.compareTo(current.key) > 0) {
            myRemoveNode(key1, current.getRightTree());
        } else {
            myRemoveNode(key1, current.getLeftTree());
        }
    }

    // use the largest key1
    //in the leftTree to substitute.
    private void myRemoveNode1(Comparable key1, TreeNode<K, V> current) {
        if (current == null) return;//when  found the key1
        if (key1.compareTo(current.key) == 0) {
            if (current.getLeftTree() != null) {
                TreeNode<K, V> t = maxNode(current.getLeftTree());


                transplant(t, t.leftNode);
                // bug appears here t.parentNode.rightnode = t.leftNode
                // since we have use the function transplant,if we write it again,it repeat the same thing and will cause bug
                if (t.leftNode != null) {
                    t.leftNode.parentNode = t.parentNode;
                }
                t.rightNode = current.rightNode;
                t.leftNode = current.leftNode;

                if (current.rightNode != null) {
                    current.rightNode.parentNode = t;
                }
                transplant(current, t);
            } else {
                transplant(current, current.getRightTree());
            }
        } else if (key1.compareTo(current.key) < 0) {
            myRemoveNode1(key1, current.getLeftTree());
        } else {
            myRemoveNode1(key1, current.getRightTree());
        }
    }


    @Override
    //from left->middle->right
    public String toString() {
        return toString(root);
    }

    /**
     * Traverse. traverse all the key1
     * <p>
     * and there is a Action Run abstract class,you can write code in it
     *
     * @param action the action
     */
    public void traverse(TreeAction action) {
        Queue<TreeNode<K, V>> t = new Queue();
        t.push(root);
        while (!t.empty()) {
            TreeNode<K, V> n = t.pop();
            action.run(n);
            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }
        }
    }


    private Double averOnTraverse(TreeActionDouble action) {
        double sum = 0;
        double count = 0.0;
        Queue<TreeNode> t = new Queue<>();
        t.push(root);
        while (!t.empty()) {
            TreeNode n = t.pop();
            sum = sum + (int) action.run(n);
            count++;
            if (n.getLeftTree() != null) {
                t.push(n.getLeftTree());
            }
            if (n.getRightTree() != null) {
                t.push(n.getRightTree());
            }

        }
        return sum / count;
    }

    public Double average() {
        return averOnTraverse(new TreeActionDouble() {
            @Override
            public Comparable run(TreeNode treeNode) {
                return treeNode.getKey();
            }
        });
    }


    private int depth(TreeNode t) {
        if (t == null) {
            return 0;
        } else {
            if (depth(t.getLeftTree()) > depth(t.getRightTree()))
                return depth(t.getLeftTree()) + 1;
            else
                return depth(t.getRightTree()) + 1;
        }
    }

    public int depth() {
        return depth(root);

    }

    private Comparable getBig(TreeNode t) {
        if (t.getRightTree() != null) {
            return getBig(t.getRightTree());
        } else {
            return t.getKey();
        }
    }

    public Comparable getBig() {
        return getBig(root);
    }

    private Comparable getSmall(TreeNode t) {
        if (t.getLeftTree() != null) {
            return getSmall(t.getLeftTree());
        } else {
            return t.getKey();
        }
    }

    public Comparable getSmall() {
        return getSmall(root);
    }

    private void swapTree(TreeNode t) {
        if (t != null) {
            TreeNode t2 = t.getLeftTree();
            if (t.getRightTree() != null) {
                t.setLeftTree(t.getRightTree());

            }
            if (t2 != null) {
                t.setRightTree(t2);

            }
            swapTree(t.getLeftTree());
            swapTree(t.getRightTree());
        } else {
            return;
        }
    }

    public void swapTree() {
        swapTree(root);
    }


}
