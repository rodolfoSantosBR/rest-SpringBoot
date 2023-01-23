package br.com.rodolfo.api.transaction.model;

import lombok.*;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Setter
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;




}
