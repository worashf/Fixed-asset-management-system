/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.DocumentDao;
import com.zema.isms.dao.WarrantyDao;
import com.zema.isms.domain.Document;
import com.zema.isms.domain.FileBucket;
import com.zema.isms.domain.waranty.Warranty;
import com.zema.isms.service.DocumentService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ewawuye
 */
@Service
public class DocumentServiceImpl implements DocumentService{
    @Autowired
private DocumentDao docdao;
        @Autowired
private WarrantyDao warrantydao;
    @Override
    @Transactional
    public void addDocumenet(FileBucket fileBucket, String warrantyId) throws IOException{
        Document document = new  Document();
        
        Warranty warranty = warrantydao.findByWarrantyId(warrantyId);
        MultipartFile multipartFile =fileBucket.getFile();
        document.setName(multipartFile.getOriginalFilename());
        document.setDescrifeption(fileBucket.getDescription());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());
        document.setWarranty(warranty);
         docdao.saveDocumenet(document);
    }
 @Transactional
    @Override
    public Document searchByDocumentId(String docId) {
        return docdao.findByDocumentId(docId);
    }
 @Transactional
    @Override
    public List<Document> searchDocByWarrantyId(String warrantyId) {
        return docdao.findDocByWarrantyId(warrantyId);
    }
 @Transactional
    @Override
    public void removeDocById(String docId) {
     docdao.deleteDocById(docId);
    }
    
}
