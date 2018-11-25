/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.entities;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "tipo_estado_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstadoReceta.findAll", query = "SELECT t FROM TipoEstadoReceta t")
    , @NamedQuery(name = "TipoEstadoReceta.findByIdTipoEstadoReceta", query = "SELECT t FROM TipoEstadoReceta t WHERE t.idTipoEstadoReceta = :idTipoEstadoReceta")
    , @NamedQuery(name = "TipoEstadoReceta.findByEstado", query = "SELECT t FROM TipoEstadoReceta t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoEstadoReceta.findByNombre", query = "SELECT t FROM TipoEstadoReceta t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoEstadoReceta.findByDescripcion", query = "SELECT t FROM TipoEstadoReceta t WHERE t.descripcion = :descripcion")})
public class TipoEstadoReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_estado_receta")
    private Integer idTipoEstadoReceta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEstadoReceta", fetch = FetchType.LAZY)
    private List<Receta> recetaList;

    public TipoEstadoReceta() {
    }

    public TipoEstadoReceta(Integer idTipoEstadoReceta) {
        this.idTipoEstadoReceta = idTipoEstadoReceta;
    }

    public TipoEstadoReceta(Integer idTipoEstadoReceta, boolean estado, String nombre, String descripcion) {
        this.idTipoEstadoReceta = idTipoEstadoReceta;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoEstadoReceta() {
        return idTipoEstadoReceta;
    }

    public void setIdTipoEstadoReceta(Integer idTipoEstadoReceta) {
        this.idTipoEstadoReceta = idTipoEstadoReceta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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

    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEstadoReceta != null ? idTipoEstadoReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstadoReceta)) {
            return false;
        }
        TipoEstadoReceta other = (TipoEstadoReceta) object;
        if ((this.idTipoEstadoReceta == null && other.idTipoEstadoReceta != null) || (this.idTipoEstadoReceta != null && !this.idTipoEstadoReceta.equals(other.idTipoEstadoReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.TipoEstadoReceta[ idTipoEstadoReceta=" + idTipoEstadoReceta + " ]";
    }
    
}
