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
@Table(name = "tipo_receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoReceta.findAll", query = "SELECT t FROM TipoReceta t")
    , @NamedQuery(name = "TipoReceta.findByIdTipoReceta", query = "SELECT t FROM TipoReceta t WHERE t.idTipoReceta = :idTipoReceta")
    , @NamedQuery(name = "TipoReceta.findByNombre", query = "SELECT t FROM TipoReceta t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoReceta.findByEstado", query = "SELECT t FROM TipoReceta t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoReceta.findByComentarios", query = "SELECT t FROM TipoReceta t WHERE t.comentarios = :comentarios")})
public class TipoReceta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_receta")
    private Integer idTipoReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Size(max = 100)
    @Column(name = "comentarios")
    private String comentarios;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoReceta", fetch = FetchType.LAZY)
    private List<Receta> recetaList;

    public TipoReceta() {
    }

    public TipoReceta(Integer idTipoReceta) {
        this.idTipoReceta = idTipoReceta;
    }

    public TipoReceta(Integer idTipoReceta, String nombre, boolean estado) {
        this.idTipoReceta = idTipoReceta;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdTipoReceta() {
        return idTipoReceta;
    }

    public void setIdTipoReceta(Integer idTipoReceta) {
        this.idTipoReceta = idTipoReceta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
        hash += (idTipoReceta != null ? idTipoReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoReceta)) {
            return false;
        }
        TipoReceta other = (TipoReceta) object;
        if ((this.idTipoReceta == null && other.idTipoReceta != null) || (this.idTipoReceta != null && !this.idTipoReceta.equals(other.idTipoReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.TipoReceta[ idTipoReceta=" + idTipoReceta + " ]";
    }
    
}
