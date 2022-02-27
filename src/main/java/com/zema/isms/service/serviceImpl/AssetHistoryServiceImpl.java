package com.zema.isms.service.serviceImpl;

import com.zema.isms.dao.AssetDao;
import com.zema.isms.dao.AssetHistoryDao;
import com.zema.isms.dao.EmployeeDao;
import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssetHistory;
import com.zema.isms.domain.Employee;
import com.zema.isms.service.AssetHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by uppert on 10/21/2019.
 */
@Service
public class AssetHistoryServiceImpl implements AssetHistoryService {
    @Autowired
    private AssetHistoryDao assetHistoryDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private AssetDao assetDao;
    @Transactional
    @Override
    public void registerAssetHisstory(String assetId, String employeeId, AssetHistory ah) {
        Employee employee = employeeDao.findByEmployeeId(employeeId);
        Asset asset =assetDao.findByAssetId(assetId);
        ah.setAsset(asset);
        ah.setEmployee(employee);
        employee.getEmphistory().add(ah);
        asset.getAssetHistorys().add(ah);
        assetHistoryDao.saveAssetHistory(ah);
    }

    @Override
    public void editAssetHistory(AssetHistory ah) {

    }

    @Override
    public void removeAssetHistroy(String historyId) {

    }

    @Override
    public AssetHistory searchByAssetHistoryId(String historyId) {
        return null;
    }

    @Transactional
    @Override
    public List<AssetHistory> getAssetHistoryList(String assetCode ,Integer pageNo, Integer resultPerPage) {
        List<AssetHistory> assetHistorylist =null;
       try {
           assetHistorylist = assetHistoryDao.getAllAssetHistory(assetCode,pageNo,resultPerPage);
        }
        catch (NoResultException ex){

        }
        return  assetHistorylist;
    }
    @Transactional
    @Override
    public int searchAssetHistoryCount() {
        int count = 0;
        try{
         count =assetHistoryDao.getAssetHistoryCount();
        }catch (NoResultException ex){

        }

        return count;
    }
    @Transactional
    @Override
    public List<AssetHistory> retriveAssetHistorys(Integer pageNo, Integer resultPerPage) {

        List<AssetHistory> assetHistorys=null;
        try{
         assetHistorys=assetHistoryDao.getAllAssetHistory(pageNo,resultPerPage);
        }
        catch   (NoResultException ex){

        }

        return assetHistorys;
    }
    @Transactional
    @Override
    public int searchAssetHistoryPerPage(Integer assetHistoryPerPage) {
        int AssetHistoryCount = 0;
        int AssetHistoryPagesCount = 1;
        AssetHistoryCount = this.searchAssetHistoryCount();
        AssetHistoryPagesCount= (int) Math.floorDiv(AssetHistoryCount,  assetHistoryPerPage) + 1;

        return AssetHistoryPagesCount;
    }
// get asset history count by category
@Transactional
@Override
    public int searchAssetHistoryCountByCategory(String categoryId) {
        int count = 0;
        try{
            count =assetHistoryDao.getAssetHistoryCountByCategory(categoryId);
        }
        catch (NoResultException ex){
           count =0;
        }
        return count;
    }
    @Transactional
    @Override
    public List<AssetHistory> retriveAssetHistoryByCategory(String categoryId, Integer pageNo, Integer resultPerPage) {
        List<AssetHistory> assetHistorys=null;
        try{
            assetHistorys=assetHistoryDao.getAllAssetHistoryByCatagory(categoryId,pageNo,resultPerPage);
        }
        catch   (NoResultException ex){
            assetHistorys = null;
        }

        return assetHistorys;
    }
    @Transactional
    @Override
    public int searchAssetHistoryPerPageByCategory(String categoryId, Integer resultsPerPage) {
        int AssetHistoryCount = 0;
        int AssetHistoryPagesCount = 1;
        AssetHistoryCount = this.searchAssetHistoryCountByCategory(categoryId);
        AssetHistoryPagesCount= (int) Math.floorDiv(AssetHistoryCount,  resultsPerPage) + 1;

        return AssetHistoryPagesCount;
    }
    @Transactional
    @Override
    public int retriveAssetHistoryCountByAssetCode(String assetCode) {
        int count = 0;
        try{
            count =assetHistoryDao.getAssetHistoryCountByAssetCode(assetCode);
        }
        catch (NoResultException ex){
            count =0;
        }
        return count;
    }
    @Transactional
    @Override
    public int getAssetHistoryPageCountByAssetCode(String assetCode, Integer resultperPage) {
        int AssetHistoryCount = 0;
        int AssetHistoryPagesCount = 1;
        AssetHistoryCount = this.retriveAssetHistoryCountByAssetCode(assetCode);
        AssetHistoryPagesCount= (int) Math.floorDiv(AssetHistoryCount,  resultperPage) + 1;

        return AssetHistoryPagesCount;
    }
}







