package com.eam.protocolo.http.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "touristPackage")
@ToString
@SQLDelete(sql = "UPDATE touristPackage SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
@Proxy(lazy = false)
public class TouristPackage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private Integer time;

    @Column(name = "price")
    private Double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tourist_packages_destinations", joinColumns = @JoinColumn(name = "tourist_package_id"), inverseJoinColumns = @JoinColumn(name = "reservation_id"))
    private List<Destination> lstDestinations;
}
