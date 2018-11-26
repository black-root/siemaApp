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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdMedicamento", query = "SELECT m FROM Medicamento m WHERE m.idMedicamento = :idMedicamento")
    , @NamedQuery(name = "Medicamento.findByComposicionQuimica", query = "SELECT m FROM Medicamento m WHERE m.composicionQuimica = :composicionQuimica")
    , @NamedQuery(name = "Medicamento.findByConcentracionQuimica", query = "SELECT m FROM Medicamento m WHERE m.concentracionQuimica = :concentracionQuimica")
    , @NamedQuery(name = "Medicamento.findByGrupoEdad", query = "SELECT m FROM Medicamento m WHERE m.grupoEdad = :grupoEdad")
    , @NamedQuery(name = "Medicamento.findByViaAdministracion", query = "SELECT m FROM Medicamento m WHERE m.viaAdministracion = :viaAdministracion")
    , @NamedQuery(name = "Medicamento.findByAdvertencias", query = "SELECT m FROM Medicamento m WHERE m.advertencias = :advertencias")
    , @NamedQuery(name = "Medicamento.findByContraindicaciones", query = "SELECT m FROM Medicamento m WHERE m.contraindicaciones = :contraindicaciones")
    , @NamedQuery(name = "Medicamento.findByDosis", query = "SELECT m FROM Medicamento m WHERE m.dosis = :dosis")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicamento")
    private Integer idMedicamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "composicion_quimica")
    private String composicionQuimica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "concentracion_quimica")
    private String concentracionQuimica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "grupo_edad")
    private String grupoEdad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 28)
    @Column(name = "via_administracion")
    private String viaAdministracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "advertencias")
    private String advertencias;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contraindicaciones")
    private String contraindicaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "dosis")
    private String dosis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedicamento", fetch = FetchType.LAZY)
    private List<MedicamentosPorReceta> medicamentosPorRecetaList;
    @JoinColumn(name = "id_tipo_medicamento", referencedColumnName = "id_tipo_medicamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMedicamento idTipoMedicamento;

    public Medicamento() {
    }

    public Medicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Medicamento(Integer idMedicamento, String composicionQuimica, String concentracionQuimica, String grupoEdad, String viaAdministracion, String advertencias, String contraindicaciones, String dosis) {
        this.idMedicamento = idMedicamento;
        this.composicionQuimica = composicionQuimica;
        this.concentracionQuimica = concentracionQuimica;
        this.grupoEdad = grupoEdad;
        this.viaAdministracion = viaAdministracion;
        this.advertencias = advertencias;
        this.contraindicaciones = contraindicaciones;
        this.dosis = dosis;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getComposicionQuimica() {
        return composicionQuimica;
    }

    public void setComposicionQuimica(String composicionQuimica) {
        this.composicionQuimica = composicionQuimica;
    }

    public String getConcentracionQuimica() {
        return concentracionQuimica;
    }

    public void setConcentracionQuimica(String concentracionQuimica) {
        this.concentracionQuimica = concentracionQuimica;
    }

    public String getGrupoEdad() {
        return grupoEdad;
    }

    public void setGrupoEdad(String grupoEdad) {
        this.grupoEdad = grupoEdad;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public String getAdvertencias() {
        return advertencias;
    }

    public void setAdvertencias(String advertencias) {
        this.advertencias = advertencias;
    }

    public String getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(String contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @JsonbTransient
    @XmlTransient
    public List<MedicamentosPorReceta> getMedicamentosPorRecetaList() {
        return medicamentosPorRecetaList;
    }

    public void setMedicamentosPorRecetaList(List<MedicamentosPorReceta> medicamentosPorRecetaList) {
        this.medicamentosPorRecetaList = medicamentosPorRecetaList;
    }

    public TipoMedicamento getIdTipoMedicamento() {
        return idTipoMedicamento;
    }

    public void setIdTipoMedicamento(TipoMedicamento idTipoMedicamento) {
        this.idTipoMedicamento = idTipoMedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicamento != null ? idMedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idMedicamento == null && other.idMedicamento != null) || (this.idMedicamento != null && !this.idMedicamento.equals(other.idMedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.Medicamento[ idMedicamento=" + idMedicamento + " ]";
    }
    
}
