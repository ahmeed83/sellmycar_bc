package com.focustechnology.sellmycar.repository.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "car_auction", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarAuction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String sellerName;
    @Column(nullable = false)
    private String sellerAddress;
    @Column(nullable = false)
    private String carMake;
    @Column(nullable = false)
    private String carModel;
    @Column(nullable = false)
    private Integer carYear;
    @Column(nullable = false)
    private Double carPrice;
    @Column(nullable = false)
    private String generalDescription;
    @Column(nullable = false)
    private Integer carMileage;
    @Column(nullable = false)
    private String carConditionBody;
    @Column(nullable = false)
    private String carConditionInterior;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarAuction that = (CarAuction) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
