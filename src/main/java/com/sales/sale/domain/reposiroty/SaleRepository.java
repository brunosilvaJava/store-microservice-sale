package com.sales.sale.domain.reposiroty;

import com.sales.sale.domain.model.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long> {

}
