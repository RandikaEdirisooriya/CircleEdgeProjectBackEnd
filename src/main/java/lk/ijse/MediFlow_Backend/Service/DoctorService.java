package lk.ijse.MediFlow_Backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.DoctorDto;
import lk.ijse.MediFlow_Backend.Repo.CitizanRepo;
import lk.ijse.MediFlow_Backend.Repo.DoctorRepo;
import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.Doctor;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveDoctor(DoctorDto doctorDto){
        if(doctorRepo.existsById(doctorDto.getId())){
            return Varlist.RSP_DUPLICATED;
        }else {
            doctorRepo.save(modelMapper.map(doctorDto, Doctor.class));
            return Varlist.RSP_SUCCESS;
        }/*   */
    }
    public DoctorDto getDoctorByCode(String full_name,String verification_code){
        Doctor doctor=  doctorRepo.findDoctor(full_name,verification_code);
        return modelMapper.map(doctor,DoctorDto.class);
    }
}
