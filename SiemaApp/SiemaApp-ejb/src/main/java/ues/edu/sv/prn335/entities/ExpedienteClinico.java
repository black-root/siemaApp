/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author debianyisus
 */
@Entity
@Table(name = "expediente_clinico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpedienteClinico.findAll", query = "SELECT e FROM ExpedienteClinico e")
    , @NamedQuery(name = "ExpedienteClinico.findByIdExpedienteClinico", query = "SELECT e FROM ExpedienteClinico e WHERE e.idExpedienteClinico = :idExpedienteClinico")
    , @NamedQuery(name = "ExpedienteClinico.findByFechaRegistro", query = "SELECT e FROM ExpedienteClinico e WHERE e.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "ExpedienteClinico.findByEstadoExpediente", query = "SELECT e FROM ExpedienteClinico e WHERE e.estadoExpediente = :estadoExpediente")
    , @NamedQuery(name = "ExpedienteClinico.findByObservaciones", query = "SELECT e FROM ExpedienteClinico e WHERE e.observaciones = :observaciones")})
public class ExpedienteClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_expediente_clinico")
    private Long idExpedienteClinico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_expediente")
    private boolean estadoExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExpediente", fetch = FetchType.LAZY)
    private List<HistoriaClinica> historiaClinicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExpediente", fetch = FetchType.LAZY)
    private List<Cita> citaList;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idPaciente;

    public ExpedienteClinico() {
    }

    public ExpedienteClinico(Long idExpedienteClinico) {
        this.idExpedienteClinico = idExpedienteClinico;
    }

    public ExpedienteClinico(Long idExpedienteClinico, Date fechaRegistro, boolean estadoExpediente, String observaciones) {
        this.idExpedienteClinico = idExpedienteClinico;
        this.fechaRegistro = fechaRegistro;
        this.estadoExpediente = estadoExpediente;
        this.observaciones = observaciones;
    }

    public Long getIdExpedienteClinico() {
        return idExpedienteClinico;
    }

    public void setIdExpedienteClinico(Long idExpedienteClinico) {
        this.idExpedienteClinico = idExpedienteClinico;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean getEstadoExpediente() {
        return estadoExpediente;
    }

    public void setEstadoExpediente(boolean estadoExpediente) {
        this.estadoExpediente = estadoExpediente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<HistoriaClinica> getHistoriaClinicaList() {
        return historiaClinicaList;
    }

    public void setHistoriaClinicaList(List<HistoriaClinica> historiaClinicaList) {
        this.historiaClinicaList = historiaClinicaList;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExpedienteClinico != null ? idExpedienteClinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpedienteClinico)) {
            return false;
        }
        ExpedienteClinico other = (ExpedienteClinico) object;
        if ((this.idExpedienteClinico == null && other.idExpedienteClinico != null) || (this.idExpedienteClinico != null && !this.idExpedienteClinico.equals(other.idExpedienteClinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.ExpedienteClinico[ idExpedienteClinico=" + idExpedienteClinico + " ]";
    }
    
}
