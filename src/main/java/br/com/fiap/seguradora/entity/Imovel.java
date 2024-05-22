package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_IMOVEL", uniqueConstraints = {
        @UniqueConstraint(name = "UK_IMOVEL_MATRICULA", columnNames = "MATRICULA_IMOVEL")
})
public class Imovel extends Asseguravel {

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

    @Column(name = "MATRICULA_IMOVEL", unique = true) // Certifique-se de que esta coluna é única
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_IMOVEL")
    private TipoSeguro tipo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ENDERECO", // Nome da coluna de chave estrangeira
            referencedColumnName = "ID_ENDERECO",
            foreignKey = @ForeignKey(name = "FK_IMOVEL_ENDERECO")
    )
    private Endereco endereco;

    //Relacionamento ManyToMany
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TBL_IMOVEL_FOTO",
            joinColumns = @JoinColumn(
                    name = "IMOVEL", // Nome da coluna de chave estrangeira
                    referencedColumnName = "ID_ASSEGURAVEL",
                    foreignKey = @ForeignKey(name = "FK_IMOVEL_FOTO")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "FOTO", // Nome da coluna de chave estrangeira
                    referencedColumnName = "ID_FOTO",
                    foreignKey = @ForeignKey(name = "FK_FOTO_IMOVEL")
            )
    )
    private Set<Foto> fotos = new LinkedHashSet<>();
}
