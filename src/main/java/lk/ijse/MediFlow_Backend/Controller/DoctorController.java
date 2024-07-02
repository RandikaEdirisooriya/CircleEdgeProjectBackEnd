package lk.ijse.MediFlow_Backend.Controller;

import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.DoctorDto;
import lk.ijse.MediFlow_Backend.Dto.MedicalCenterDto;
import lk.ijse.MediFlow_Backend.Dto.ResponseDto;
import lk.ijse.MediFlow_Backend.Service.DoctorService;
import lk.ijse.MediFlow_Backend.Service.MedicalCenterService;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/Doctor")
@CrossOrigin
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ResponseDto responseDto;

    @PostMapping("/saveDoctor")
    public ResponseEntity saveEmployee(@RequestBody DoctorDto doctorDto) {
        try {
            String res = doctorService.saveDoctor(doctorDto);
            if (res.equals("00")) {
                responseDto.setCode(Varlist.RSP_SUCCESS);
                responseDto.setMessage("SUCCESS");
                responseDto.setContent(doctorDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDto.setCode(Varlist.RSP_DUPLICATED);
                responseDto.setMessage("DUPLICATED");
                responseDto.setContent(doctorDto);
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
    @GetMapping("/getDoctorByCode/{full_name}/{verification_code}")
    public DoctorDto getDoctorByCode(@PathVariable String full_name, @PathVariable String verification_code) {
        System.out.println(full_name + " ," + verification_code);
        return doctorService.getDoctorByCode(full_name, verification_code);
    }
}
