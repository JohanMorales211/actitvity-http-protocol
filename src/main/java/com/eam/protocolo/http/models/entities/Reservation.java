package com.eam.protocolo.http.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "reservation")
@ToString
@SQLDelete(sql = "UPDATE reservation SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
@Proxy(lazy = false)
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JsonBackReference
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(mappedBy = "tourist_package", fetch = FetchType.EAGER)
    private TouristPackage touristPackage;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "date_reservation")
    private Date dateReservation;

    @Column(name = "amount_people")
    private Integer amountPeople;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
}
