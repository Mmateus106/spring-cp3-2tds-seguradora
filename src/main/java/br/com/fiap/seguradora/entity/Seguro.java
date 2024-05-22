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
    @SequenceGenerator(name = "SQ_SEGURO", sequenceName = "SQ_SEGURO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SEGURO")
    @Column(name = "ID_SEGURO")
    private Long id;

    @Column(name = "PREMIO")
    private Double premio;

    @Column(name = "VL_SEGURO")
    private Double valor;

    @Column(name = "SEGURO_INICIO")
    private LocalDate inico;

    @Column(name = "SEGURO_FIM")
    private LocalDate fim;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "CONTRATANTE",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_CONTRATANTE_SEGURO"
            )
    )
    private Pessoa contratante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "OBJETO",
            referencedColumnName = "ID_ASSEGURAVEL",
            foreignKey = @ForeignKey(
                    name = "FK_OBJETO_SEGURO"
            )
    )
    private Asseguravel objeto;
}
