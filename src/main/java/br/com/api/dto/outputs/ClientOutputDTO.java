package br.com.api.dto.outputs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ClientOutputDTO implements Serializable {

    public static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String lastName;

}
