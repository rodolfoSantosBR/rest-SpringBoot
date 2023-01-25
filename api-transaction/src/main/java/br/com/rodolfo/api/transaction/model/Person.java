package br.com.rodolfo.api.transaction.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@Setter
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 80)
    private String firstName;
    @Column(name = "last_name", nullable = false , length = 80 )
    private String lastName;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 6)
    private String gender;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
