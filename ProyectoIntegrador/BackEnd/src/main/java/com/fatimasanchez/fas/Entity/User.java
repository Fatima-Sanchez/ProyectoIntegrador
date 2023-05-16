package com.fatimasanchez.fas.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1, max=30, message="No cumple las condiciones")
    private String name;
    
    @NotNull
    @Size(min=1, max=30, message="No cumple las condiciones")
    private String surname;
    
    @Size(min=1, max=30, message="No cumple las condiciones")
    private String img;
}
