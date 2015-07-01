
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.FavoriteListDO;
import com.hosa.repository.model.FavoriteList;

import java.util.ArrayList;
import java.util.List;


public class FavoriteListRepositoryConverter {

    public static FavoriteListDO convert2FavoriteListDO(FavoriteList source) {
        FavoriteListDO target = new FavoriteListDO();
    
        target.setFavoriteListId(source.getFavoriteListId());
        target.setImageId(source.getImageId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<FavoriteListDO> convert2FavoriteListDOList(Iterable<FavoriteList> list) {
        List<FavoriteListDO> results = new ArrayList();
        for(FavoriteList source : list) {
            results.add(convert2FavoriteListDO(source));
        }
        return results;
    }

    
    public static FavoriteList convert2FavoriteList(FavoriteListDO source) {
        FavoriteList target = new FavoriteList();
    
        target.setFavoriteListId(source.getFavoriteListId());
        target.setImageId(source.getImageId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<FavoriteList> convert2FavoriteListList(Iterable<FavoriteListDO> list) {
        List<FavoriteList> results = new ArrayList();
        for(FavoriteListDO source : list) {
            results.add(convert2FavoriteList(source));
        }
        return results;
    }

    
    
}
        
