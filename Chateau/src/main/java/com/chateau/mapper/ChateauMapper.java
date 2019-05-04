package com.chateau.mapper;

import com.chateau.pojo.Chateau;
import com.chateau.pojo.Wine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;

/**
 * Created by Austin on 2017/11/26.
 */
public interface ChateauMapper {

    List<Chateau> findAllChateau();

    Chateau findOneChateau(String chateauId);

    List<Wine> findChateauWine(String chateauId);

    void delete(String[] ids);

    @Insert("INSERT INTO chateau (chateau_id,chateau_name,address,user_id,create_time,level,output,reserve_num,remark,area) values(#{chateauId},#{chateauName},#{address},${user.userId},#{createTime},#{level},#{output},#{reserveNum},#{remark},#{area})")
    void saveChateau(Chateau chateau);

    @Update("Update chateau set chateau_name=#{chateauName},address=#{address},user_id=${user.userId},create_time=#{createTime},level=#{level},output=#{output},reserve_num=#{reserveNum},remark=#{remark},area=#{area} where chateau_id=#{chateauId}")
    void updateChateau(Chateau chateau);

    @Update("update chateau set reserve_num=#{i} where chateau_id=#{chateauId}")
    void changeReservePnum(String chateauId, int i);
}
