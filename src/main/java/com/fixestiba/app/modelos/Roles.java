package com.fixestiba.app.modelos;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class Roles {

    @Id
    private Long id;
    private String nombre;
}
