/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api2018.g1.siemadata;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sig
 */
@Entity
@Table(name = "especialidad_por_profesional", catalog = "bdmedica", schema = "")
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
    @Column(name = "id_especialidad_por_profesional", nullable = false)
    private Integer idEspecialidadPorProfesional;
    @Basic(optional = false)
    @Column(name = "jvp_supervisora", nullable = false, length = 94)
    private String jvpSupervisora;
    @Basic(optional = false)
    @Column(name = "numer_jvp", nullable = false, length = 45)
    private String numerJvp;
    @Basic(optional = false)
    @Column(name = "ejerciendo", nullable = false)
    private boolean ejerciendo;
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id_especialidad", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Especialidad idEspecialidad;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud", nullable = false)
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
        return "api2018.g1.siemadata.EspecialidadPorProfesional[ idEspecialidadPorProfesional=" + idEspecialidadPorProfesional + " ]";
    }
    
}
