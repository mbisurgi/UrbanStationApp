package com.enjoyurbanstation.urbanstationapp.controller;

import com.enjoyurbanstation.urbanstationapp.dao.ClienteDao;
import com.enjoyurbanstation.urbanstationapp.model.Cliente;

public class AppPrepagas {
    private static AppPrepagas instancia = null;

    private Cliente clienteLogueado;

    private AppPrepagas() {

    }

    public static AppPrepagas getInstancia() {
        if (instancia == null) {
            instancia = new AppPrepagas();
        }

        return instancia;
    }

    private boolean login(String email, String password) {
        Cliente cli = ClienteDao.getInstancia().getCliente(email, password);

        if (cli != null) {
            clienteLogueado = cli;
            return true;
        }

        return false;
    }

    public Cliente getClienteLogueado() {
        return clienteLogueado;
    }
}
