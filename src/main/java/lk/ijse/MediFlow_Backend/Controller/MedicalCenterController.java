package lk.ijse.MediFlow_Backend.Controller;


import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.MedicalCenterDto;
import lk.ijse.MediFlow_Backend.Dto.ResponseDto;

import lk.ijse.MediFlow_Backend.Service.MedicalCenterService;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/medicalcenter")
@CrossOrigin
public class MedicalCenterController {
    @Autowired
    private MedicalCenterService medicalCenterService;
    @Autowired
    private ResponseDto responseDto;

    @PostMapping("/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody MedicalCenterDto medicalCenterDto) {
        try {
            String res = medicalCenterService.saveMedicalCenter(medicalCenterDto);
            if (res.equals("00")) {
                responseDto.setCode(Varlist.RSP_SUCCESS);
                responseDto.setMessage("SUCCESS");
                responseDto.setContent(medicalCenterDto);
                return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);
            } else if (res.equals("06")) {
                responseDto.setCode(Varlist.RSP_DUPLICATED);
                responseDto.setMessage("DUPLICATED");
                responseDto.setContent(medicalCenterDto);
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
    @GetMapping("/getMCByCode/{name}/{code}")
    public MedicalCenterDto getMCByCode(@PathVariable String name, @PathVariable String code) {
        System.out.println(name + " ," + code);
        return medicalCenterService.getMCByCode(name, code);
    }
}