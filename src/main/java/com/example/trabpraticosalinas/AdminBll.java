package com.example.trabpraticosalinas;

import java.util.Map;

public class AdminBll {
    public static void registarAdmin(Admin admin) {
        Repositorio.getRepositorio().getAdminsMap().put(admin.getNIF(), admin);

        System.out.println("Admin criado com sucesso.");
        Repositorio.getRepositorio().serialize("info.repo");
    }
}
