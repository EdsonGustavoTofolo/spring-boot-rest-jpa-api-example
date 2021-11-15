package io.github.edsontofolo.springbootjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ComplementoAnuarioRamoUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complemento_anuario_id")
    private ComplementoAnuario complementoAnuario;
}