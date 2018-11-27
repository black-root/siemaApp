/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "medicamentos_por_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicamentosPorReceta.findAll", query = "SELECT m FROM MedicamentosPorReceta m")
    , @NamedQuery(name = "MedicamentosPorReceta.findByIdMedicamentosPorReceta", query = "SELECT m FROM MedicamentosPorReceta m WHERE m.idMedicamentosPorReceta = :idMedicamentosPorReceta")
    , @NamedQuery(name = "MedicamentosPorReceta.findByCantidadMedicamento", query = "SELECT m FROM MedicamentosPorReceta m WHERE m.cantidadMedicamento = :cantidadMedicamento")
    , @NamedQuery(name = "MedicamentosPorReceta.findByIndicacionesGenerales", query = "SELECT m FROM MedicamentosPorReceta m WHERE m.indicacionesGenerales = :indicacionesGenerales")})
public class MedicamentosPorReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamentos_por_receta")
    private Long idMedicamentosPorReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cantidad_medicamento")
    private String cantidadMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "indicaciones_generales")
    private String indicacionesGenerales;
    @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Medicamento idMedicamento;
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Receta idReceta;

    public MedicamentosPorReceta() {
    }

    public MedicamentosPorReceta(Long idMedicamentosPorReceta) {
        this.idMedicamentosPorReceta = idMedicamentosPorReceta;
    }

    public MedicamentosPorReceta(Long idMedicamentosPorReceta, String cantidadMedicamento, String indicacionesGenerales) {
        this.idMedicamentosPorReceta = idMedicamentosPorReceta;
        this.cantidadMedicamento = cantidadMedicamento;
        this.indicacionesGenerales = indicacionesGenerales;
    }

    public Long getIdMedicamentosPorReceta() {
        return idMedicamentosPorReceta;
    }

    public void setIdMedicamentosPorReceta(Long idMedicamentosPorReceta) {
        this.idMedicamentosPorReceta = idMedicamentosPorReceta;
    }

    public String getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(String cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getIndicacionesGenerales() {
        return indicacionesGenerales;
    }

    public void setIndicacionesGenerales(String indicacionesGenerales) {
        this.indicacionesGenerales = indicacionesGenerales;
    }

    public Medicamento getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Medicamento idMedicamento) {
        this.idMedicamento = idMedicamento;
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
        hash += (idMedicamentosPorReceta != null ? idMedicamentosPorReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicamentosPorReceta)) {
            return false;
        }
        MedicamentosPorReceta other = (MedicamentosPorReceta) object;
        if ((this.idMedicamentosPorReceta == null && other.idMedicamentosPorReceta != null) || (this.idMedicamentosPorReceta != null && !this.idMedicamentosPorReceta.equals(other.idMedicamentosPorReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.MedicamentosPorReceta[ idMedicamentosPorReceta=" + idMedicamentosPorReceta + " ]";
    }
    
}
