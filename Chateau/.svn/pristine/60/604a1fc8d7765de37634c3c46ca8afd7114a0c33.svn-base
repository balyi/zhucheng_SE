package com.chateau.service.impl;

import com.chateau.mapper.WineMapper;
import com.chateau.pojo.Wine;
import com.chateau.service.WineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Created by tedu on 2017/11/25.
 */

@Service
public class WineServiceImpl implements WineService {
    @Autowired
    private WineMapper wineMapper;

    @Override
    public Wine findInfoById(String wineId) {
        return wineMapper.findInfoById(wineId);
    }

    @Override
    public List<Wine> findAll() {
        return wineMapper.findAll();
    }

    @Override
    public void saveWine(Wine wine) {
        String wineId= UUID.randomUUID().toString();
        wine.setWineId(wineId);
        wineMapper.saveWine(wine);

    }

    @Override
    public void deleteWineById(String[] wineId) {
        System.out.println(Arrays.toString(wineId));
        wineMapper.deleteWineById(wineId);
    }

    @Override
    public Wine findOne(String wineId) {
        return wineMapper.findOne(wineId);
    }

    @Override
    public void updateWine(Wine wine) {
        wineMapper.updateWine(wine);
    }
}
