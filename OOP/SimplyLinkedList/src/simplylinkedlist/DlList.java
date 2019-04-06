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
public class DlList implements CRUD<Integer>{

    private int size;
    private DllNode head;
    private DllNode tail;
    @Override
    public boolean isEmpty() {
        return size!=0;
    }

    @Override
    public void add(Integer el) {
        addLast(el);
    }

    @Override
    public void addFirst(Integer el) {
        DllNode p = new DllNode(el);
        
        if(isEmpty())
        {
            head = p;
            tail = p;
            size++;
            return;
        }
        
        head.pre = p;
        p.next = head;
        head = p;
        size++;
    }

    @Override
    public void addLast(Integer el) {
        DllNode p = new DllNode(el);
        if(isEmpty())
        {
            head = p;
            tail = p;
            size++;
            return;
        }
        
        tail.next = p;
        p.pre = tail;
        tail = p;
        size++;
    }
    
    private DllNode getNode(int pos)
    {
        DllNode p = head;
        for(int i =0;i<pos;i++)
        {
            p = p.next;
        }
        return p;
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
        
        DllNode p = getNode(pos);
        DllNode val = new DllNode(el);
        
        p.pre.next = val;
        val.pre = p.pre;
        val.next = p;
        p.pre = val;
        size++;
    }

    @Override
    public void addMany(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            addLast(a[i]);
        }
    }

    @Override
    public boolean contains(Integer el) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer get(int pos) {
        DllNode p =  head;
        for (int i = 0; i < pos; i++) {
            p = p.next;
        }
        return p.info;
    }

    @Override
    public void printAll() {
        DllNode p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(p.info+ ", ");
            p = p.next;
        }
    }

    @Override
    public int indexOf(Integer el) {
        DllNode p = head;
        for (int i = 0; i < size; i++) {
            if(p.info == el)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int pos) {
        if(pos == size -1 )
        {
            removeLast();
            return;
        }
        if(pos == 0)
        {
            removeFirst();
            return;
        }
        if(pos <0 || pos >= size)
        {
            return;
        }
        DllNode p = getNode(pos-1);
        p.next = p.next.next;
        p.next.pre = p;
        size--;
        
    }

    @Override
    public void removeFirst() {
        head = head.next;
        head.pre = null;
        size--;
    }

    @Override
    public void removeLast() {
        tail = tail.pre;
        tail.next = null;
        size--;
    }

    @Override
    public int getsize() {
        return size;
    }
}
