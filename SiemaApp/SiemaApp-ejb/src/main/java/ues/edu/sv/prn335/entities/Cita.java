/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.sv.prn335.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author debianyisus
 */
@Entity
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c")
    , @NamedQuery(name = "Cita.findByIdCita", query = "SELECT c FROM Cita c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Cita.findByFechaConsulta", query = "SELECT c FROM Cita c WHERE c.fechaConsulta = :fechaConsulta")
    , @NamedQuery(name = "Cita.findByFechaProximaConsulta", query = "SELECT c FROM Cita c WHERE c.fechaProximaConsulta = :fechaProximaConsulta")
    , @NamedQuery(name = "Cita.findByEstado", query = "SELECT c FROM Cita c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cita.findByObservaciones", query = "SELECT c FROM Cita c WHERE c.observaciones = :observaciones")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cita")
    private Long idCita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_consulta")
    @Temporal(TemporalType.DATE)
    private Date fechaConsulta;
    @Column(name = "fecha_proxima_consulta")
    @Temporal(TemporalType.DATE)
    private Date fechaProximaConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Size(max = 60)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_expediente", referencedColumnName = "id_expediente_clinico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ExpedienteClinico idExpediente;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfesionalSalud idProfesionalSalud;
    @JoinColumn(name = "id_historia_clinica", referencedColumnName = "id_historia_clinica")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HistoriaClinica idHistoriaClinica;

    public Cita() {
    }

    public Cita(Long idCita) {
        this.idCita = idCita;
    }

    public Cita(Long idCita, Date fechaConsulta, boolean estado) {
        this.idCita = idCita;
        this.fechaConsulta = fechaConsulta;
        this.estado = estado;
    }

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Date getFechaProximaConsulta() {
        return fechaProximaConsulta;
    }

    public void setFechaProximaConsulta(Date fechaProximaConsulta) {
        this.fechaProximaConsulta = fechaProximaConsulta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ExpedienteClinico getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(ExpedienteClinico idExpediente) {
        this.idExpediente = idExpediente;
    }

    public ProfesionalSalud getIdProfesionalSalud() {
        return idProfesionalSalud;
    }

    public void setIdProfesionalSalud(ProfesionalSalud idProfesionalSalud) {
        this.idProfesionalSalud = idProfesionalSalud;
    }

    public HistoriaClinica getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(HistoriaClinica idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.Cita[ idCita=" + idCita + " ]";
    }
    
}
