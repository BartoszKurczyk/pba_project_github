package io.swagger.database.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "orderRaws")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRawDB {
    @Id
    private UUID id;

    private UUID orderId;

    private UUID productId;

    private Integer quantity;
}
