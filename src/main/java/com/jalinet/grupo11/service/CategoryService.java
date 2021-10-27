
package com.jalinet.grupo11.service;

import com.jalinet.grupo11.dao.CategoryRepository;
import com.jalinet.grupo11.entities.Category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
  public List<Category> getAll() {return (List<Category>) categoryRepository.getAll();};
  
  public Optional<Category> getCategory(int id) {return categoryRepository.getCategory(id);};
  
  public Category save(Category category) { 
       if (category.getId()== null){
           return categoryRepository.save(category);
       }
       else
       {
          Optional<Category> co =  categoryRepository.getCategory(category.getId());
          if (co.isEmpty()){
              return categoryRepository.save(category);
          }
          else
          {
              return category;
          }
       }
 
    }
  
  //=========================Update================
   public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
    }
  
  //========================DElete============
  
  
    public boolean deleteCategoria(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
  
}
