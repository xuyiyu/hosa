
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.UserFavoriteRelationDO;
import com.hosa.repository.model.UserFavoriteRelation;

import java.util.ArrayList;
import java.util.List;


public class UserFavoriteRelationRepositoryConverter {

    public static UserFavoriteRelationDO convert2UserFavoriteRelationDO(UserFavoriteRelation source) {
        UserFavoriteRelationDO target = new UserFavoriteRelationDO();
    
        target.setUserId(source.getUserId());
        target.setFavoriteId(source.getFavoriteId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<UserFavoriteRelationDO> convert2UserFavoriteRelationDOList(Iterable<UserFavoriteRelation> list) {
        List<UserFavoriteRelationDO> results = new ArrayList();
        for(UserFavoriteRelation source : list) {
            results.add(convert2UserFavoriteRelationDO(source));
        }
        return results;
    }

    
    public static UserFavoriteRelation convert2UserFavoriteRelation(UserFavoriteRelationDO source) {
        UserFavoriteRelation target = new UserFavoriteRelation();
    
        target.setUserId(source.getUserId());
        target.setFavoriteId(source.getFavoriteId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<UserFavoriteRelation> convert2UserFavoriteRelationList(Iterable<UserFavoriteRelationDO> list) {
        List<UserFavoriteRelation> results = new ArrayList();
        for(UserFavoriteRelationDO source : list) {
            results.add(convert2UserFavoriteRelation(source));
        }
        return results;
    }

    
    
}
        
