package br.com.api.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

//    TODO to study
    public static final long serialVersionUID = 1L;

//    TODO add more atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;

//    @OneToMany(mappedBy = "client")
//    private List<Transfer> transfers;

}
