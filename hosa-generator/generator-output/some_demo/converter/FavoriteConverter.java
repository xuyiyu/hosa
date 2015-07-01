
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.FavoriteDO;
import com.hosa.repository.model.Favorite;

import java.util.ArrayList;
import java.util.List;


public class FavoriteRepositoryConverter {

    public static FavoriteDO convert2FavoriteDO(Favorite source) {
        FavoriteDO target = new FavoriteDO();
    
        target.setName(source.getName());
        target.setFavoriteCnt(source.getFavoriteCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<FavoriteDO> convert2FavoriteDOList(Iterable<Favorite> list) {
        List<FavoriteDO> results = new ArrayList();
        for(Favorite source : list) {
            results.add(convert2FavoriteDO(source));
        }
        return results;
    }

    
    public static Favorite convert2Favorite(FavoriteDO source) {
        Favorite target = new Favorite();
    
        target.setName(source.getName());
        target.setFavoriteCnt(source.getFavoriteCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<Favorite> convert2FavoriteList(Iterable<FavoriteDO> list) {
        List<Favorite> results = new ArrayList();
        for(FavoriteDO source : list) {
            results.add(convert2Favorite(source));
        }
        return results;
    }

    
    
}
        
