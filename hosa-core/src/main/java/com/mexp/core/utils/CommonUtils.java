package com.mexp.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonUtils {


	/**
	 * 下载文件到本地路径
	 * @param remoteFilePath
	 * @param localFilePath
	 */
	public static void downloadFile(String remoteFilePath, String localFilePath)
    {
		
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        Integer lastIndex = localFilePath.lastIndexOf("/");
        if(lastIndex != -1){
        	String path = localFilePath.substring(0, lastIndex);
        	File pathFile = new File(path);
        	if(!pathFile.isDirectory()){
        		pathFile.mkdirs();
        	}
        }
        File f = new File(localFilePath);
        
        try
        {
        	
        	
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
            {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                bis.close();
                bos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
