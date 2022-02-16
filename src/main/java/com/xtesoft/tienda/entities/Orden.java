package com.xtesoft.tienda.entities;

import com.xtesoft.tienda.adapters.DetalleOrdenAdapter;

import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;

    @JsonbTypeAdapter(DetalleOrdenAdapter.class)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idOrden", orphanRemoval = true)
    private List<DetalleOrden> detalleOrden;



    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DetalleOrden> getDetalleOrden() {
        return detalleOrden;
    }

    public void setDetalleOrden(List<DetalleOrden> detalleOrden) {
        this.detalleOrden = detalleOrden;
    }
}
