/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dongtv.dto;

import java.io.Serializable;

/**
 *
 * @author xhunt
 */
public class ErrorObj implements Serializable{
    private String dateFlyError,customerNoError;

    public String getDateFlyError() {
        return dateFlyError;
    }

    public void setDateFlyError(String dateFlyError) {
        this.dateFlyError = dateFlyError;
    }

    public String getCustomerNoError() {
        return customerNoError;
    }

    public void setCustomerNoError(String customerNoError) {
        this.customerNoError = customerNoError;
    }
    
}
