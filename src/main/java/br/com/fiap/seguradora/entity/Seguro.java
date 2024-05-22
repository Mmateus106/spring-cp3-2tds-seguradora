package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_SEGURO")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SEGURO")
    @SequenceGenerator(name = "SQ_SEGURO", sequenceName = "SQ_SEGURO", allocationSize = 1)

    @Column(name = "ID_SEGURO")
    private Long id;

    @Column(name = "PREMIO_SEGURO")
    private double premio;

    @Column(name = "VALOR_SEGURO")
    private double valor;

    @Column(name = "INICIO_SEGURO")
    private LocalDate inicio;

    @Column(name = "FIM_SEGURO")
    private LocalDate fim;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_SEGURO_PESSOA"
            )
    )
    private Pessoa contratante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ASSEGURAVEL",
            referencedColumnName = "ID_ASSEGURAVEL",
            foreignKey = @ForeignKey(
                    name = "FK_SEGURO_ASSEGURAVEL"
            )
    )
    private Pessoa objeto;

}
