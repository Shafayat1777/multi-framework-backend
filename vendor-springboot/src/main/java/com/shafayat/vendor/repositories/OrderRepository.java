package com.shafayat.vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shafayat.vendor.entities.Product;

public interface OrderRepository extends JpaRepository<Product, Long> {

}
