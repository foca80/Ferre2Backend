package pe.upc.ferre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.upc.ferre.entidades.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p  where p.description like ?1%")
	List<Product> findProductDescription(String description);
}
