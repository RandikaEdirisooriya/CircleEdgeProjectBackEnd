package lk.ijse.MediFlow_Backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "MedicalDetail")
public class MedicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String PatientName;

    private String DoctorName;
    private String Disease;
    private String MedicineName;
    private String Dose;
    private String Note;

}
