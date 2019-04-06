/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package val;

import binaryserachtree.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author xhunt
 */
public class Tree {

    protected Node root = null;

    public Tree() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int el) {
        Node n = new Node(el);

        if (isEmpty()) {
            root = n;
            return;
        }
        Node t = root;
        Node pre = null;
        while (t != null) {
            pre = t;
            if (el > t.data) {
                t = t.r;
            } else {
                t = t.l;
            }
        }

        if (el > pre.data) {
            pre.r = n;
        } else {
            pre.l = n;
        }
    }

    public void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.l);
        System.out.print(n.data + " ");
        inorder(n.r);
    }

    public void postorder(Node n) {
        if (n == null) {
            return;
        }
        postorder(n.l);
        postorder(n.r);
        System.out.print(n.data + " ");
    }

    public void preorder(Node n) {
        if (n == null) {
            return;
        }
        System.out.print(n.data + " ");
        preorder(n.l);
        preorder(n.r);

    }

    public int countLeaf(Node p) {
        int count = 0;
        if (p == null) {
            return 0;
        }
        if (p.l == null && p.r == null) {
            return 1;
        }
        return countLeaf(p.l) + countLeaf(p.r);
    }

    public int count1Child(Node p) {
        if (p == null) {
            return 0;
        }
        int count = 0;
        if ((p.l == null && p.r != null) || (p.l != null && p.r == null)) {
            count++;
        }
        return count + count1Child(p.l) + count1Child(p.r);
    }

    public int count2Child(Node p) {
        if (p == null) {
            return 0;
        }
        int count = 0;
        if (p.l != null && p.r != null) {
            count++;
        }
        return count + count2Child(p.l) + count2Child(p.r);
    }

    public int calHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return Integer.max(1 + calHeight(p.l), 1 + calHeight(p.r));
    }

    public void BFS(Node p) {
        Node tmp = p;
        if (p == null) {
            return;
        }
        LinkedList<Node> l = new LinkedList();
        l.add(p);
        int count = 1;
        while (!l.isEmpty()) {
            System.out.print(count + " : ");
            int s = l.size();
            for (int i = 0; i < s; i++) {
                tmp = l.getFirst();
                System.out.print(tmp.data + " ");
                if (tmp.l != null) {
                    l.add(tmp.l);
                }
                if (tmp.r != null) {
                    l.add(tmp.r);
                }
                l.removeFirst();
            }
            count++;
            System.out.println("");
        }
    }

    public Node getNode(int el) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.data == el) {
                return tmp;
            }
            if (tmp.data < el) {
                tmp = tmp.r;
            } else {
                tmp = tmp.l;
            }
        }
        return null;
    }
    
    public Node getParent(Node n) {
        Node res = null;
        Node tmp = root;
        while (tmp != null) {
            if (tmp.data == n.data) {
                return res;
            }
            res = tmp;
            if (tmp.data < n.data) {
                
                tmp = tmp.r;
            } else {
                tmp = tmp.l;
            }
        }
        return res;
    }
    
    

    public Node leftNodeMost(Node n) {
        Node res = n;
        Node temp = n.r;
        while (temp != null) {
            res = temp;
            temp = temp.l;
        }
        return res;
    }

    public Node rightNodeMost(Node n) {
        Node res = n;
        Node temp = n.l;
        while (temp != null) {
            res = temp;
            temp = temp.r;
        }
        return res;
    }
    
    public int DistanceFromNode(Node n)
    {
        int res = 0;
        Node tmp = root;
        while (tmp != null) {
            
            if (tmp.data== n.data) {
                break;
            }
            res++;
            if (tmp.data < n.data) {
                tmp = tmp.r;
            } else {
                tmp = tmp.l;
            }
        }
        return res;
    }
    
    public int Distance(Node n1, Node n2)
    {
        int res = 0;
        Node tmp = root;
        while(true)
        {
            if(tmp.data > n1.data && tmp.data > n2.data)
            {
                tmp = tmp.l;
            }
            
            if(tmp.data < n1.data && tmp.data < n2.data)
            {
                tmp = tmp.r;
            }
            break;
        }
        res = DistanceFromNode(n1) +DistanceFromNode(n2) - 2*DistanceFromNode(tmp);
        return res;
    }
    
    public void deleteNodebyMerge(Node n)
    {
        Node left = n.l;
        Node right = n.r;
        Node most = rightNodeMost(n);
        Node parent = getParent(n);
        
        if(left ==  null || right == null)
        {
            if(left ==  null && right == null)
            {
                if(parent.l.data == n.data) {parent.l = null;}
                else                        {parent.r = null;}
            }
            if(left == null)
            {
                if(parent.l.data == n.data) {parent.l = right;}
                else                        {parent.r = right;}
            }
            else
            {
                if(parent.l.data == n.data) {parent.l = left;}
                else                        {parent.r = left;}
            }
            return ;
        }
        
        most.r = right;
        if(parent == null)
        {
            root = left;
            return;
        }
        
        if(parent.l.data == n.data)
        {
            parent.l = left;
        }
        else
        {
            parent.r = left;
        }
    }
    
    public void deleteNodebyCopy(Node n)
    {
        Node left = n.l;
        Node right = n.r;
        Node most = rightNodeMost(n);
        Node parent = getParent(n);
        
        if(left ==  null || right == null)
        {
            if(left ==  null && right == null)
            {
                if(parent.l.data == n.data) {parent.l = null;}
                else                        {parent.r = null;}
            }
            if(left == null)
            {
                if(parent.l.data == n.data) {parent.l = right;}
                else                        {parent.r = right;}
            }
            else
            {
                if(parent.l.data == n.data) {parent.l = left;}
                else                        {parent.r = left;}
            }
            return ;
        }
        
        Node parentLM = getParent(most);
        
        parentLM.r = most.l;
        n.data = most.data;
     
    }
}
