package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_IMOVEL")
public class Imovel extends Asseguravel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_IMOVEL")
    @SequenceGenerator(name = "SQ_IMOVEL", sequenceName = "SQ_IMOVEL", allocationSize = 1)

    @Column(name = "DESC_IMOVEL")
    private String descricao;

    @Column(name = "METROS_QUADRADOS_IMOVEL")
    private Float metrosQuadrados;

    @Column(name = "QUARTOS_IMOVEL")
    private Integer quartos;

    @Column(name = "BANHEIROS_IMOVEL")
    private Integer banheiros;

    @Column(name = "VAGAS_GARAGEM_IMOVEL")
    private Integer vagasGaragem;

    @Column(name = "MATRICULA_IMOVEL")
    private String matricula;

    @Column(name = "TIPO_IMOVEL")
    private TipoSeguro tipo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO",
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(
                    name = "FK_IMOVEL_ENDERECO"
            )
    )
    private Endereco endereco;

    //Relacionamento ManyToMany
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_IMOVEL_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "IMOVEL",
                            referencedColumnName = "ID_ASSEGURAVEL",
                            foreignKey = @ForeignKey(
                                    name = "FK_IMOVEL_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_IMOVEL"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();
}
