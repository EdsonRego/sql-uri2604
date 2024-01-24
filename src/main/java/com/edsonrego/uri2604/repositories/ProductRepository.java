package com.edsonrego.uri2604.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edsonrego.uri2604.entities.Products;
import com.edsonrego.uri2604.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Products, Long>{

	@Query(nativeQuery = true, value = "SELECT id, name "
			+ "FROM products "
			+ "WHERE products.price < 10 OR products.price > 100")
	List<ProductMinProjection> search1(Double price);
	
}
