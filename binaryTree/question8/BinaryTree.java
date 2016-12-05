/**
 * The type Binary tree.
 * this is to solve the question on algorithms and data structure parcticum book,
 * page 58, question 8
 *
 */
public class BinaryTree<T extends Comparable<T>> {


    public class TreeNode<T extends Comparable<T>> {
        protected T x, y;
        protected TreeNode<T> l1, l2, r1, r2;
        protected TreeNode<T> parentNode;

        public TreeNode(T x, T y, TreeNode<T> l1, TreeNode<T> l2, TreeNode<T> r1, TreeNode<T> r2, TreeNode<T> parentNode) {
            this.x = x;
            this.y = y;
            this.l1 = l1;
            this.l2 = l2;
            this.r1 = r1;
            this.r2 = r2;
            this.parentNode = parentNode;
        }

        public TreeNode(T x, T y) {
            this(x, y, null, null, null, null, null);
        }

        public int compareTo(TreeNode<T> o) {
            if (x.compareTo(o.x) < 0) {
                if (y.compareTo(o.y) < 0) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (y.compareTo(o.y) < 0) {
                    return 3;
                } else {
                    return 4;
                }
            }
        }

        @Override
        public String toString() {
            String s = "";
            if (parentNode == null) {
                s += "Root";
            } else {
                if (parentNode.l1 == this) {
                    s += "l1";
                }
                if (parentNode.l2 == this) {
                    s += "l2";
                }
                if (parentNode.r1 == this) {
                    s += "r1";
                }
                if (parentNode.r2 == this) {
                    s += "r2";
                }
            }
            s += "(x:" + x + ",y:" + y + ") ";
            return s;
        }
    }

    TreeNode<T> root;

    public BinaryTree() {
       root=null;
    }

    //in a recursive way, and also can use a not recursive way
    private TreeNode<T> findTreeNode(T xEl, T yEl, TreeNode<T> current) {
        if (current == null) {
            return null;
        } else if (xEl.compareTo(current.x) < 0) {
            if (yEl.compareTo(current.y) > 0) {
                return findTreeNode(xEl, yEl, current.l2);
            } else {
                return findTreeNode(xEl, yEl, current.l1);
            }
        } else {
            if (yEl.compareTo(current.y) > 0) {
                return findTreeNode(xEl, yEl, current.r2);
            } else {
                return findTreeNode(xEl, yEl, current.r1);
            }
        }
    }

    public TreeNode<T> findTreeNode(T xEl, T yEl) {
        return findTreeNode(xEl, yEl, root);
    }

    //used in insertNode, insert the node in a recursive way

    private void insertAtNode(T x, T y, TreeNode<T> current, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<T>(x, y);
        if (current == null) {

            // if the node is empty, but we have a parent
            if (parent != null) {
                if (newNode.compareTo(parent) == 1) {
                    parent.l1 = newNode;
                } else if (newNode.compareTo(parent) == 2) {
                    parent.l2 = newNode;
                } else if (newNode.compareTo(parent) == 3) {
                    parent.r1 = newNode;
                } else {
                    parent.r2 = newNode;
                }
            } else {
                root = newNode;
            }

            newNode.parentNode = parent;
        } else if (newNode.compareTo(current) == 1) {
            insertAtNode(x, y, current.l1, current);
        } else if (newNode.compareTo(current) == 2) {
            insertAtNode(x, y, current.l2, current);

        } else if (newNode.compareTo(current)==3){
            insertAtNode(x, y, current.r1, current);

        }else{
            insertAtNode(x, y, current.r2, current);

        }
    }

    public void insertNode(T x, T y) {
        insertAtNode(x,y,root,null);
    }

    // used in remove the node

    // print the node from middle-> left->right
    private void printMid(TreeNode<T> n) {
        if (n != null) {

            System.out.print(n);
            System.out.print(" ");
            printMid(n.l1);
            printMid(n.l2);
            printMid(n.r1);
            printMid(n.r2);

        }
    }

    public void printMid() {
        System.out.print("[");
        printMid(root);
        System.out.print("]");
        System.out.println();

    }





    //use traverse from left->middle->right



    private void printLayer(Stack<TreeNode<T>> n) {
        Stack t = new Stack();
        // where bug appears, lack of the statement if n.size()<=0, infinite recursive funtion.
        if (n.size() <= 0) {
            return;
        }
        while (n.size() > 0) {
            TreeNode<T> temp = n.pop();
            System.out.print(temp);
            System.out.print(" ");
            if (temp.l1 != null) {
                t.push(temp.l1);
            }
            if (temp.l2 != null) {
                t.push(temp.l2);
            }
            if (temp.r1 != null) {
                t.push(temp.r1);
            }
            if (temp.r2 != null) {
                t.push(temp.r2);
            }

        }
        printLayer(t);
    }

    /**
     * Print layer. print the tree layer by layer
     */
    public void printLayer() {
        System.out.print("[");
        Stack troot = new Stack();
        troot.push(root);
        printLayer(troot);
        System.out.print("]");
        System.out.println();
    }


}



