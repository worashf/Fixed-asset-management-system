package com.zema.isms.service;

import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssetHistory;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by uppert on 10/21/2019.
 */
public interface AssetHistoryService {
    /**
     *
     * @param a
     */
    public void registerAssetHisstory(String assetId,String employeeId, AssetHistory ah);

    /**
     *
     * @param a
     */
    public void editAssetHistory(AssetHistory ah);

    /**
     *
     * @param historyId
     */
    public void removeAssetHistroy(String historyId);

    /**
     *
     * @param historyId
     * @return
     */
    public AssetHistory searchByAssetHistoryId(String historyId);

    public List<AssetHistory> getAssetHistoryList(String assetCode ,Integer pageNo, Integer resultPerPage);
    public int searchAssetHistoryCount();
    public List<AssetHistory> retriveAssetHistorys(Integer pageNo, Integer resultPerPage);
    public  int searchAssetHistoryPerPage(Integer assetHistoryPerPage);
    // function for asset history
    public int searchAssetHistoryCountByCategory(String categoryId);
    public  List<AssetHistory> retriveAssetHistoryByCategory(String categoryId,Integer pageNo, Integer resultPerPage);
    public  int searchAssetHistoryPerPageByCategory(String categoryId, Integer resultsPerPage);
    public int   retriveAssetHistoryCountByAssetCode(String assetCode);
    public  int getAssetHistoryPageCountByAssetCode(String assetCode, Integer resultperPage);


}
