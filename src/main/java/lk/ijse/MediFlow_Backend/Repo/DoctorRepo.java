package lk.ijse.MediFlow_Backend.Repo;

import lk.ijse.MediFlow_Backend.entity.Citizan;
import lk.ijse.MediFlow_Backend.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    @Query(value = "SELECT * FROM doctor WHERE full_name=?1 AND verification_code =?2", nativeQuery = true)
    Doctor findDoctor(String full_name,String verification_code);

}
