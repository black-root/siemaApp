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
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Paciente.findByNombres", query = "SELECT p FROM Paciente p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Paciente.findByApellidos", query = "SELECT p FROM Paciente p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Paciente.findByDui", query = "SELECT p FROM Paciente p WHERE p.dui = :dui")
    , @NamedQuery(name = "Paciente.findByNit", query = "SELECT p FROM Paciente p WHERE p.nit = :nit")
    , @NamedQuery(name = "Paciente.findByFechaNacimiento", query = "SELECT p FROM Paciente p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Paciente.findByTipoSangre", query = "SELECT p FROM Paciente p WHERE p.tipoSangre = :tipoSangre")
    , @NamedQuery(name = "Paciente.findByDireccionRegistrada", query = "SELECT p FROM Paciente p WHERE p.direccionRegistrada = :direccionRegistrada")
    , @NamedQuery(name = "Paciente.findByUbicacionGeografica", query = "SELECT p FROM Paciente p WHERE p.ubicacionGeografica = :ubicacionGeografica")
    , @NamedQuery(name = "Paciente.findByTelefono", query = "SELECT p FROM Paciente p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Paciente.findByGenero", query = "SELECT p FROM Paciente p WHERE p.genero = :genero")
    , @NamedQuery(name = "Paciente.findByAlergico", query = "SELECT p FROM Paciente p WHERE p.alergico = :alergico")
    , @NamedQuery(name = "Paciente.findByInformacionEmergencia", query = "SELECT p FROM Paciente p WHERE p.informacionEmergencia = :informacionEmergencia")
    , @NamedQuery(name = "Paciente.findByNacionalidad", query = "SELECT p FROM Paciente p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Paciente.findByEstadoCivil", query = "SELECT p FROM Paciente p WHERE p.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Paciente.findByOcupacion", query = "SELECT p FROM Paciente p WHERE p.ocupacion = :ocupacion")
    , @NamedQuery(name = "Paciente.findByReligion", query = "SELECT p FROM Paciente p WHERE p.religion = :religion")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Long idPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 10)
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
    @Size(min = 1, max = 25)
    @Column(name = "tipo_sangre")
    private String tipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion_registrada")
    private String direccionRegistrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 21)
    @Column(name = "ubicacion_geografica")
    private String ubicacionGeografica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "alergico")
    private String alergico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "informacion_emergencia")
    private String informacionEmergencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "religion")
    private String religion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<Receta> recetaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente", fetch = FetchType.LAZY)
    private List<ExpedienteClinico> expedienteClinicoList;

    public Paciente() {
    }

    public Paciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(Long idPaciente, String nombres, String apellidos, Date fechaNacimiento, String tipoSangre, String direccionRegistrada, String ubicacionGeografica, String telefono, String genero, String alergico, String informacionEmergencia, String nacionalidad, String estadoCivil, String ocupacion, String religion) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.direccionRegistrada = direccionRegistrada;
        this.ubicacionGeografica = ubicacionGeografica;
        this.telefono = telefono;
        this.genero = genero;
        this.alergico = alergico;
        this.informacionEmergencia = informacionEmergencia;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.ocupacion = ocupacion;
        this.religion = religion;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public String getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(String ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getInformacionEmergencia() {
        return informacionEmergencia;
    }

    public void setInformacionEmergencia(String informacionEmergencia) {
        this.informacionEmergencia = informacionEmergencia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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
    public List<ExpedienteClinico> getExpedienteClinicoList() {
        return expedienteClinicoList;
    }

    public void setExpedienteClinicoList(List<ExpedienteClinico> expedienteClinicoList) {
        this.expedienteClinicoList = expedienteClinicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ues.edu.api2018.Paciente[ idPaciente=" + idPaciente + " ]";
    }
    
}
