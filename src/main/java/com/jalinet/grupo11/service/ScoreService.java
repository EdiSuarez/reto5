
package com.jalinet.grupo11.service;//-



import com.jalinet.grupo11.dao.ScoreRepository;
import com.jalinet.grupo11.entities.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
   
    
  public List<Score> getAll() {return (List<Score>) scoreRepository.getAll();};
  
  public Optional<Score> getScore(int id) {return scoreRepository.getScore(id);};
  
  public Score save(Score score) {
        if (score.getId() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> co = scoreRepository.getScore(score.getId());
            if (co.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }

    }
    
    
}
