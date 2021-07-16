package br.com.api.dto.inputs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientInputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;

}
