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
@Table(name = "TBL_DOCUMENTO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_DOCUMENTO_TIPO",columnNames = "TP_DOCUMENTO"),
        @UniqueConstraint(name = "UK_DOCUMENTO_NUMERO",columnNames = "NM_DOCUMENTO")
})
public class Documento {

    @Id
    @SequenceGenerator(name = "SQ_DOCUMENTO", sequenceName = "SQ_DOCUMENTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DOCUMENTO")
    @Column(name = "ID_DOCUMENTO")
    private Long id;

    @Column(name = "NM_DOCUMENTO")
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_DOCUMENTO")
    private TipoDocumento tipo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TBL_DOCUMENTO_FOTO",
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