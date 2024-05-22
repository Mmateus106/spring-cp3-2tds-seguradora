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
@Table(name = "TBL_DOCUMENTO")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DOCUMENTO")
    @SequenceGenerator(name = "SQ_DOCUMENTO", sequenceName = "SQ_DOCUMENTO", allocationSize = 1)
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    @Column(name = "NUMERO_DOCUMENTO")
    private String numero;

    @Column(name = "TIPO_DOCUMENTO")
    private TipoDocumento tipo;

    //Relacionamento ManyToMany
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_DOCUMENTO_FOTO",
            joinColumns = {
                    @JoinColumn(
                            name = "DOCUMENTO",
                            referencedColumnName = "ID_DOCUMENTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_DOCUMENTO_FOTO"
                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "FOTO",
                            referencedColumnName = "ID_FOTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_FOTO_DOCUMENTO"
                            )
                    )
            }
    )
    private Set<Foto> fotos = new LinkedHashSet<>();
}
