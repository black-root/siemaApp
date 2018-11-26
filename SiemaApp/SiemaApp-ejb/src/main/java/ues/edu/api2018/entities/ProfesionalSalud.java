/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.edu.api2018.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "profesional_salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesionalSalud.findAll", query = "SELECT p FROM ProfesionalSalud p")
    , @NamedQuery(name = "ProfesionalSalud.findByIdProfesionalSalud", query = "SELECT p FROM ProfesionalSalud p WHERE p.idProfesionalSalud = :idProfesionalSalud")
    , @NamedQuery(name = "ProfesionalSalud.findByNombres", query = "SELECT p FROM ProfesionalSalud p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "ProfesionalSalud.findByApellidos", query = "SELECT p FROM ProfesionalSalud p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "ProfesionalSalud.findByDui", query = "SELECT p FROM ProfesionalSalud p WHERE p.dui = :dui")
    , @NamedQuery(name = "ProfesionalSalud.findByNit", query = "SELECT p FROM ProfesionalSalud p WHERE p.nit = :nit")
    , @NamedQuery(name = "ProfesionalSalud.findByFechaNacimiento", query = "SELECT p FROM ProfesionalSalud p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "ProfesionalSalud.findByTipoSangre", query = "SELECT p FROM ProfesionalSalud p WHERE p.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "ProfesionalSalud.findByDireccionRegistrada", query = "SELECT p FROM ProfesionalSalud p WHERE p.direccionRegistrada = :direccionRegistrada")
    , @NamedQuery(name = "ProfesionalSalud.findByGenero", query = "SELECT p FROM ProfesionalSalud p WHERE p.genero = :genero")
    , @NamedQuery(name = "ProfesionalSalud.findByUsuario", query = "SELECT p FROM ProfesionalSalud p WHERE p.usuario = :usuario")
    , @NamedQuery(name = "ProfesionalSalud.findByPassword", query = "SELECT p FROM ProfesionalSalud p WHERE p.password = :password")})
public class ProfesionalSalud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profesional_salud")
    private Integer idProfesionalSalud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "dui")
    private String dui;
    @Size(max = 17)
    @Column(name = "nit")
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_sangre")
    private String tipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion_registrada")
    private String direccionRegistrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesionalSalud", fetch = FetchType.LAZY)
    private List<Receta> recetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesionalSalud", fetch = FetchType.LAZY)
    private List<EspecialidadPorProfesional> especialidadPorProfesionalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesionalSalud", fetch = FetchType.LAZY)
    private List<ContactoProfesionalSalud> contactoProfesionalSaludList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesionalSalud", fetch = FetchType.LAZY)
    private List<HistoriaClinica> historiaClinicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesionalSalud", fetch = FetchType.LAZY)
    private List<Cita> citaList;

    public ProfesionalSalud() {
    }

    public ProfesionalSalud(Integer idProfesionalSalud) {
        this.idProfesionalSalud = idProfesionalSalud;
    }

    public ProfesionalSalud(Integer idProfesionalSalud, String nombres, String apellidos, String dui, Date fechaNacimiento, String tipoSangre, String direccionRegistrada, String genero, String usuario, String password) {
        this.idProfesionalSalud = idProfesionalSalud;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dui = dui;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.direccionRegistrada = direccionRegistrada;
        this.genero = genero;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdProfesionalSalud() {
        return idProfesionalSalud;
    }

    public void setIdProfesionalSalud(Integer idProfesionalSalud) {
        this.idProfesionalSalud = idProfesionalSalud;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getDireccionRegistrada() {
        return direccionRegistrada;
    }

    public void setDireccionRegistrada(String direccionRegistrada) {
        this.direccionRegistrada = direccionRegistrada;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonbTransient
    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
    }

    @JsonbTransient
    @XmlTransient
    public List<EspecialidadPorProfesional> getEspecialidadPorProfesionalList() {
        return especialidadPorProfesionalList;
    }

    public void setEspecialidadPorProfesionalList(List<EspecialidadPorProfesional> especialidadPorProfesionalList) {
        this.especialidadPorProfesionalList = especialidadPorProfesionalList;
    }

    @JsonbTransient
    @XmlTransient
    public List<ContactoProfesionalSalud> getContactoProfesionalSaludList() {
        return contactoProfesionalSaludList;
    }

    public void setContactoProfesionalSaludList(List<ContactoProfesionalSalud> contactoProfesionalSaludList) {
        this.contactoProfesionalSaludList = contactoProfesionalSaludList;
    }

    @JsonbTransient
    @XmlTransient
    public List<HistoriaClinica> getHistoriaClinicaList() {
        return historiaClinicaList;
    }

    public void setHistoriaClinicaList(List<HistoriaClinica> historiaClinicaList) {
        this.historiaClinicaList = historiaClinicaList;
    }

    @JsonbTransient
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
        hash += (idProfesionalSalud != null ? idProfesionalSalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesionalSalud)) {
            return false;
        }
        ProfesionalSalud other = (ProfesionalSalud) object;
        if ((this.idProfesionalSalud == null && other.idProfesionalSalud != null) || (this.idProfesionalSalud != null && !this.idProfesionalSalud.equals(other.idProfesionalSalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.ProfesionalSalud[ idProfesionalSalud=" + idProfesionalSalud + " ]";
    }

}
