package com.example.trabpraticosalinas;
public class SessionData {
    public static Admin loggedAdmin;
    public static Cliente loggedCliente;
    public static gestorProducao loggedgestorProducao;
    public static gestorVendas loggedgestorVendas;

    public static Admin getLoggedAdmin() {
        return loggedAdmin;
    }

    public static void setLoggedAdmin(Admin loggedAdmin) {
        SessionData.loggedAdmin = loggedAdmin;
    }

    public static Cliente getLoggedCliente() {
        return loggedCliente;
    }

    public static void setLoggedCliente(Cliente loggedCliente) {
        SessionData.loggedCliente = loggedCliente;
    }

    public static gestorProducao getLoggedgestorProducao() {
        return loggedgestorProducao;
    }

    public static void setLoggedgestorProducao(gestorProducao loggedgestorProducao) {
        SessionData.loggedgestorProducao = loggedgestorProducao;
    }

    public static gestorVendas getLoggedgestorVendas() {
        return loggedgestorVendas;
    }

    public static void setLoggedgestorVendas(gestorVendas loggedgestorVendas) {
        SessionData.loggedgestorVendas = loggedgestorVendas;
    }
}
