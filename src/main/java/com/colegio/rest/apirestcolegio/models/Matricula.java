package com.colegio.rest.apirestcolegio.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false, foreignKey = @ForeignKey(name = "FK_Matricula_Estudiante"))
    private Estudiante estudiante;

    @Column(nullable = false,length = 50)
    private LocalDateTime fechamatricula;

    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MatriculaDetalle> matriculaDetalle;
}
