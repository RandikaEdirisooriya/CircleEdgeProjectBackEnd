package lk.ijse.MediFlow_Backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.MediFlow_Backend.Dto.CitizanDto;
import lk.ijse.MediFlow_Backend.Dto.MedicalDetailDto;
import lk.ijse.MediFlow_Backend.Repo.CitizanRepo;
import lk.ijse.MediFlow_Backend.Repo.DetailRepo;
import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.MedicalDetail;
import lk.ijse.MediFlow_Backend.utill.Varlist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MedicalDetailService {
    @Autowired
    private DetailRepo detailRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String SaveDetail(MedicalDetailDto medicalDetailDto){
        if(detailRepo.existsById(medicalDetailDto.getId())){
            return Varlist.RSP_DUPLICATED;
        }else {
            detailRepo.save(modelMapper.map(medicalDetailDto, MedicalDetail.class));
            return Varlist.RSP_SUCCESS;
        }/*   */
    }
}
