
package com.jalinet.grupo11.dao;

import com.jalinet.grupo11.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jalinet.grupo11.entities.MotorbikeCrudInterface;


@Repository
public class MotorbikeRepository {
    
  @Autowired
  private MotorbikeCrudInterface motorbikeCrudRepository;
  
  public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeCrudRepository.findAll();};
  
  public Optional<Motorbike> getMotorbike(int id) {return motorbikeCrudRepository.findById(id);};//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio
  
  public Motorbike save(Motorbike mot) { return motorbikeCrudRepository.save(mot);};
  
   public void delete(Motorbike motorbike){ 
       motorbikeCrudRepository.delete(motorbike);
   }
  
}
