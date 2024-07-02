package lk.ijse.MediFlow_Backend.Repo;


import lk.ijse.MediFlow_Backend.entity.Citizan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitizanRepo extends JpaRepository<Citizan,Integer> {



    @Query(value = "SELECT * FROM citizan WHERE first_name=?1 AND password =?2", nativeQuery = true)
    Citizan findByFirstNameAndPassword(String first_name,String password);


}
