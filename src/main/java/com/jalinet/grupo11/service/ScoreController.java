
package com.jalinet.grupo11.service;//-

import com.jalinet.grupo11.entities.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
      public List<Score> getScore() {return scoreService.getAll();};///---Plura

    @GetMapping("/{id}")                                            //int id
      public Optional<Score> getMotorbike(@PathVariable("id") int scoreId) {
          return scoreService.getScore(scoreId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public Score save(@RequestBody Score score) {return scoreService.save(score);};
    
    
}
