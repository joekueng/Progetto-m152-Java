package ch.progetto152.repository;

import ch.progetto152.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByName(String name);

    Optional<UserEntity> findUserByUsername(String username);

}
