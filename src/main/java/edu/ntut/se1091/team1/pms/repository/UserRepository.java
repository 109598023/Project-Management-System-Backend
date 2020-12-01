package edu.ntut.se1091.team1.pms.repository;

import edu.ntut.se1091.team1.pms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username=:username OR u.email=:email")
    Optional<User> findByUsernameOrEmail(@Param("username") String username, @Param("email")  String email);
}