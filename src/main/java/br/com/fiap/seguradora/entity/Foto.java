package br.com.fiap.seguradora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TBL_FOTO")
public class Foto {

    @Id
    @SequenceGenerator(name = "SQ_FOTO", sequenceName = "SQ_FOTO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FOTO")
    @Column(name = "ID_FOTO")
    private Long id;

    @Column(name = "SRC")
    private String src;
}