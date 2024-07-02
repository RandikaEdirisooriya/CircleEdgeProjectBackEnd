package lk.ijse.MediFlow_Backend.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicalCenterDto {

    private  int id;
    private String code;

    private String Name;
    private String Owner;
    private String Contact;
    private String Address;
    private String Email;
    private String facility;
    private String capacity;
}
