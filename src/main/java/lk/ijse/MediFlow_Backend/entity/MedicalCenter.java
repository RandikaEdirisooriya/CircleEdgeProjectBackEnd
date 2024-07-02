package lk.ijse.MediFlow_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MedicalCenter")
public class MedicalCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String code;
    @Column(name = "name" ,unique = true,nullable = false)
    private String Name;
    private String Owner;
    private String Contact;
    private String Address;
    private String Email;
    private String facility;
    private String capacity;



}
