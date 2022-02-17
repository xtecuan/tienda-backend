package com.xtesoft.tienda.entities;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
@NamedQueries({
        @NamedQuery(name = "Cliente.findByCorreoeAndClave", query = "SELECT c FROM Cliente c WHERE c.correoe = :correoe and c.clave = :clave ")
})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "correoe", nullable = false, length = 100)
    private String correoe;

    @Column(name = "clave", nullable = false, length = 100)
    private String clave;

    @Column(name = "rol", nullable = false, length = 25)
    private String rol;

    public String getCorreoe() {
        return correoe;
    }

    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
