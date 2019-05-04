package com.chateau.service;

import com.chateau.pojo.Chateau;
import com.chateau.pojo.Wine;

import java.util.List;

/**
 * Created by Austin on 2017/11/26.
 */
public interface ChateauService {

    // 获得酒庄列表
    List<Chateau> findAllChateau();

    // 获取单个酒庄
    Chateau findOneChateau(String chateauId);

    // 获得酒单列表
    List<Wine> findChateauWine(String chateauId);

    void delete(String[] ids);

    void saveChateau(Chateau chateau);

    void updateChateau(Chateau chateau);
}
