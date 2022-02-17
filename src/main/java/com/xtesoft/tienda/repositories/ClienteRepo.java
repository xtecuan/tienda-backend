package com.xtesoft.tienda.repositories;

import com.xtesoft.tienda.entities.Cliente;
import io.agroal.api.AgroalDataSource;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@ApplicationScoped
public class ClienteRepo implements PanacheRepositoryBase<Cliente,Long> {

    @ConfigProperty(name = "query.hash")
    String queryHash;

    @Inject
    AgroalDataSource dataSource;
    @Inject
    Logger log;

    public Cliente findByEmailAndPass(String correoe, String clave) {
        Cliente cliente = null;

        List<Cliente> clientes = getEntityManager()
                .createNamedQuery("Cliente.findByCorreoeAndClave")
                .setParameter("correoe", correoe)
                .setParameter("clave", getMyHashFromPostgresql(clave))
                .getResultList();

        if (clientes != null && !clientes.isEmpty()) {
            cliente = clientes.get(0);
        }
        return cliente;
    }

    public String getMyHashFromPostgresql(String plainPassword) {
        String result = null;
        try (Connection connection = dataSource.getConnection()) {
            String hash = queryHash;
            PreparedStatement psta = connection.prepareStatement(hash);
            psta.setString(1, plainPassword);
            ResultSet rset = psta.executeQuery();
            while (rset.next()) {
                result = rset.getString(1);
            }
            rset.close();
            connection.close();
        } catch (Exception ex) {
            log.error("Error in getMyHashFromPostgresql: ", ex);
        }

        return result;
    }
}
