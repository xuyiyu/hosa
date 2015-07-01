
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.LocationFollowingDO;
import com.hosa.repository.model.LocationFollowing;

import java.util.ArrayList;
import java.util.List;


public class LocationFollowingRepositoryConverter {

    public static LocationFollowingDO convert2LocationFollowingDO(LocationFollowing source) {
        LocationFollowingDO target = new LocationFollowingDO();
    
        target.setLocationId(source.getLocationId());
        target.setFollowerUserId(source.getFollowerUserId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<LocationFollowingDO> convert2LocationFollowingDOList(Iterable<LocationFollowing> list) {
        List<LocationFollowingDO> results = new ArrayList();
        for(LocationFollowing source : list) {
            results.add(convert2LocationFollowingDO(source));
        }
        return results;
    }

    
    public static LocationFollowing convert2LocationFollowing(LocationFollowingDO source) {
        LocationFollowing target = new LocationFollowing();
    
        target.setLocationId(source.getLocationId());
        target.setFollowerUserId(source.getFollowerUserId());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<LocationFollowing> convert2LocationFollowingList(Iterable<LocationFollowingDO> list) {
        List<LocationFollowing> results = new ArrayList();
        for(LocationFollowingDO source : list) {
            results.add(convert2LocationFollowing(source));
        }
        return results;
    }

    
    
}
        
