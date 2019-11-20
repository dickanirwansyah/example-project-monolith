package com.dicka.appinventory.repository;

import com.dicka.appinventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findProductByName(String name);
    Optional<Product> findProductByStock(int stock);
    Optional<Product> findProductByAvailable(double available);

    @Query("SELECT p FROM Product p WHERE p.category.id=:category_id")
    Optional<Product> findProductByCategoryId(@Param("category_id") int cateoryId);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :maxPrice AND :minPrice")
    List<Product> findProductByMaxPriceBetweenMinPrice(@Param("maxPrice") double maxPrice,
                                                       @Param("minPrice") double minPrice);
}
