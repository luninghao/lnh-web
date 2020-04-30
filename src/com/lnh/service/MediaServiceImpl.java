package com.lnh.service;

import com.lnh.dao.MediaDao;

/**
 * @author 70888
 */
public class MediaServiceImpl implements MediaService {

    private MediaDao mediaDao;

    public MediaDao getMediaDao() {
        return mediaDao;
    }

    public void setMediaDao(MediaDao mediaDao) {
        this.mediaDao = mediaDao;
    }

    @Override
    public boolean executeCodecs(String srcFilePath, String codcFilePath,
                                 String mediaPicPath) {
        return mediaDao.executeCodecs(srcFilePath, codcFilePath, mediaPicPath);
    }

}
