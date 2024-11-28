package com.fixestiba.app.modelos;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto es importante para que el id se genere automáticamente.
    private Long id;
    private String nombre;

    // Constructor sin el id, ya que se genera automáticamente
    public Roles(String nombre) {
        this.nombre = nombre;
    }


}
