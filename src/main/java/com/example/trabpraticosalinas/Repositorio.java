package com.example.trabpraticosalinas;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Repositorio implements Serializable {
    private static Repositorio repo = null;

    private Map<String, Cliente> clientesMap = new HashMap<>();  // Mapa de <Número Fiscal, Cliente>
    private Map<String, gestorProducao> gestoresProducaoMap = new HashMap<>();  // Mapa de <Username, GestorProducao>
    private Map<String, gestorVendas> gestoresVendasMap = new HashMap<>();  // Mapa de <Username, GestorVendas>
    private Map<String, Admin> adminsMap = new HashMap<>();  // Mapa de <Username, Admin>

    private Map<String, Tanque> tanquesMap = new HashMap<>();  // Mapa de <ID, Tanque>
    private Map<String, loteFabrico> lotesFabricoMap = new HashMap<>();  // Mapa de <ID, LoteFabrico>
    private Map<String, produtoFinal> produtosFinaisMap = new HashMap<>();  // Mapa de <ID, ProdutoFinal>
    private Map<String, Encomenda> encomendasMap = new HashMap<>();  // Mapa de <ID, Encomenda>
    private Map<String, Marnoto> marnotosMap = new HashMap<>();  // Mapa de <ID, Marnoto>

    private transient ReentrantLock lock = new ReentrantLock();

    public Repositorio (){}

    public void lock() {
        lock.lock();
    }

    public void unlock() {
        lock.unlock();
    }

    public static Repositorio getRepo() {
        return repo;
    }

    public Map<String, Cliente> getClientesMap() {
        return clientesMap;
    }

    public Map<String, gestorProducao> getGestoresProducaoMap() {
        return gestoresProducaoMap;
    }

    public Map<String, gestorVendas> getGestoresVendasMap() {
        return gestoresVendasMap;
    }

    public Map<String, Admin> getAdminsMap() {
        return adminsMap;
    }

    public Map<String, Tanque> getTanquesMap() {
        return tanquesMap;
    }

    public Map<String, loteFabrico> getLotesFabricoMap() {
        return lotesFabricoMap;
    }

    public Map<String, produtoFinal> getProdutosFinaisMap() {
        return produtosFinaisMap;
    }

    public Map<String, Encomenda> getEncomendasMap() {
        return encomendasMap;
    }

    public Map<String, Marnoto> getMarnotosMap() {
        return marnotosMap;
    }

    public static Repositorio getRepositorio(){

        ReentrantLock lock = new ReentrantLock();

        lock.lock();
        if (repo == null)
            repo = new Repositorio();
        lock.unlock();

        return repo;
    }

    public void serialize(String filename) {
        // Serialize an object to file
        try{
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);
        }catch(IOException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void deserialize(String filename) {
        try{
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            repo = (Repositorio) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Serialized data is loaded from " + filename);
        }
        catch(IOException ex){
            System.out.println("ErrorDeserialize: " + ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Repositorio class not found. " + ex.getMessage());
        }
    }

}