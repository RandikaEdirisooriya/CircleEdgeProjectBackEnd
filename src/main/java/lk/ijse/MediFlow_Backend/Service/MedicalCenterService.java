package lk.ijse.MediFlow_Backend.Service;

import jakarta.transaction.Transactional;

import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.MedicalCenterDto;

import lk.ijse.MediFlow_Backend.Repo.MedicalCenterRepo;

import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.MedicalCenter;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MedicalCenterService {
    @Autowired
    private MedicalCenterRepo medicalCenterRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveMedicalCenter(MedicalCenterDto medicalCenterDto) {
        if (medicalCenterRepo.existsById(medicalCenterDto.getId())) {
            return Varlist.RSP_DUPLICATED;
        } else {
            medicalCenterRepo.save(modelMapper.map(medicalCenterDto, MedicalCenter.class));
            return Varlist.RSP_SUCCESS;
        }
    }
    public MedicalCenterDto getMCByCode(String name, String code){
        MedicalCenter medicalCenter=  medicalCenterRepo.findByNameAndCode(name,code);
        return modelMapper.map(medicalCenter,MedicalCenterDto.class);
    }
}
