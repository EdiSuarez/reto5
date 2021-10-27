
package com.jalinet.grupo11.service;

import com.jalinet.grupo11.dao.MessageTextRepository;
import com.jalinet.grupo11.entities.MessageText;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageTextService {
    @Autowired
    MessageTextRepository messageTextRepository ;
    
     public List<MessageText> getAll() {return (List<MessageText>) messageTextRepository.getAll();};
  
  public Optional<MessageText> getMessageText(int id) {return messageTextRepository.getMessageText(id);};
  
  public MessageText save(MessageText messageText) { 
       if (messageText.getIdMessage()== null){
           return messageTextRepository.save(messageText);
       }
       else
       {
          Optional<MessageText> co =  messageTextRepository.getMessageText(messageText.getIdMessage());
          if (co.isEmpty()){
              return messageTextRepository.save(messageText);
          }
          else
          {
              return messageText;
          }
       }
 
    }
  //=================Update==================
   public MessageText update(MessageText message){
        if(message.getIdMessage()!=null){
            Optional<MessageText> e= messageTextRepository.getMessageText(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageTextRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
//==================Delete============================
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessageText(messageId).map(message -> {
            messageTextRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
    
    
}
