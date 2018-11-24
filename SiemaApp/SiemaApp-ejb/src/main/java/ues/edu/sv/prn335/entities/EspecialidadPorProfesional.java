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
@Table(name = "especialidad_por_profesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EspecialidadPorProfesional.findAll", query = "SELECT e FROM EspecialidadPorProfesional e")
    , @NamedQuery(name = "EspecialidadPorProfesional.findByIdEspecialidadPorProfesional", query = "SELECT e FROM EspecialidadPorProfesional e WHERE e.idEspecialidadPorProfesional = :idEspecialidadPorProfesional")
    , @NamedQuery(name = "EspecialidadPorProfesional.findByJvpSupervisora", query = "SELECT e FROM EspecialidadPorProfesional e WHERE e.jvpSupervisora = :jvpSupervisora")
    , @NamedQuery(name = "EspecialidadPorProfesional.findByNumerJvp", query = "SELECT e FROM EspecialidadPorProfesional e WHERE e.numerJvp = :numerJvp")
    , @NamedQuery(name = "EspecialidadPorProfesional.findByEjerciendo", query = "SELECT e FROM EspecialidadPorProfesional e WHERE e.ejerciendo = :ejerciendo")})
public class EspecialidadPorProfesional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_especialidad_por_profesional")
    private Integer idEspecialidadPorProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 94)
    @Column(name = "jvp_supervisora")
    private String jvpSupervisora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numer_jvp")
    private String numerJvp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ejerciendo")
    private boolean ejerciendo;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Especialidad idEspecialidad;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfesionalSalud idProfesionalSalud;

    public EspecialidadPorProfesional() {
    }

    public EspecialidadPorProfesional(Integer idEspecialidadPorProfesional) {
        this.idEspecialidadPorProfesional = idEspecialidadPorProfesional;
    }

    public EspecialidadPorProfesional(Integer idEspecialidadPorProfesional, String jvpSupervisora, String numerJvp, boolean ejerciendo) {
        this.idEspecialidadPorProfesional = idEspecialidadPorProfesional;
        this.jvpSupervisora = jvpSupervisora;
        this.numerJvp = numerJvp;
        this.ejerciendo = ejerciendo;
    }

    public Integer getIdEspecialidadPorProfesional() {
        return idEspecialidadPorProfesional;
    }

    public void setIdEspecialidadPorProfesional(Integer idEspecialidadPorProfesional) {
        this.idEspecialidadPorProfesional = idEspecialidadPorProfesional;
    }

    public String getJvpSupervisora() {
        return jvpSupervisora;
    }

    public void setJvpSupervisora(String jvpSupervisora) {
        this.jvpSupervisora = jvpSupervisora;
    }

    public String getNumerJvp() {
        return numerJvp;
    }

    public void setNumerJvp(String numerJvp) {
        this.numerJvp = numerJvp;
    }

    public boolean getEjerciendo() {
        return ejerciendo;
    }

    public void setEjerciendo(boolean ejerciendo) {
        this.ejerciendo = ejerciendo;
    }

    public Especialidad getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Especialidad idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public ProfesionalSalud getIdProfesionalSalud() {
        return idProfesionalSalud;
    }

    public void setIdProfesionalSalud(ProfesionalSalud idProfesionalSalud) {
        this.idProfesionalSalud = idProfesionalSalud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecialidadPorProfesional != null ? idEspecialidadPorProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecialidadPorProfesional)) {
            return false;
        }
        EspecialidadPorProfesional other = (EspecialidadPorProfesional) object;
        if ((this.idEspecialidadPorProfesional == null && other.idEspecialidadPorProfesional != null) || (this.idEspecialidadPorProfesional != null && !this.idEspecialidadPorProfesional.equals(other.idEspecialidadPorProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.sv.prn335.entities.EspecialidadPorProfesional[ idEspecialidadPorProfesional=" + idEspecialidadPorProfesional + " ]";
    }
    
}
