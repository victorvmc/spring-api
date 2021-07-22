package br.com.api.models;

import br.com.api.models.utils.CurrencyEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;
    private Double amount;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
//    @JsonBackReference
    private Client client;

    public Transfer(CurrencyEnum currency, double amount, Client client) {
        this.currency = currency;
        this.amount = amount;
        this.client = client;
    }
}
