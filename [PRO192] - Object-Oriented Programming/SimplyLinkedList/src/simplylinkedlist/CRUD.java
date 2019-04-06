/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplylinkedlist;

/**
 *
 * @author xhunt
 * @param <T>
 */
public interface CRUD<T> {
    
    
    public boolean isEmpty();
    
    public void add(T el);
    
    public void addFirst(T el);
    
    public void addLast(T el);
    
    public void addPos(T el, int pos);
    
    public void addMany(T [] a);
    
    public boolean contains(T el);
    
    public T get(int pos);
    
    public void printAll();
    
    public int indexOf(T el);
    
    public void remove(int pos);
    
    public void removeFirst();
    
    public void removeLast();
    
    public int getsize();
    
    
}
