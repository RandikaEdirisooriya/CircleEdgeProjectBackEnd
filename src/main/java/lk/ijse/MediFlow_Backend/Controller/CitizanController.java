package lk.ijse.MediFlow_Backend.Controller;

import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.ResponseDto;
import lk.ijse.MediFlow_Backend.Service.CitizanService;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping(value = "api/v1/citizan")
    @CrossOrigin
    public class CitizanController {
        @Autowired
        private CitizanService citizanService;
        @Autowired
        private ResponseDto responseDto;
        @PostMapping("/saveCitizan")
        public ResponseEntity saveCitizan(@RequestBody CitizanDto citizanDto) {
            try {
                String res=citizanService.SaveCitizan(citizanDto);
                if (res.equals("00")) {
                    responseDto.setCode(Varlist.RSP_SUCCESS);
                    responseDto.setMessage("SUCCESS");
                    responseDto.setContent(citizanDto);
                    return new ResponseEntity(responseDto, HttpStatus.ACCEPTED);


                } else if (res.equals("06")) {
                    responseDto.setCode(Varlist.RSP_DUPLICATED);
                    responseDto.setMessage("DUPLICATED");
                    responseDto.setContent(citizanDto);
                    return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);
                }else {

                    responseDto.setCode(Varlist.RSP_FAIL);
                    responseDto.setMessage("Fail");
                    responseDto.setContent(null);
                    return new ResponseEntity(responseDto, HttpStatus.BAD_REQUEST);


                }

            }catch (Exception ex){
                responseDto.setCode(Varlist.RSP_ERROR);
                responseDto.setMessage(ex.getMessage());
                responseDto.setContent(null);
                return new ResponseEntity(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }
        @GetMapping("/getCitizanByPassword/{first_name}/{password}")
        public CitizanDto getCitizanByPassword(@PathVariable String first_name,@PathVariable String password) {
            System.out.println(first_name + " ," + password);
            return citizanService.getCitizanByPassword(first_name, password);
        }
    }
