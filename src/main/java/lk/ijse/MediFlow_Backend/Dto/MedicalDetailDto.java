package lk.ijse.MediFlow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicalDetailDto {
    private  int id;
    private String PatientName;
    private String DoctorName;
    private String Disease;
    private String MedicineName;
    private String Dose;
    private String Note;
}
