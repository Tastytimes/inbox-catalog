package com.inbox.foodCatalog.repo;

import com.inbox.foodCatalog.dto.CatalogDto;
import com.inbox.foodCatalog.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepo extends JpaRepository<Catalog, Integer> {

    List<Catalog> findByRestaurant(Integer restId);
}
