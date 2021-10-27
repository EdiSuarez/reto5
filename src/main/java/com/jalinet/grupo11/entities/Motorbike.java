
/**
 *
 * plantilla compartida por docente-creditos al creador inicial del proyecto
 */

package com.jalinet.grupo11.entities;
/**
 *
 * Imports necesarios para ejecucion del codigo
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alex
 */

@Entity
@Table (name="motorbike")
public class Motorbike  implements Serializable { 
/**
 *
 * Creacion de variables y atributos de las tablas a crear
 */  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")  //categoryId   como se va a llamar esa lave foranea
    @JsonIgnoreProperties("motorbikes") //Campo que se debe ignorar cuando se realiza relaciones
    private Category category;//

    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "motorbike")//Este campo debe coincidir con el nombre con el que se almaceno
    @JsonIgnoreProperties({"motorbike", "client"})//@JsonIgnoreProperties("motorbikes")
    public List<MessageText> messages;

    @OneToMany(cascade = {javax.persistence.CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})//({"motorbike", "messages"})
    public List<Reservation> reservations;
    
 /**
 *
 * Creacion de Sett y Gett
 */  
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<MessageText> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageText> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
        
}



