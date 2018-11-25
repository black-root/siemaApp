/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.entities;

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
@Table(name = "contacto_profesional_salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactoProfesionalSalud.findAll", query = "SELECT c FROM ContactoProfesionalSalud c")
    , @NamedQuery(name = "ContactoProfesionalSalud.findByIdContactoProfesionalSalud", query = "SELECT c FROM ContactoProfesionalSalud c WHERE c.idContactoProfesionalSalud = :idContactoProfesionalSalud")
    , @NamedQuery(name = "ContactoProfesionalSalud.findByTipoContacto", query = "SELECT c FROM ContactoProfesionalSalud c WHERE c.tipoContacto = :tipoContacto")
    , @NamedQuery(name = "ContactoProfesionalSalud.findByInformacion", query = "SELECT c FROM ContactoProfesionalSalud c WHERE c.informacion = :informacion")})
public class ContactoProfesionalSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_contacto_profesional_salud")
    private Integer idContactoProfesionalSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 29)
    @Column(name = "tipo_contacto")
    private String tipoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "informacion")
    private String informacion;
    @JoinColumn(name = "id_profesional_salud", referencedColumnName = "id_profesional_salud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProfesionalSalud idProfesionalSalud;

    public ContactoProfesionalSalud() {
    }

    public ContactoProfesionalSalud(Integer idContactoProfesionalSalud) {
        this.idContactoProfesionalSalud = idContactoProfesionalSalud;
    }

    public ContactoProfesionalSalud(Integer idContactoProfesionalSalud, String tipoContacto, String informacion) {
        this.idContactoProfesionalSalud = idContactoProfesionalSalud;
        this.tipoContacto = tipoContacto;
        this.informacion = informacion;
    }

    public Integer getIdContactoProfesionalSalud() {
        return idContactoProfesionalSalud;
    }

    public void setIdContactoProfesionalSalud(Integer idContactoProfesionalSalud) {
        this.idContactoProfesionalSalud = idContactoProfesionalSalud;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
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
        hash += (idContactoProfesionalSalud != null ? idContactoProfesionalSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoProfesionalSalud)) {
            return false;
        }
        ContactoProfesionalSalud other = (ContactoProfesionalSalud) object;
        if ((this.idContactoProfesionalSalud == null && other.idContactoProfesionalSalud != null) || (this.idContactoProfesionalSalud != null && !this.idContactoProfesionalSalud.equals(other.idContactoProfesionalSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.ContactoProfesionalSalud[ idContactoProfesionalSalud=" + idContactoProfesionalSalud + " ]";
    }
    
}
