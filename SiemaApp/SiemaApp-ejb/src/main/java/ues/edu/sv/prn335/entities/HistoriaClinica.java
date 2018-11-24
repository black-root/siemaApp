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
import javax.persistence.Lob;
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
@Table(name = "historia_clinica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoriaClinica.findAll", query = "SELECT h FROM HistoriaClinica h")
    , @NamedQuery(name = "HistoriaClinica.findByIdHistoriaClinica", query = "SELECT h FROM HistoriaClinica h WHERE h.idHistoriaClinica = :idHistoriaClinica")
    , @NamedQuery(name = "HistoriaClinica.findByFechaCreacion", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "HistoriaClinica.findByFechaIngreso", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "HistoriaClinica.findByFechaAlta", query = "SELECT h FROM HistoriaClinica h WHERE h.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "HistoriaClinica.findByMotivoConsulta", query = "SELECT h FROM HistoriaClinica h WHERE h.motivoConsulta = :motivoConsulta")})
public class HistoriaClinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historia_clinica")
    private Long idHistoriaClinica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "enfermedad_actual")
    private String enfermedadActual;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "antecedentes")
    private String antecedentes;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "datos_subjetivos")
    private String datosSubjetivos;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "examen_fisico")
    private String examenFisico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "diagnostico")
    private String diagnostico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "plan_diagnostico")
    private String planDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "pronostico")
    private String pronostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoriaClinica", fetch = FetchType.LAZY)
    private List<TratamientoMedico> tratamientoMedicoList;
    @JoinColumn(name = "id_expediente", referencedColumnName = "id_expediente_clinico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ExpedienteClinico idExpediente;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfesionalSalud idProfesionalSalud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHistoriaClinica", fetch = FetchType.LAZY)
    private List<Cita> citaList;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Long idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public HistoriaClinica(Long idHistoriaClinica, Date fechaCreacion, String motivoConsulta, String enfermedadActual, String antecedentes, String datosSubjetivos, String examenFisico, String diagnostico, String planDiagnostico, String pronostico) {
        this.idHistoriaClinica = idHistoriaClinica;
        this.fechaCreacion = fechaCreacion;
        this.motivoConsulta = motivoConsulta;
        this.enfermedadActual = enfermedadActual;
        this.antecedentes = antecedentes;
        this.datosSubjetivos = datosSubjetivos;
        this.examenFisico = examenFisico;
        this.diagnostico = diagnostico;
        this.planDiagnostico = planDiagnostico;
        this.pronostico = pronostico;
    }

    public Long getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Long idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getDatosSubjetivos() {
        return datosSubjetivos;
    }

    public void setDatosSubjetivos(String datosSubjetivos) {
        this.datosSubjetivos = datosSubjetivos;
    }

    public String getExamenFisico() {
        return examenFisico;
    }

    public void setExamenFisico(String examenFisico) {
        this.examenFisico = examenFisico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPlanDiagnostico() {
        return planDiagnostico;
    }

    public void setPlanDiagnostico(String planDiagnostico) {
        this.planDiagnostico = planDiagnostico;
    }

    public String getPronostico() {
        return pronostico;
    }

    public void setPronostico(String pronostico) {
        this.pronostico = pronostico;
    }

    @XmlTransient
    public List<TratamientoMedico> getTratamientoMedicoList() {
        return tratamientoMedicoList;
    }

    public void setTratamientoMedicoList(List<TratamientoMedico> tratamientoMedicoList) {
        this.tratamientoMedicoList = tratamientoMedicoList;
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

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoriaClinica != null ? idHistoriaClinica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoriaClinica)) {
            return false;
        }
        HistoriaClinica other = (HistoriaClinica) object;
        if ((this.idHistoriaClinica == null && other.idHistoriaClinica != null) || (this.idHistoriaClinica != null && !this.idHistoriaClinica.equals(other.idHistoriaClinica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.HistoriaClinica[ idHistoriaClinica=" + idHistoriaClinica + " ]";
    }
    
}
