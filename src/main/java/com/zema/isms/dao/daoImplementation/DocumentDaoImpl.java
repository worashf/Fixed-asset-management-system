/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.DocumentDao;
import com.zema.isms.domain.Document;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ewawuye
 */
@Repository
public class DocumentDaoImpl implements DocumentDao{
@Autowired
   private SessionFactory sessionFactory;
    @Override
    public void saveDocumenet(Document doc) {
     sessionFactory.getCurrentSession().save(doc);
    }

    @Override
    public Document findByDocumentId(String documentId) {
    Document doc =     sessionFactory.getCurrentSession().get(Document.class, documentId);
    return doc;
    }

    @Override
    public List<Document> findDocByWarrantyId(String warrantyId) {
        String hql  = "FROM Warranty a LEFT JOIN FETCH a.documents WHERE a.warrantyId=:warrantyId";
        Query<Document> query = sessionFactory.getCurrentSession().createQuery(hql,Document.class);
        query.setParameter("warrantyId", warrantyId);
        List<Document>  documents = query.getResultList();
        return documents;
    }

    @Override
    public void deleteDocById(String docId) {
        Document doc =     sessionFactory.getCurrentSession().get(Document.class, docId);
        sessionFactory.getCurrentSession().delete(doc);
    }
    
}
