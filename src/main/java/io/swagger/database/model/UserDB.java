package io.swagger.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDB {
    @Id
    private UUID id;

    private String name;

    private String surname;

    private String adressStreet;

    private Integer buildingNumber;

    private Integer apartmentNumber;

    private String zipCode;

    private String city;

    private String email;
}
