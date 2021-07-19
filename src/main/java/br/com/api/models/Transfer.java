package br.com.api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_transfer")
public class Transfer implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String currency;
    private double amount;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
//    @JsonBackReference
    private Client client;

    public Transfer(String currency, double amount, Client client) {

        this.currency = currency;
        this.amount = amount;
        this.client = client;
    }
}
