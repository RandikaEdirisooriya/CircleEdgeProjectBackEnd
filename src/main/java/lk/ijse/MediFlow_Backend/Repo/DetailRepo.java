package lk.ijse.MediFlow_Backend.Repo;

import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.MedicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepo extends JpaRepository<MedicalDetail,Integer> {
}
