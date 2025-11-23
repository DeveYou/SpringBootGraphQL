package com.example.banqueservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montant;

    private TypeTransaction type; // "DEBIT" or "CREDIT"

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    @Column(name = "compte_id", insertable = false, updatable = false)
    private Long compteId;
}
