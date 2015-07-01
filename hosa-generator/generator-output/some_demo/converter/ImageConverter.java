
package com.gaojiaoyuan.repository.converter;

import com.gaojiaoyuan.dal.dataobject.ImageDO;
import com.gaojiaoyuan.repository.model.Image;

import java.util.ArrayList;
import java.util.List;


public class ImageRepositoryConverter {

    public static ImageDO convert2ImageDO(Image source) {
        ImageDO target = new ImageDO();
    
        target.setBitmapWidth(source.getBitmapWidth());
        target.setBitmapHeight(source.getBitmapHeight());
        target.setOriginalUrl(source.getOriginalUrl());
        target.setCompressUrl(source.getCompressUrl());
        target.setLocationName(source.getLocationName());
        target.setLongitude(source.getLongitude());
        target.setLatitude(source.getLatitude());
        target.setContent(source.getContent());
        target.setUserId(source.getUserId());
        target.setFavoritedCnt(source.getFavoritedCnt());
        target.setCommentCnt(source.getCommentCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<ImageDO> convert2ImageDOList(Iterable<Image> list) {
        List<ImageDO> results = new ArrayList();
        for(Image source : list) {
            results.add(convert2ImageDO(source));
        }
        return results;
    }

    
    public static Image convert2Image(ImageDO source) {
        Image target = new Image();
    
        target.setBitmapWidth(source.getBitmapWidth());
        target.setBitmapHeight(source.getBitmapHeight());
        target.setOriginalUrl(source.getOriginalUrl());
        target.setCompressUrl(source.getCompressUrl());
        target.setLocationName(source.getLocationName());
        target.setLongitude(source.getLongitude());
        target.setLatitude(source.getLatitude());
        target.setContent(source.getContent());
        target.setUserId(source.getUserId());
        target.setFavoritedCnt(source.getFavoritedCnt());
        target.setCommentCnt(source.getCommentCnt());
        target.setCreatedAt(source.getCreatedAt());
        
        return target;
    }

    public static List<Image> convert2ImageList(Iterable<ImageDO> list) {
        List<Image> results = new ArrayList();
        for(ImageDO source : list) {
            results.add(convert2Image(source));
        }
        return results;
    }

    
    
}
        
