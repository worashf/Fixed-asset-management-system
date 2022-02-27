/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.service;

import com.zema.isms.domain.Document;
import com.zema.isms.domain.FileBucket;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ewawuye
 */
public interface DocumentService {
    public void addDocumenet(FileBucket fileBucket, String warrantyId) throws IOException;
    public Document searchByDocumentId(String docId);
    public List<Document>  searchDocByWarrantyId(String warrantyId);
    public void removeDocById(String docId);
}
