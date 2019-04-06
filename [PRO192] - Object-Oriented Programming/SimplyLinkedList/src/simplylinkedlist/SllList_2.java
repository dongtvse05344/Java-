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
public class SllList_2 <T> implements CRUD<T>{

    protected SllNode<T> head, tail;

    protected int size;

    public SllList_2() {
        head = tail = null;
        size = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void add(T el) {
        addLast(el);
    }

    @Override
    public void addFirst(T el) {
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
    public void addLast(T el) {
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
    public void addPos(T el, int pos) {
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
    public void addMany(T[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }

    @Override
    public boolean contains(T el) {
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
    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            return null;
        }
        SllNode p = getNode(pos);
        return (T) p.info;
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
    public int indexOf(T el) {
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
