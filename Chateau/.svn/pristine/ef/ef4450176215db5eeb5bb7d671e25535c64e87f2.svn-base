package com.chateau.service.impl;

import com.chateau.mapper.ChateauMapper;
import com.chateau.pojo.Chateau;
import com.chateau.pojo.Wine;
import com.chateau.service.ChateauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Austin on 2017/11/26.
 */
@Service
public class ChateauServiceImpl implements ChateauService {

    @Autowired
    private ChateauMapper chateauMapper;

    @Override
    public List<Chateau> findAllChateau() {
        return chateauMapper.findAllChateau();
    }

    @Override
    public Chateau findOneChateau(String chateauId){
        return chateauMapper.findOneChateau(chateauId);
    }

    @Override
    public List<Wine> findChateauWine(String chateauId) {
        return chateauMapper.findChateauWine(chateauId);
    }

    @Override
    public void delete(String[] ids) {
        chateauMapper.delete(ids);
    }

    @Override
    public void saveChateau(Chateau chateau) {
        String chateauId = UUID.randomUUID().toString();
        chateau.setChateauId(chateauId);
        chateauMapper.saveChateau(chateau);
    }

    @Override
    public void updateChateau(Chateau chateau) {
        chateauMapper.updateChateau(chateau);
    }

}
