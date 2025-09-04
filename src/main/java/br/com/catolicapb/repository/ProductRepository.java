package br.com.catolicapb.repository;

import br.com.catolicapb.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByDescriptionIgnoreCaseAndMakerIgnoreCase (String description, String maker);
}
