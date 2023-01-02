package repository;

import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Integer> {
    List<CustomerEntity> findByNameLike(String name);
    List<CustomerEntity> findByPhoneOrEmail(Integer phone, String email);

    @Query(value = "select * from customerentity where sex = 'male' and (year(curdate()) - year(birthdate)>= 20 and  " +
            "year(curdate()) - year(birthdate)<= 30)",nativeQuery = true)
    List<CustomerEntity> getListMaleAge();
}
