package com.enjoyurbanstation.urbanstationapp.dao;

import com.enjoyurbanstation.urbanstationapp.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
    private static ClienteDao instancia = null;

    private ClienteDao() {

    }

    public static ClienteDao getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDao();
        }

        return instancia;
    }

    public Cliente getCliente(String email, String password) {
        Cliente cli = new Cliente();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From Clientes Where email = ? And password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cli.setEmail(rs.getString("email"));
                cli.setPassword(rs.getString("password"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
            }
        } catch (SQLException ex) {

        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return cli;
    }
}
