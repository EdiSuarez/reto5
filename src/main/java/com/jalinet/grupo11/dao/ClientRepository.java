
package com.jalinet.grupo11.dao;

import com.jalinet.grupo11.entities.Client;
import com.jalinet.grupo11.entities.ClientCrudInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {
     @Autowired
  private ClientCrudInterface clientCrudRepository;
  
  public List<Client> getAll() {return (List<Client>) clientCrudRepository.findAll();};
  
  public Optional<Client> getClient(int id) {return clientCrudRepository.findById(id);};//para garantizar que no quede id vacio//para garantizar que no quede id vacio
  
  public Client save(Client cli) { return clientCrudRepository.save(cli);};
  
  public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
}
