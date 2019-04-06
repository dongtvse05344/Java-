/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplylinkedlist;

/**
 *
 * @author xhunt
 */
public class SllList implements CRUD<Integer> {

    protected SllNode head, tail;

    protected int size;

    public SllList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void addLast(Integer el) {
        SllNode p = new SllNode(el);

        if (!isEmpty()) {
            tail.next = p;
            tail = p;
        } else {
            head = tail = p;
        }
        size++;
    }

    @Override
    public void addPos(Integer el, int pos) {
        if (pos < 0 || pos >= size) {
            return;
        }
        if (pos == 0) {
            addFirst(el);
            return;
        }
        if (pos == size) {
            addLast(el);
            return;
        }
        SllNode p = new SllNode(el);
        SllNode l = head;
        SllNode r;
        for (int i = 0; i < pos - 1; i++) {
            l = l.next;
        }
        r = l.next;
        l.next = p;
        p.next = r;
        size++;
    }

    @Override
    public void add(Integer el) {
        addLast(el);
    }

    @Override
    public void addFirst(Integer el) {
        SllNode p = new SllNode(el);

        if (!isEmpty()) {
            p.next = head;
            head = p;
        } else {
            head = tail = p;
        }
        size++;
    }
    
    @Override
    public void addMany(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }

    @Override
    public void printAll() {
        SllNode p = head;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.next;
        }
        System.out.println("");
    }

    @Override
    public boolean contains(Integer el) {
        SllNode p = head;
        while (p != null) {
            if (p.info == el) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
    
    private SllNode getNode(int pos)
    {
        SllNode p = head;
        for (int i = 0; i < pos; i++) {
            p = p.next;
        }
        return p;
    }

    @Override
    public Integer get(int pos) {
        if (pos < 0 || pos >= size) {
            return null;
        }
        SllNode p = getNode(pos);
        return p.info;
    }

    @Override
    public int indexOf(Integer el) {
        SllNode p = head;
        for(int i =0;i<size;i++)
        {
            if(p.info == el )
            {
                return i;
            }
            p = p.next;
        }
        return -1;
    }

    @Override
    public void remove(int pos) {
        if(pos<0||pos>=size )
        {
            return;
        }
        if(pos == 0)
        {
            removeFirst();
            return;
        }
        if(pos == size-1)
        {
            removeLast();
            return;
        }
        
        SllNode lp = getNode(pos-1);
        SllNode p = lp.next;
        
        lp.next = p.next;
        size--;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        SllNode p = getNode(size-2);
        p.next = null;
        tail = p;
        size--;
    }

    @Override
    public int getsize() {
        return size;
    }

    

}
