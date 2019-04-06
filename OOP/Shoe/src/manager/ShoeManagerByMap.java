/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import shoe.Shoe;

/**
 *
 * @author xhunt
 */
public class ShoeManagerByMap implements Imanager<Shoe>{

    Map<Integer,Shoe> map = new HashMap<Integer,Shoe>();
    @Override
    public void add(Shoe t) {
        map.put(t.Id, t);
    }

    @Override
    public Shoe find(int Id) {
        try
        {
            return map.get(Id);
        }
        catch(Exception e)
        {
            System.out.println(Id +" does not existed !");
        }
        return null;
    }

    @Override
    public Shoe find(int Id, int l, int r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Sort() {
    }

    @Override
    public void ShowList() {
        Set t = map.keySet();
        for(Object item : t)
        {
            
            map.get((int)item).PrintShoe();
        }
    }

    @Override
    public void remove(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Shoe t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
