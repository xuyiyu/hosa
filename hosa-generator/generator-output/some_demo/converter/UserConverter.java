
package com.hosa.repository.converter;

import com.hosa.dal.dataobject.UserDO;
import com.hosa.repository.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepositoryConverter {

    public static UserDO convert2UserDO(User source) {
        UserDO target = new UserDO();
    
        target.setNick(source.getNick());
        target.setPortraitUrl(source.getPortraitUrl());
        target.setFollower(source.getFollower());
        target.setUserFollowing(source.getUserFollowing());
        target.setLocationFollowing(source.getLocationFollowing());
        target.setBriefDescription(source.getBriefDescription());
        target.setImageCnt(source.getImageCnt());
        target.setPraisingCnt(source.getPraisingCnt());
        target.setPraisedCnt(source.getPraisedCnt());
        target.setNotifiyCnt(source.getNotifiyCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<UserDO> convert2UserDOList(Iterable<User> list) {
        List<UserDO> results = new ArrayList();
        for(User source : list) {
            results.add(convert2UserDO(source));
        }
        return results;
    }

    
    public static User convert2User(UserDO source) {
        User target = new User();
    
        target.setNick(source.getNick());
        target.setPortraitUrl(source.getPortraitUrl());
        target.setFollower(source.getFollower());
        target.setUserFollowing(source.getUserFollowing());
        target.setLocationFollowing(source.getLocationFollowing());
        target.setBriefDescription(source.getBriefDescription());
        target.setImageCnt(source.getImageCnt());
        target.setPraisingCnt(source.getPraisingCnt());
        target.setPraisedCnt(source.getPraisedCnt());
        target.setNotifiyCnt(source.getNotifiyCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<User> convert2UserList(Iterable<UserDO> list) {
        List<User> results = new ArrayList();
        for(UserDO source : list) {
            results.add(convert2User(source));
        }
        return results;
    }

    
    
}
        
