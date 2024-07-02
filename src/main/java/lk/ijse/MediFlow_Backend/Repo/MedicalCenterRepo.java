package lk.ijse.MediFlow_Backend.Repo;

import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.MedicalCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedicalCenterRepo extends JpaRepository<MedicalCenter,Integer> {

    @Query(value = "SELECT * FROM medical_center WHERE name=?1 AND code =?2", nativeQuery = true)
    MedicalCenter findByNameAndCode(String name, String code);


}
