package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Hero;

public interface HeroMapper {

	@Select("select * from hero")
	public List<Hero> findAll();
}
