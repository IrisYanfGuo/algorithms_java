/**
 * ClassName:SplayTree
 * Version:1.0
 * Time : 15:35 05.Dec 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class SplayTree<K extends Comparable<K>, V> {

    public class SplayTNde {
        protected K key;
        protected V value;  // associated data
        protected SplayTNde left;
        protected SplayTNde right;
        protected SplayTNde parent;

        public SplayTNde(K key, V value, SplayTNde left, SplayTNde right, SplayTNde parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public SplayTNde(K key, V value) {
            this(key, value, null, null, null);
        }

        public SplayTNde(K key) {
            this(key, null, null, null, null);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setLeft(SplayTNde left) {
            this.left = left;
        }

        public void setRight(SplayTNde right) {
            this.right = right;
        }

        public void setParent(SplayTNde parent) {
            this.parent = parent;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public boolean isLeft() {
            if (parent.left == this) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isRight() {
            if (parent.right == this) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            String s = "";
            if (parent == null) {
                s += "(root:";
            } else {
                s += "(prt:" + parent.key + " ";
                if (parent.left == this) {
                    s += "left:";
                } else {
                    s += "right:";
                }
            }
            s += key + ") ";
            return s;
        }
    }

    SplayTNde root;

    public SplayTree() {
        root = null;
    }

    // only use when the element is the left or right children of the root
    private void zig(SplayTNde current) {
        if (current == root.left) {
            rightRotate(root);
        } else {
            leftRotate(root);
        }
    }


    private void transplant(SplayTNde oldNode, SplayTNde newNode) {
        if (oldNode == root) {
            root = newNode;
        } else if (oldNode.parent.left == oldNode) {
            oldNode.parent.setLeft(newNode);
        } else {
            oldNode.parent.setRight(newNode);
        }
        if (newNode != null) {
            newNode.parent = oldNode.parent;
        }
    }


    private void leftRotate(SplayTNde y) {
        if (y.right == null) {
            System.out.println("Wrong left rotate!");
        } else {
            SplayTNde x = y.right;
            y.right = x.left;
            if (x.left != null) {
                x.left.parent = y;
            }

            x.parent = y.parent;
            if (y.parent == null) {
                root = x;
            } else {
                if (y.parent.left == y) {
                    y.parent.setLeft(x);
                } else {
                    y.parent.setRight(x);
                }

            }
            y.parent = x;
            x.left = y;
        }

    }

    private void rightRotate(SplayTNde y) {
        // here made 1 bug, mess up with y.left!=null, stupid mistake!!
        if (y.left == null) {
            System.out.println("wrong right rotate!");
        } else {
            SplayTNde x = y.left;
            y.left = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }
            x.parent = y.parent;

            if (y.parent == null) {
                root = x;
            } else {
                if (y == y.parent.left) {
                    y.parent.left = x;
                } else {
                    y.parent.right = x;
                }

            }
            x.right = y;
            y.parent = x;

        }
    }

     /*

                   gp                     c
                   / \                   /  \
                  p   u        ---->    cl   p
                 / \                        / \
                c   pr                     cr gp
               / |                            /\
              cl  cr                         pr u
     */

    private void zigzig(SplayTNde current, SplayTNde parent, SplayTNde gparent) {
        if ((parent != null) && (gparent) != null) {
            if (gparent == root) {
                root = current;
            }
            if ((gparent.left == parent) && (parent.left == current)) {
                rightRotate(parent);
                rightRotate(gparent);
            } else {
                leftRotate(parent);
                leftRotate(gparent);
            }
        }
    }

     /*

         gp
       /    \
      p      u
     /  \
    pl   c
                                            c
                                          /   \
                                        p     gp
                                       / \    / \
                                     pl  cr cr  u
     */


    private void zigzag(SplayTNde current, SplayTNde parent, SplayTNde gparent) {
        if ((parent != null) && (gparent) != null) {
            if (gparent == root) {
                root = current;
            }
            if ((gparent.left == parent) && parent.right == current) {
                leftRotate(parent);
                rightRotate(gparent);
            } else {
                rightRotate(parent);
                leftRotate(gparent);
            }
        }
    }

// below are not a good way to finish impletion
/*
    private void splay(SplayTNde current) {
        SplayTNde parent = null;
        SplayTNde gparent = null;
        if (current.parent != null) {
            parent = current.parent;
            if (parent.parent != null) {
                gparent = parent.parent;
            }
        }

        if (parent == null) {
            return;
        } else if (gparent == null) {
            zig(current);
        } else {
          if ((gparent.left!=null)&&(parent==gparent.left)){
              if ((parent.left!=null)&&(current==parent.left)){
                  zigzig(current,parent,gparent);
              }
              else {
                  zigzag(current,parent,gparent);
              }

          }else{
              if ((gparent.right!=null)&&(gparent.right==parent)){
                  if ((parent.right!=null)&&(parent.right==current)){
                      zigzig(current,parent,gparent);
                  }else {
                      zigzag(current,parent,gparent);
                  }
              }
          }
        }
    }
*/


    // if it equals to current key, insert to the right
    // in the previous version ,we ignore the equal situation
    private void insert(K key, SplayTNde current, SplayTNde parent) {
        // here i made one bug , i ignore the root situation
        if (current == null) {
            SplayTNde a = new SplayTNde(key);
            if (parent != null) {

                if (key.compareTo(parent.key) < 0) {
                    parent.left = a;
                } else {
                    parent.right = a;
                }
                a.setParent(parent);

            } else {
                root = a;
            }
        } else {
            if (key.compareTo(current.key) < 0) {
                insert(key, current.left, current);
            } else {
                insert(key, current.right, current);
            }
        }
    }

    // the <k,v> tree version
    private void insert(K key, V value, SplayTNde current, SplayTNde parent) {
        if (current == null) {
            SplayTNde a = new SplayTNde(key, value);
            if (current == parent.left) {
                parent.left = a;
            } else {
                parent.right = a;
            }
            a.setParent(parent);

        } else {
            if (key.compareTo(current.key) < 0) {
                insert(key, value, current.left, current);
            } else {
                insert(key, value, current.right, current);
            }
        }
    }

    public void insert(K key) {
        insert(key, root, null);
        //splay(root, key);
    }

    public void insert(K key, V value) {
        insert(key, value, root, null);
        //splay(root, key);

    }


    private void preOrder(SplayTNde n) {
        if (n != null) {
            System.out.print(n);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void inOrder(SplayTNde n) {
        if (n != null) {
            preOrder(n.left);
            System.out.print(n);
            preOrder(n.right);
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void postOrder(SplayTNde n) {
        if (n != null) {
            preOrder(n.left);
            preOrder(n.right);
            System.out.print(n);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

  /*   fail attempt 3
    public SplayTNde splay(SplayTNde y, K key) {
        if (y == null) {
            return null;
        } else {
            SplayTNde tmp = y.parent;
            int cmp = key.compareTo(y.key);
            if (cmp == 0) return y;
            else if (cmp > 0) {
                // if y.right == null ,then now the key is the largest key
                if (y.right == null) {
                    return y;
                } else {
                    int cmp1 = key.compareTo(y.right.key);
                    if (cmp1==0) {
                        leftRotate(y);
                        return y.parent;
                    }else if (cmp1>0){
                        if (y.right.right==null){
                            leftRotate(y);
                            return y;
                        }else{

                        }
                    }else {

                    }
                }

            } else {
                if (y.left == null) {
                    return null;
                } else {
                    rightRotate(y);
                    return splay(y.parent, key);
                }
            }
        }
    }
*/

  //暂时先放弃，等完成其它数据结构，再来重新写这个函数

}
