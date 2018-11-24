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
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r")
    , @NamedQuery(name = "Receta.findByIdReceta", query = "SELECT r FROM Receta r WHERE r.idReceta = :idReceta")
    , @NamedQuery(name = "Receta.findByFechaEmision", query = "SELECT r FROM Receta r WHERE r.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "Receta.findByFechaDespacho", query = "SELECT r FROM Receta r WHERE r.fechaDespacho = :fechaDespacho")
    , @NamedQuery(name = "Receta.findByIndicacionesGenerales", query = "SELECT r FROM Receta r WHERE r.indicacionesGenerales = :indicacionesGenerales")
    , @NamedQuery(name = "Receta.findByComentarios", query = "SELECT r FROM Receta r WHERE r.comentarios = :comentarios")})
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_receta")
    private Long idReceta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_despacho")
    @Temporal(TemporalType.DATE)
    private Date fechaDespacho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "indicaciones_generales")
    private String indicacionesGenerales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Paciente idPaciente;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfesionalSalud idProfesionalSalud;
    @JoinColumn(name = "tipo_receta", referencedColumnName = "id_tipo_receta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoReceta tipoReceta;
    @JoinColumn(name = "tipo_estado_receta", referencedColumnName = "id_tipo_estado_receta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoEstadoReceta tipoEstadoReceta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReceta", fetch = FetchType.LAZY)
    private List<TratamientoMedico> tratamientoMedicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idReceta", fetch = FetchType.LAZY)
    private List<MedicamentosPorReceta> medicamentosPorRecetaList;

    public Receta() {
    }

    public Receta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public Receta(Long idReceta, Date fechaEmision, String indicacionesGenerales, String comentarios) {
        this.idReceta = idReceta;
        this.fechaEmision = fechaEmision;
        this.indicacionesGenerales = indicacionesGenerales;
        this.comentarios = comentarios;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(Date fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getIndicacionesGenerales() {
        return indicacionesGenerales;
    }

    public void setIndicacionesGenerales(String indicacionesGenerales) {
        this.indicacionesGenerales = indicacionesGenerales;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public ProfesionalSalud getIdProfesionalSalud() {
        return idProfesionalSalud;
    }

    public void setIdProfesionalSalud(ProfesionalSalud idProfesionalSalud) {
        this.idProfesionalSalud = idProfesionalSalud;
    }

    public TipoReceta getTipoReceta() {
        return tipoReceta;
    }

    public void setTipoReceta(TipoReceta tipoReceta) {
        this.tipoReceta = tipoReceta;
    }

    public TipoEstadoReceta getTipoEstadoReceta() {
        return tipoEstadoReceta;
    }

    public void setTipoEstadoReceta(TipoEstadoReceta tipoEstadoReceta) {
        this.tipoEstadoReceta = tipoEstadoReceta;
    }

    @XmlTransient
    public List<TratamientoMedico> getTratamientoMedicoList() {
        return tratamientoMedicoList;
    }

    public void setTratamientoMedicoList(List<TratamientoMedico> tratamientoMedicoList) {
        this.tratamientoMedicoList = tratamientoMedicoList;
    }

    @XmlTransient
    public List<MedicamentosPorReceta> getMedicamentosPorRecetaList() {
        return medicamentosPorRecetaList;
    }

    public void setMedicamentosPorRecetaList(List<MedicamentosPorReceta> medicamentosPorRecetaList) {
        this.medicamentosPorRecetaList = medicamentosPorRecetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReceta != null ? idReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idReceta == null && other.idReceta != null) || (this.idReceta != null && !this.idReceta.equals(other.idReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.Receta[ idReceta=" + idReceta + " ]";
    }
    
}
