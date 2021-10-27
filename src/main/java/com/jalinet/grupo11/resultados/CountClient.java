
package com.jalinet.grupo11.resultados;

import com.jalinet.grupo11.entities.Client;


public class CountClient {
    
    private Long total;
    private Client client;
    

//    public CountClient(Client client, Integer total) {
//        this.client = client;
//        this.total = total;
//    }

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    
    
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

   
    

  
    
}
