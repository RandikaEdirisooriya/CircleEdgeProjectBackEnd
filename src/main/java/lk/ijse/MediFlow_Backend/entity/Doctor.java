package lk.ijse.MediFlow_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String NIC;
   @Column(name = "full_name" ,unique = true,nullable = false)
    private String FullName;
    private String DOB;
    private String Specialization;
    private String ContactNumber;
    private String LicenseNumber;
    private String EmailAddress;
    private String verificationCode;
    private String gender;

}
