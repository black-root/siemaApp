/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.entities;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author debianyisus
 */
@Entity
@Table(name = "profesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p")
    , @NamedQuery(name = "Profesion.findByIdProfesion", query = "SELECT p FROM Profesion p WHERE p.idProfesion = :idProfesion")
    , @NamedQuery(name = "Profesion.findByGradoAcademico", query = "SELECT p FROM Profesion p WHERE p.gradoAcademico = :gradoAcademico")
    , @NamedQuery(name = "Profesion.findByNombre", query = "SELECT p FROM Profesion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesion.findByDescripcion", query = "SELECT p FROM Profesion p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Profesion.findByEstadoProfesion", query = "SELECT p FROM Profesion p WHERE p.estadoProfesion = :estadoProfesion")
    , @NamedQuery(name = "Profesion.findByCapacidadRecetar", query = "SELECT p FROM Profesion p WHERE p.capacidadRecetar = :capacidadRecetar")})
public class Profesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesion")
    private Integer idProfesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 39)
    @Column(name = "grado_academico")
    private String gradoAcademico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_profesion")
    private boolean estadoProfesion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad_recetar")
    private boolean capacidadRecetar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesion", fetch = FetchType.LAZY)
    private List<Especialidad> especialidadList;

    public Profesion() {
    }

    public Profesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public Profesion(Integer idProfesion, String gradoAcademico, String nombre, String descripcion, boolean estadoProfesion, boolean capacidadRecetar) {
        this.idProfesion = idProfesion;
        this.gradoAcademico = gradoAcademico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoProfesion = estadoProfesion;
        this.capacidadRecetar = capacidadRecetar;
    }

    public Integer getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(Integer idProfesion) {
        this.idProfesion = idProfesion;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstadoProfesion() {
        return estadoProfesion;
    }

    public void setEstadoProfesion(boolean estadoProfesion) {
        this.estadoProfesion = estadoProfesion;
    }

    public boolean getCapacidadRecetar() {
        return capacidadRecetar;
    }

    public void setCapacidadRecetar(boolean capacidadRecetar) {
        this.capacidadRecetar = capacidadRecetar;
    }

    @JsonbTransient
    @XmlTransient
    public List<Especialidad> getEspecialidadList() {
        return especialidadList;
    }

    public void setEspecialidadList(List<Especialidad> especialidadList) {
        this.especialidadList = especialidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesion != null ? idProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.idProfesion == null && other.idProfesion != null) || (this.idProfesion != null && !this.idProfesion.equals(other.idProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.Profesion[ idProfesion=" + idProfesion + " ]";
    }
    
}
