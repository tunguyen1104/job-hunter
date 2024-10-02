package vn.tunguyen.jobhunter.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.tunguyen.jobhunter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
