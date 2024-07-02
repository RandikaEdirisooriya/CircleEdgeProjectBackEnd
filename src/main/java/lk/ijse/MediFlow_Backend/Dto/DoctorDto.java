package lk.ijse.MediFlow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoctorDto {
    private  int id;
    private String NIC;
    private String FullName;
    private String DOB;
    private String Specialization;
    private String ContactNumber;
    private String LicenseNumber;
    private String EmailAddress;
    private String verificationCode;
    private String gender;
}
