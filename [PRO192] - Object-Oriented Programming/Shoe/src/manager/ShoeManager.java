/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
import java.util.*;
import shoe.Shoe;
import shoe.SneakerShoe;

/**
 *
 * @author xhunt
 */
public class ShoeManager implements Imanager<Shoe>{
    ArrayList<Shoe> List = new ArrayList<Shoe>();
    
    
    @Override
    public void add(Shoe t) {
        List.add(t);
    }

    
    @Override
    public Shoe find(int Id) {
        
        for(int i = 0; i < List.size();i++)
        {
            if(List.get(i).getId() == Id)
            {
                return List.get(i);
            }
        }
        return null;
    }
    

    @Override
    public void Sort() {
        //sort theo price
        Collections.sort(List,SneakerShoe.compareObj);
    }
    
    
    public void SortById()
    {
        Collections.sort(List,SneakerShoe.compareId);
    }
    
    @Override
    public Shoe find(int Id, int l, int r) {
        if(l > r) return null;
        int m = (l+r)/2;
        int Idt = List.get(m).Id;
        if(Idt == Id) return List.get(m);
        if(Idt < Id) return find(Id,m+1,r);
        return find(Id,l,m-1);
    }
    
    public Shoe findById(int Id){
        this.SortById();
        return this.find(Id, 1, List.size());
    }

    @Override
    public void ShowList() {
        for(int i = 0; i < List.size();i++)
        {
            List.get(i).PrintShoe();
        }
    }

    @Override
    public void remove(int Id) {
        List.remove(Id);
    }

    @Override
    public void edit(Shoe t) {
        for(int i = 0 ; i < List.size();i++)
        {
            if(List.get(i).getId() == t.getId())
            {
                List.set(i, t);
            }
        }
    }
    
}
