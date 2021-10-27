
package com.jalinet.grupo11.service;


import com.jalinet.grupo11.entities.MessageText;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Message")//Cambiar messageText
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageTextController {
    
    @Autowired
    private MessageTextService messageTextService;
    
    @GetMapping("/all")
      public List<MessageText> getMessageText() {return messageTextService.getAll();};

    @GetMapping("/{id}")
      public Optional<MessageText> getMessageText(@PathVariable("id") int categoryId) {
          return messageTextService.getMessageText(categoryId);
      }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
      public MessageText save(@RequestBody MessageText messageText) {return messageTextService.save(messageText);};
    
      
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageText update(@RequestBody MessageText message) {
        return messageTextService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageTextService.deleteMessage(messageId);
    }
    
}
