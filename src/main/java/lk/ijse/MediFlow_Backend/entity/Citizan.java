package lk.ijse.MediFlow_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Citizan")
public class Citizan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String NIC;
    @Column(name = "first_name" ,unique = true,nullable = false)
    private String FirstName;
    private String LastName;
    private String ContactNumber;
    private String Address;
    private String EmailAddress;
    private String Password;

}
