package ptf.aurea_etrgovina.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ptf.aurea_etrgovina.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}