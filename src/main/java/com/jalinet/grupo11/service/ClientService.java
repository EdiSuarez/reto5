
package com.jalinet.grupo11.service;

import com.jalinet.grupo11.dao.ClientRepository;
import com.jalinet.grupo11.entities.Client;
import com.jalinet.grupo11.resultados.CountClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alex
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
  
  public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
  
  public Client save(Client client) { 
       if (client.getIdClient()== null){
           return clientRepository.save(client);
       }
       else
       {
          Optional<Client> co =  clientRepository.getClient(client.getIdClient());
          if (co.isEmpty()){
              return clientRepository.save(client);
          }
          else
          {
              return client;
          }
       }
 
    }
  //================ACtualizar=========================0
  
   public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
//==========Modificacion para reto5===========
    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
//======================================================  
// public List<CountClient> getTopClients(){
//  
//      return clientRepository.getTopClients();
//  }
//  
  
    
}
