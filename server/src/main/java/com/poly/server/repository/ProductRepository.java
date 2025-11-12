package com.poly.server.repository;

import com.poly.server.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //    @Query("")
//    ten ham => tra ve select
    // custom add, update, delete
    @Modifying // danh dau query nay k phai la cau select
    @Transactional // dam bao tinh toan ven
    @Query("DELETE FROM Product p WHERE p.productCode = ?1")
    void deleteByMa(String ma);

    @Query("SELECT p FROM Product p WHERE p.productCode = ?1")
    Product detailTheoMa(String ma);
}
