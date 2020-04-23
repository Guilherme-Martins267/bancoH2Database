package Martins.Guilherme.bancoH2Database.model;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table
public class PersonagensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personagens")
    private long id;

    @Column(name = "Ator")
    private String actor;

    @Column(name = "Idade")
    private long age;

    @Column(name = "Personagem")
    private String character;

    @Column(name = "Filme")
    private String movie;
}