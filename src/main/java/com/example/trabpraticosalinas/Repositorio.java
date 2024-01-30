package com.example.trabpraticosalinas;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class Repositorio implements Serializable {
    private static Repositorio repo = null;

    private Map<String, Cliente> clientesMap = new HashMap<>();  // Mapa de <Número Fiscal, Cliente>
    private Map<String, GestorProducao> gestoresProducaoMap = new HashMap<>();  // Mapa de <Username, GestorProducao>
    private Map<String, GestorVendas> gestoresVendasMap = new HashMap<>();  // Mapa de <Username, GestorVendas>
    private Map<String, Admin> adminsMap = new HashMap<>();  // Mapa de <Username, Admin>

    private Map<String, Tanque> tanquesMap = new HashMap<>();  // Mapa de <ID, Tanque>
    private Map<String, LoteFabrico> lotesFabricoMap = new HashMap<>();  // Mapa de <ID, LoteFabrico>
    private Map<String, ProdutoFinal> produtosFinaisMap = new HashMap<>();  // Mapa de <ID, ProdutoFinal>
    private Map<String, Encomenda> encomendasMap = new HashMap<>();  // Mapa de <ID, Encomenda>
    private Map<String, Marnoto> marnotosMap = new HashMap<>();  // Mapa de <ID, Marnoto>



    public Repositorio (){};

    public Map<String, Customer> getCustomers() {
        return customersMap;
    }
    public Map<String, CompanyOwner> getCompanyOwners() {
        return companyOwnersMap;
    }
    public Map<CompanyOwner, List<Company>> getCompanyFromCompanyOwner() {
        return companiesMap;
    }
    public Map<String, Company> getCompany() {
        return companiesMapNIF;
    }
    public Map<String, Company> getCompaniesLocation(){
        return companiesLocation;
    }
    public Map<String, Admin> getAdmins() {return adminsMap;}
    public Map<String, Employee> getEmployees() {return employeesMap;}
    public Map<String, Service> getServices() {return services;}
    public Map<Clinic, List<Service>> getServicesClinicMap(){return servicesClinicMap;}
    public Map<String, List<Appointment>> getAppointments(){return appointmentsMap;}
    public Map<Company, List<Clinic>> getCompanieClinicsMap(){return CompanieClinicsMap;}
    public Map<String, Clinic> getClinicsMap(){return clinicsMap;}
    public Map<Clinic, List<Employee>> getEmployeesClinicMap(){return employeesClinicMap;}
    public Map<String, List<Clinic>> getClinicsPerCompanyOwner(){return clinicsPerCompanyOner;}

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