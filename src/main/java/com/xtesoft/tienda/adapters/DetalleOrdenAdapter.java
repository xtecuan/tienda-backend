package com.xtesoft.tienda.adapters;

import com.xtesoft.tienda.dtos.DetalleOrdenDTO;
import com.xtesoft.tienda.dtos.OrdenDTO;
import com.xtesoft.tienda.dtos.ProductoDTO;
import com.xtesoft.tienda.entities.DetalleOrden;
import com.xtesoft.tienda.entities.Orden;
import com.xtesoft.tienda.entities.Producto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DetalleOrdenAdapter implements JsonbAdapter<List<DetalleOrden>,List<DetalleOrdenDTO>> {
    @Inject
    EntityManager em;

    @Override
    public List<DetalleOrdenDTO> adaptToJson(List<DetalleOrden> list) {
        List<DetalleOrdenDTO> dtos = new ArrayList<>();
        list.stream().forEach(d->{
            DetalleOrdenDTO dto = new DetalleOrdenDTO();
            dto.setId(d.getId());
            dto.setIdProducto(new ProductoDTO(d.getIdProducto().getId()));
            dto.setCantidad(d.getCantidad());
            dto.setIdOrden(new OrdenDTO(d.getIdOrden().getId()));
            dtos.add(dto);
        });
        return dtos;
    }

    @Override
    public List<DetalleOrden> adaptFromJson(List<DetalleOrdenDTO> list) {
        List<DetalleOrden> entities = new ArrayList<>();
        list.stream().forEach(dto->{
            DetalleOrden e = new DetalleOrden();
            e.setCantidad(dto.getCantidad());
            e.setIdProducto(em.find(Producto.class,dto.getIdProducto().getId()));
            if(dto.getId()!=null){
                e.setId(dto.getId());
            }
            if(dto.getIdOrden()!=null && dto.getIdOrden().getId()!=null){
                e.setIdOrden(em.find(Orden.class,dto.getIdOrden().getId()));
            }
            entities.add(e);
        });
        return entities;
    }


}
