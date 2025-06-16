package ptf.aurea_etrgovina.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptf.aurea_etrgovina.Models.Role;
import ptf.aurea_etrgovina.Models.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}