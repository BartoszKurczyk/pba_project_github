package io.swagger.database.repository;

import io.swagger.database.model.OrderRawDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRawRepository extends JpaRepository<OrderRawDB, UUID> {
}
