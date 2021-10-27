
package com.jalinet.grupo11.dao;//-

import com.jalinet.grupo11.entities.Score;
import com.jalinet.grupo11.entities.ScoreCrudInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ScoreRepository {
    @Autowired
  private ScoreCrudInterface scoreCrudRepository;
  
  public List<Score> getAll() {return (List<Score>) scoreCrudRepository.findAll();};
  
  public Optional<Score> getScore(int id) {return scoreCrudRepository.findById(id);};//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio//para garantizar que no quede id vacio
  
  public Score save(Score sco) { return scoreCrudRepository.save(sco);};
    
    
}
