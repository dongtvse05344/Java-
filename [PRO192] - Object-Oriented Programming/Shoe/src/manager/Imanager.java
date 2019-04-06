/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author xhunt
 */
public interface Imanager<T> {
    public void add(T t);
    public T find(int Id);
    public T find(int Id, int l, int r);
    public void Sort();
    public void ShowList();
    public void remove(int Id);
    public void edit(T t);
}
