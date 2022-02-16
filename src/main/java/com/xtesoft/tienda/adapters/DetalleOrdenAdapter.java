package com.xtesoft.tienda.adapters;

import com.xtesoft.tienda.entities.DetalleOrden;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;


public class DetalleOrdenAdapter implements JsonbAdapter<List<DetalleOrden>,List<Long>> {
    @Inject
    EntityManager em;

    @Override
    public List<Long> adaptToJson(List<DetalleOrden> list) {
        return list.stream().map(DetalleOrden::getId).collect(Collectors.toList());
    }

    @Override
    public List<DetalleOrden> adaptFromJson(List<Long> list) {
        final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        final CriteriaQuery<DetalleOrden> query = criteriaBuilder.createQuery(DetalleOrden.class);
        final Root<DetalleOrden> root = query.from(DetalleOrden.class);
        final CriteriaQuery<DetalleOrden> fullQuery = query.where(root.get("id").in(list));
        return em.createQuery(fullQuery).getResultList();
    }
}
