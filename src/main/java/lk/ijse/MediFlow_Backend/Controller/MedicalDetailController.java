package lk.ijse.MediFlow_Backend.Controller;

import lk.ijse.MediFlow_Backend.Dto.DoctorDto;
import lk.ijse.MediFlow_Backend.Dto.MedicalDetailDto;
import lk.ijse.MediFlow_Backend.Dto.ResponseDto;
import lk.ijse.MediFlow_Backend.Service.DoctorService;
import lk.ijse.MediFlow_Backend.Service.MedicalDetailService;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/Detail")
@CrossOrigin
public class MedicalDetailController {
    @Autowired
    private MedicalDetailService medicalDetailService;
    @Autowired
    private ResponseDto responseDto;

    @PostMapping("/saveDetail")
    public ResponseEntity saveDetail(@RequestBody MedicalDetailDto medicalDetailDto) {
        try {
            String res = medicalDetailService.SaveDetail(medicalDetailDto);
            if (res.equals("00")) {
                responseDto.setCode(Varlist.RSP_SUCCESS);
                responseDto.setMessage("SUCCESS");
                responseDto.setContent(medicalDetailDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDto.setCode(Varlist.RSP_DUPLICATED);
                responseDto.setMessage("DUPLICATED");
                responseDto.setContent(medicalDetailDto);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
            } else {

                responseDto.setCode(Varlist.RSP_FAIL);
                responseDto.setMessage("Fail");
                responseDto.setContent(null);
                return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);


            }
        } catch (Exception ex) {
            responseDto.setCode(Varlist.RSP_ERROR);
            responseDto.setMessage(ex.getMessage());
            responseDto.setContent(null);
            return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
