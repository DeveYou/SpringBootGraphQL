package com.example.banqueservice.repositories;

import com.example.banqueservice.entities.Compte;
import com.example.banqueservice.entities.Transaction;
import com.example.banqueservice.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.compte = ?1")
    List<Transaction> findByCompte(Compte compte);

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.type = ?1")
    double sumByType(TypeTransaction type);

}
