package auth.repository;

import auth.model.User;
import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


        User findByUsername(String username);
        User getById(Long id);
    }
