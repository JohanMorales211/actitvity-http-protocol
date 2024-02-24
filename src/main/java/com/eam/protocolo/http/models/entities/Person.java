package com.eam.protocolo.http.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "person")
@ToString
@SQLDelete(sql = "UPDATE person SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "deleted_at is null")
@Proxy(lazy = false)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "document_number")
    private String documentNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Reservation> listReservations;

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
