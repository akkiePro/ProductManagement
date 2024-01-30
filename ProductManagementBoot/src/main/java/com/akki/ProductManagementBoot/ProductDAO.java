package com.akki.ProductManagementBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {

//    @Query("from Product where name ilike %:txt% OR type ilike %:txt% OR place ilike %:txt%")
//    @Query("SELECT p.name, p.type, p.place, p.warranty FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.place) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
//    @Query("SELECT p.name, p.type, p.place, p.warranty FROM Product p WHERE LOWER(p.name) ILIKE CONCAT('%', :searchTerm, '%') OR LOWER(p.type) ILIKE CONCAT('%', :searchTerm, '%') OR LOWER(p.place) ILIKE CONCAT('%', :searchTerm, '%')")
//    @Query("SELECT new com.akki.ProductManagementBoot.ProductDTO(p.name, p.type, p.place, p.warranty) FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.place) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    @Query("SELECT new com.akki.ProductManagementBoot.ProductDTO(p.name, p.type, p.place, p.warranty) FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.type) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(p.place) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<ProductDTO> findForTxt(@Param("searchTerm") String txt);

}
