/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.model;

import dongtv.dto.BookDTO;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author xhunt
 */
public class CartObj implements Serializable{
    private String customerName;
    private HashMap<String,BookDTO> cart;

    public CartObj() {
        this.customerName = "guest";
        this.cart = new HashMap<>();
    }
    
    public CartObj(String customerName)
    {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, BookDTO> getCart() {
        return cart;
    }
    
    public void addToCart(BookDTO dto) throws Exception
    {
        if(cart.containsKey(dto.getId()))
        {
            int quantity = cart.get(dto.getId()).getQuantity() +1;
            dto.setQuantity(quantity);
        }
        else
        {
            dto.setQuantity(1);
        }
        this.cart.put(dto.getId(), dto);
    }
    
    public void remove(String id) throws Exception
    {
        if(cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
    
    public void update(String id, String quantity)
    {
        try {
            int quan = Integer.parseInt(quantity);
            if(cart.containsKey(id))
            {
                cart.get(id).setQuantity(quan);
            }
        } catch (Exception e) {
        }
    }
    
    public float total()
    {
        float res =0;
        for ( BookDTO dto : cart.values()) {
            res += dto.getPrice()*dto.getQuantity();
        }
        return res;
    }
}
