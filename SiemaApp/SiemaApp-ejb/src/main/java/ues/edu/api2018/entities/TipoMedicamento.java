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
@Table(name = "tipo_medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMedicamento.findAll", query = "SELECT t FROM TipoMedicamento t")
    , @NamedQuery(name = "TipoMedicamento.findByIdTipoMedicamento", query = "SELECT t FROM TipoMedicamento t WHERE t.idTipoMedicamento = :idTipoMedicamento")
    , @NamedQuery(name = "TipoMedicamento.findByEstado", query = "SELECT t FROM TipoMedicamento t WHERE t.estado = :estado")
    , @NamedQuery(name = "TipoMedicamento.findByNombre", query = "SELECT t FROM TipoMedicamento t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoMedicamento.findByDescripcionGeneral", query = "SELECT t FROM TipoMedicamento t WHERE t.descripcionGeneral = :descripcionGeneral")})
public class TipoMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_medicamento")
    private Integer idTipoMedicamento;
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
    @Column(name = "descripcion_general")
    private String descripcionGeneral;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMedicamento", fetch = FetchType.LAZY)
    private List<Medicamento> medicamentoList;

    public TipoMedicamento() {
    }

    public TipoMedicamento(Integer idTipoMedicamento) {
        this.idTipoMedicamento = idTipoMedicamento;
    }

    public TipoMedicamento(Integer idTipoMedicamento, boolean estado, String nombre, String descripcionGeneral) {
        this.idTipoMedicamento = idTipoMedicamento;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcionGeneral = descripcionGeneral;
    }

    public Integer getIdTipoMedicamento() {
        return idTipoMedicamento;
    }

    public void setIdTipoMedicamento(Integer idTipoMedicamento) {
        this.idTipoMedicamento = idTipoMedicamento;
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

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMedicamento != null ? idTipoMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMedicamento)) {
            return false;
        }
        TipoMedicamento other = (TipoMedicamento) object;
        if ((this.idTipoMedicamento == null && other.idTipoMedicamento != null) || (this.idTipoMedicamento != null && !this.idTipoMedicamento.equals(other.idTipoMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.TipoMedicamento[ idTipoMedicamento=" + idTipoMedicamento + " ]";
    }
    
}
