/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhunt
 */
public class Page<T> implements Serializable{
    private int left,right,index,noRecord = 3,noPage =5,noPageMax;
    private List<T> list;

    
    
    
    public Page(List<T> list)
    {
        noPageMax = (int) Math.ceil(1.0*list.size()/noRecord) ;
        this.list= new ArrayList<>();
        left = 1;
        right = Math.min(noPageMax,left + noPage-1);
        index = 1;
        if(index < left || index>right ) return;
        for (int i = (index-1)*noRecord; i< Math.min(index*noRecord, list.size()); i++) {
            this.list.add(list.get(i));
        }
    }
    
    public Page(List<T> list,int index)
    {
        noPageMax = (int) Math.ceil(1.0*list.size()/noRecord) ;
        this.list= new ArrayList<>();
        this.index = index;
        left = Math.max(1,index-2);
        right = Math.min(noPageMax,left + noPage-1);
        
        if(index < left || index>right ) return;
        for (int i = (index-1)*noRecord; i< Math.min(index*noRecord, list.size()) ; i++) {
            this.list.add(list.get(i));
        }
    }
    
    /**
     * 
     * @param list list of Object
     * @param index index of page
     * @param record number of record in page
     */
    public Page(List<T> list,int index, int record)
    {
        noRecord = record;
        noPageMax = (int) Math.ceil(1.0*list.size()/noRecord) ;
        this.list= new ArrayList<>();
        this.index = index;
        left = Math.max(1,index-2);
        right = Math.min(noPageMax,left + noPage-1);
        
        if(index < left || index>right ) return;
        for (int i = (index-1)*noRecord; i< Math.min(index*noRecord, list.size()) ; i++) {
            this.list.add(list.get(i));
        }
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getIndex() {
        return index;
    }

    public List<T> getList() {
        return list;
    }
    
}
