package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_PESSOA")
public class Pessoa {

    @Id
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "SOBRENOME_PESSOA")
    private String sobrenome;

    @Column(name = "EMAIL_PESSOA")
    private String email;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate nascimento;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TBL_PESSOA_ENDERECO",
            joinColumns = {
                    @JoinColumn(
                            name = "PESSOA",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PESSOA_ENDERECO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ENDERECO",
                            referencedColumnName = "ID_ENDERECO",
                            foreignKey = @ForeignKey(
                                    name = "FK_ENDERECO_PESSOA"
                            )
                    )
            }
    )
    private Set<Endereco> enderecos = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PESSOA")
    private TipoPessoa tipo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "DOCUMENTO",
            referencedColumnName = "ID_DOCUMENTO",
            foreignKey = @ForeignKey(
                    name = "FK_PESSOA_DOCUMENTO"
            )
    )
    private Documento documento;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TBl_PESSOA_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "PESSOA",
                            referencedColumnName = "ID_PESSOA",
                            foreignKey = @ForeignKey(
                                    name = "FK_PESSOA_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_PESSOA"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();
}
