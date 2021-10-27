
package com.jalinet.grupo11.dao;

import com.jalinet.grupo11.entities.MessageText;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jalinet.grupo11.entities.MessageTextCrudInterface;


@Repository
public class MessageTextRepository {
    @Autowired
    private MessageTextCrudInterface messageTextCrudRepository;
  
  public List<MessageText> getAll() {return (List<MessageText>) messageTextCrudRepository.findAll();};
  
  public Optional<MessageText> getMessageText(int id) {return messageTextCrudRepository.findById(id);};
  
  public MessageText save(MessageText messageText) { return messageTextCrudRepository.save(messageText);};
  
  public void delete(MessageText message){
       messageTextCrudRepository.delete(message);
    }
    
    
    
}
