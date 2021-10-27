
package com.jalinet.grupo11.dao;


import com.jalinet.grupo11.entities.Client;
import com.jalinet.grupo11.entities.Reservation;
import com.jalinet.grupo11.entities.ReservationCrudInterface;
import com.jalinet.grupo11.resultados.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
  private ReservationCrudInterface reservationCrudRepository;
  
  public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
  
  public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
  
  public Reservation save(Reservation reservation) { return reservationCrudRepository.save(reservation);};
    
  public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);      
        }
  
  public List<Reservation> getReservationsByDescription(String status){
      return reservationCrudRepository.findAllByStatus(status);
  }
  
  public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
      return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
  }
  //=========================REto5==================================
  public List<CountClient> getTopClients(){
      List<CountClient> res= new ArrayList<>();
      List<Object[]> report = reservationCrudRepository.countReservationByClient();//countTotalReservationByClient();
      
      for(int i =0;i<report.size();i++){
//          Client cli =(Client) report.get(i)[0];
//          Integer cantidad = (Integer) report.get(i)[1];
//          CountClient cc = new CountClient(cantidad,cli);
//          res.add(cc);
       res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0]));//se cambio Long a  Integer 
      }
      
      
      return res;
  }
  
  
}


