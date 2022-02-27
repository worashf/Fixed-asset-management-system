package com.zema.isms.dao;

import com.zema.isms.domain.AssetHistory;
import com.zema.isms.domain.AssignedAsset;

import java.util.List;

/**
 * Created by uppert on 10/21/2019.
 */
public interface AssetHistoryDao {
    public void saveAssetHistory (AssetHistory ah);

    public void updateAssetHistory (AssetHistory ah);

    public void deleteAssetHistory (AssetHistory ah);
    public AssetHistory getAssetHistoryById(String id);
    public List<AssetHistory> getAllAssetHistory(String assetCode,Integer pageNo, Integer histroyperpage);
    // count
    public Integer getAssetHistoryCount();
    public Integer getAssetHistoryCountByAssetCode(String assetCode);
    public  Integer getAssetHistoryPageCount(Integer assetHistoyPerPage);
    public  List<AssetHistory> getAllAssetHistory(Integer pageNo, Integer histroyperpage);
    public  int getAssetHistoryCountByCategory(String categoryId);
    public  List<AssetHistory> getAllAssetHistoryByCatagory(String categoryId,Integer pageNo,Integer resultPerPage);



}
