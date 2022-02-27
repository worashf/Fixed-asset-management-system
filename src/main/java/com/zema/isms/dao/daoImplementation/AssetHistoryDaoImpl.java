package com.zema.isms.dao.daoImplementation;

import com.zema.isms.dao.AssetHistoryDao;
import com.zema.isms.domain.Asset;
import com.zema.isms.domain.AssetHistory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by uppert on 10/21/2019.
 */
@Repository
public class AssetHistoryDaoImpl implements AssetHistoryDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveAssetHistory(AssetHistory ah) {
        sessionFactory.getCurrentSession().save(ah);
    }

    @Override
    public void updateAssetHistory(AssetHistory ah) {

    }

    @Override
    public void deleteAssetHistory(AssetHistory ah) {

    }

    @Override
    public AssetHistory getAssetHistoryById(String id) {
        return null;
    }

    @Override
    public List<AssetHistory> getAllAssetHistory(String assetCode,Integer pageNo, Integer histroyperpage) {
        List<AssetHistory> assetHistoy = null;
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql= "FROM AssetHistory ah  LEFT JOIN FETCH ah.employee e LEFT JOIN FETCH  ah.asset a LEFT JOIN FETCH a.catagory c LEFT JOIN FETCH e.department d WHERE a.assetCode=:assetCode";
            Query<AssetHistory> query =session.createQuery(hql,AssetHistory.class);
            query.setParameter("assetCode",assetCode);
            query.setFirstResult((pageNo-1)*histroyperpage);
            query.setMaxResults(histroyperpage);

            assetHistoy  =query.list();
        }
        catch(NoResultException ex ){

        }
        return assetHistoy ;
    }

    @Override
    public Integer getAssetHistoryCount() {
        Session session = sessionFactory.getCurrentSession();
       int count = 0;
       try{
           String hql = "FROM AssetHistory ah ";
           Query query = session.createQuery(hql);
           count= query.getResultList().size();

       }
       catch (NoResultException ex){

       }
        return count;
    }

    @Override
    public Integer getAssetHistoryCountByAssetCode(String assetCode) {
        Session session = sessionFactory.getCurrentSession();
        int count = 0;
        try{

            String hql = "FROM AssetHistory ah  LEFT JOIN FETCH ah.asset a  WHERE a.assetCode=:assetCode";
            Query query = session.createQuery(hql);
            query.setParameter("assetCode", assetCode);
            count= query.getResultList().size();

        }
        catch (NoResultException ex){

        }
        return count;
    }

    @Override
    public Integer getAssetHistoryPageCount(Integer assetHistoyPerPage) {

        return null;
    }

    @Override
    public List<AssetHistory> getAllAssetHistory(Integer pageNo, Integer histroyperpage) {
        List<AssetHistory> assetHistorys = null;
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM AssetHistory ah LEFT JOIN FETCH  ah.asset a LEFT JOIN FETCH ah.employee e LEFT JOIN FETCH " +
                    "a.catagory c LEFT JOIN FETCH e.department d  ";
            Query<AssetHistory> query = session.createQuery(hql,AssetHistory.class);
            query.setFirstResult((pageNo-1)*histroyperpage);
            query.setMaxResults(histroyperpage);
            assetHistorys =query.list();
        }
        catch (NoResultException ex){

        }
        return assetHistorys;
    }

    @Override
    public int getAssetHistoryCountByCategory(String categoryId) {
        Session session = sessionFactory.getCurrentSession();
        int count = 0;
        try{

            String hql = "FROM AssetHistory ah  LEFT JOIN FETCH ah.asset a LEFT JOIN FETCH a.catagory c WHERE c.catagoryId=:categoryId";
            Query query = session.createQuery(hql);
            query.setParameter("categoryId", categoryId);
            count= query.getResultList().size();

        }
        catch (NoResultException ex){

        }
        return count;

    }

    @Override
    public List<AssetHistory> getAllAssetHistoryByCatagory(String categoryId, Integer pageNo, Integer resultPerPage) {
        List<AssetHistory> assetHistorys = null;
        try{
            Session session = sessionFactory.getCurrentSession();
            String hql = "FROM AssetHistory ah LEFT JOIN FETCH  ah.asset a LEFT JOIN FETCH ah.employee e LEFT JOIN FETCH " +
                    "a.catagory c LEFT JOIN FETCH e.department d  WHERE c.catagoryId=:categoryId ";
            Query<AssetHistory> query = session.createQuery(hql,AssetHistory.class);
            query.setParameter("categoryId",categoryId);
            query.setFirstResult((pageNo-1)*resultPerPage);
            query.setMaxResults(resultPerPage);
            assetHistorys =query.list();
        }
        catch (NoResultException ex){
            assetHistorys = null;
        }
        return assetHistorys;
    }
}
