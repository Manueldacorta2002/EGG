/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa1;

import Tablas.Empleados;
import Tablas.Fabricante;
import java.util.Collection;
import java.util.Scanner;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MegaTecnologia
 */
public class Jpa1 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
       Scanner leer = new Scanner(System.in); 
        try {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU"); // este objeto me permite hacer uso de las funciones que me conectan a la base de datos
            EntityManager em = emf.createEntityManager();
            
            try{ 
                
                Fabricante fabricante1 = new Fabricante();
                
               
                /*
                fabricante1.setNombre("Iphone");
                
                
                em.getTransaction().begin();//comenzamos una transaccion o accion
                em.persist(fabricante1);//le decimos que queremos guardar el vendedor 1
                em.getTransaction().commit();//lo guardamos*/
                
              /*  
               for( int i=0;i<=10;i++){ 
                 Empleados empleados1 = new Empleados();  
                 
                 System.out.println("Ingrese el nombre del empleado: ");
                 
                 String nombre = leer.next();
                 
                 empleados1.setNombre(nombre);
                 
                 em.getTransaction().begin();//comenzamos una transaccion o accion
                em.persist(empleados1);//le decimos que queremos guardar el vendedor 1
                em.getTransaction().commit();//lo guardamos
                
               }*/

            }catch(Exception e){
            throw e;
        }
            
            //Listo Fabricantes
        
        Collection<Fabricante> listasFabricantes = em.createQuery("SELECT f FROM Fabricante f").getResultList();  
        
        for(Fabricante aux : listasFabricantes){
            System.out.println("Nombre: "+ aux.getNombre());
        }
        
        Empleados Alfredo = (Empleados) em.createQuery("SELECT e FROM Empleados e WHERE e.nombre = 'Manuel'").getSingleResult();
        System.out.println("Su busqueda es: "+ Alfredo.getNombre());
        
        
            
        }catch(Exception e){
            throw e;
        }
        
       
        
        
    }
      
       
}
