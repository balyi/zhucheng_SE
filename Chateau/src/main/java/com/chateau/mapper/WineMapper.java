package com.chateau.mapper;

import com.chateau.pojo.Wine;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by tedu on 2017/11/25.
 */
public interface WineMapper {

    @Select("select * from wine where wine_id=#{wineId}")
    Wine findInfoById(String wineId);


    List<Wine> findAll();


    void changePnum(@Param("wineId") String wineId, @Param("pnum") int i);

    void saveWine(Wine wine);

    void deleteWineById(String[] wineId);

    Wine findOne(String wineId);

    @Update("UPDATE  wine SET chateau_id=#{chateau.chateauId},wine_name=#{wineName},year=#{year},pnum=#{pnum},price=#{price},area=#{area},alcohol=#{alcohol},type=#{type},time=#{time},remark=#{remark} WHERE  wine_id=#{wineId}")
    void updateWine(Wine wine);
}
