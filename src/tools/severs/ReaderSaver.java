/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.severs;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author user
 */
public class ReaderSaver {
    private String fileName = "readers";
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTVR19LibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public void saveReaders(Reader[] readers) {
        tx.begin();
            for (int i = 0; i < readers.length; i++) {
                if(readers[i] != null && readers[i].getId()==null){
                    em.persist(readers[i]);
                    break;
                }else{
                    em.merge(readers[i]);
                }
            }
        tx.commit();
    }

    public List<Reader> loadFile() {
        try {
            return em.createQuery("SELECT book FROM Book book")
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Нет записей");
            return new ArrayList();
        }
        
    }
    
}
