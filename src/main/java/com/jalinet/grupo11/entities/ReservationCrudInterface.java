
package com.jalinet.grupo11.entities;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudInterface extends CrudRepository<Reservation, Integer>{
    
    //JPQL
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countReservationByClient();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    public List<Reservation> findAllByStatus(String status);//Esto corresponde al atributo creado de STATUS en reservation 
}
