/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author debianyisus
 */
@Entity
@Table(name = "tratamiento_medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TratamientoMedico.findAll", query = "SELECT t FROM TratamientoMedico t")
    , @NamedQuery(name = "TratamientoMedico.findByIdTratamientoMedico", query = "SELECT t FROM TratamientoMedico t WHERE t.idTratamientoMedico = :idTratamientoMedico")})
public class TratamientoMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tratamiento_medico")
    private Long idTratamientoMedico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "indicaciones_tratamiento")
    private String indicacionesTratamiento;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "observaciones_tratamiento")
    private String observacionesTratamiento;
    @JoinColumn(name = "id_historia_clinica", referencedColumnName = "id_historia_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HistoriaClinica idHistoriaClinica;
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Receta idReceta;

    public TratamientoMedico() {
    }

    public TratamientoMedico(Long idTratamientoMedico) {
        this.idTratamientoMedico = idTratamientoMedico;
    }

    public TratamientoMedico(Long idTratamientoMedico, String indicacionesTratamiento, String observacionesTratamiento) {
        this.idTratamientoMedico = idTratamientoMedico;
        this.indicacionesTratamiento = indicacionesTratamiento;
        this.observacionesTratamiento = observacionesTratamiento;
    }

    public Long getIdTratamientoMedico() {
        return idTratamientoMedico;
    }

    public void setIdTratamientoMedico(Long idTratamientoMedico) {
        this.idTratamientoMedico = idTratamientoMedico;
    }

    public String getIndicacionesTratamiento() {
        return indicacionesTratamiento;
    }

    public void setIndicacionesTratamiento(String indicacionesTratamiento) {
        this.indicacionesTratamiento = indicacionesTratamiento;
    }

    public String getObservacionesTratamiento() {
        return observacionesTratamiento;
    }

    public void setObservacionesTratamiento(String observacionesTratamiento) {
        this.observacionesTratamiento = observacionesTratamiento;
    }

    public HistoriaClinica getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(HistoriaClinica idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Receta getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Receta idReceta) {
        this.idReceta = idReceta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamientoMedico != null ? idTratamientoMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TratamientoMedico)) {
            return false;
        }
        TratamientoMedico other = (TratamientoMedico) object;
        if ((this.idTratamientoMedico == null && other.idTratamientoMedico != null) || (this.idTratamientoMedico != null && !this.idTratamientoMedico.equals(other.idTratamientoMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.TratamientoMedico[ idTratamientoMedico=" + idTratamientoMedico + " ]";
    }
    
}
