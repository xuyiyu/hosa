
package com.gaojiaoyuan.repository.converter;

import com.gaojiaoyuan.dal.dataobject.LocationDO;
import com.gaojiaoyuan.repository.model.Location;

import java.util.ArrayList;
import java.util.List;


public class LocationRepositoryConverter {

    public static LocationDO convert2LocationDO(Location source) {
        LocationDO target = new LocationDO();
    
        target.setName(source.getName());
        target.setType(source.getType());
        target.setFollower(source.getFollower());
        target.setImageCnt(source.getImageCnt());
        target.setFavoritedCnt(source.getFavoritedCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<LocationDO> convert2LocationDOList(Iterable<Location> list) {
        List<LocationDO> results = new ArrayList();
        for(Location source : list) {
            results.add(convert2LocationDO(source));
        }
        return results;
    }

    
    public static Location convert2Location(LocationDO source) {
        Location target = new Location();
    
        target.setName(source.getName());
        target.setType(source.getType());
        target.setFollower(source.getFollower());
        target.setImageCnt(source.getImageCnt());
        target.setFavoritedCnt(source.getFavoritedCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<Location> convert2LocationList(Iterable<LocationDO> list) {
        List<Location> results = new ArrayList();
        for(LocationDO source : list) {
            results.add(convert2Location(source));
        }
        return results;
    }

    
    
}
        
