
package com.jalinet.grupo11.service;

import com.jalinet.grupo11.dao.MotorbikeRepository;
import com.jalinet.grupo11.entities.Motorbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MotorbikeService {
    @Autowired
    MotorbikeRepository motorbikeRepository;
    
  public List<Motorbike> getAll() {return (List<Motorbike>) motorbikeRepository.getAll();};
  
  public Optional<Motorbike> getMotorbike(int id) {return motorbikeRepository.getMotorbike(id);};
  
  public Motorbike save(Motorbike motorbike) {
        if (motorbike.getId() == null) {
            return motorbikeRepository.save(motorbike);
        } else {
            Optional<Motorbike> co = motorbikeRepository.getMotorbike(motorbike.getId());
            if (co.isEmpty()) {
                return motorbikeRepository.save(motorbike);
            } else {
                return motorbike;
            }
        }

    }
  //=========================Update================
  public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> e=motorbikeRepository.getMotorbike(motorbike.getId());
            if(!e.isEmpty()){
                if(motorbike.getName()!=null){
                    e.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    e.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    e.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    e.get().setCategory(motorbike.getCategory());
                }
               motorbikeRepository.save(e.get());
                return e.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }
  
  //========================DElete============
  
  
   public boolean deleteMotorbike(int motorbikeId) {
        Boolean aBoolean = getMotorbike(motorbikeId).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
  
}
