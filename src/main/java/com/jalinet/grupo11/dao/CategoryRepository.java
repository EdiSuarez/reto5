
package com.jalinet.grupo11.dao;

import com.jalinet.grupo11.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jalinet.grupo11.entities.CategoryCrudInterface;


@Repository
public class CategoryRepository {
  @Autowired
  private CategoryCrudInterface categoryCrudRepository;
  
  public List<Category> getAll() {return (List<Category>) categoryCrudRepository.findAll();};
  
  public Optional<Category> getCategory(int id) {return categoryCrudRepository.findById(id);};
  
  public Category save(Category category) { return categoryCrudRepository.save(category);};
  
   
    
    public void delete(Category Category){
       categoryCrudRepository.delete(Category);
    }
    
}
