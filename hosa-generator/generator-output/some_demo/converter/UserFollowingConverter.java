
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.UserFollowingDO;
import com.hosa.repository.model.UserFollowing;

import java.util.ArrayList;
import java.util.List;


public class UserFollowingRepositoryConverter {

    public static UserFollowingDO convert2UserFollowingDO(UserFollowing source) {
        UserFollowingDO target = new UserFollowingDO();
    
        target.setUserId(source.getUserId());
        target.setFollowerUserId(source.getFollowerUserId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<UserFollowingDO> convert2UserFollowingDOList(Iterable<UserFollowing> list) {
        List<UserFollowingDO> results = new ArrayList();
        for(UserFollowing source : list) {
            results.add(convert2UserFollowingDO(source));
        }
        return results;
    }

    
    public static UserFollowing convert2UserFollowing(UserFollowingDO source) {
        UserFollowing target = new UserFollowing();
    
        target.setUserId(source.getUserId());
        target.setFollowerUserId(source.getFollowerUserId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<UserFollowing> convert2UserFollowingList(Iterable<UserFollowingDO> list) {
        List<UserFollowing> results = new ArrayList();
        for(UserFollowingDO source : list) {
            results.add(convert2UserFollowing(source));
        }
        return results;
    }

    
    
}
        
