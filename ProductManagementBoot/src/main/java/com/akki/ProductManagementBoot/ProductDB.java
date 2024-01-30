package com.akki.ProductManagementBoot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDB extends JpaRepository<Product, Integer> {

}
