package com.shafayat.vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shafayat.vendor.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
