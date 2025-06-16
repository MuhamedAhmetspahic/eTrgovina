package ptf.aurea_etrgovina.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptf.aurea_etrgovina.Models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
