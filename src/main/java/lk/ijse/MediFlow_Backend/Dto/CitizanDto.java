package lk.ijse.MediFlow_Backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CitizanDto {
    private  int id;
    private String code;
    private String FirstName;
    private String LastName;
    private String ContactNumber;
    private String Address;
    private String EmailAddress;
    private String Password;
}
