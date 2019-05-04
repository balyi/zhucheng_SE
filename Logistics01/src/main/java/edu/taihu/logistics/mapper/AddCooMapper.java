package edu.taihu.logistics.mapper;

import org.apache.ibatis.annotations.Select;

public interface AddCooMapper {
	@Select("SELECT DISTINCT coordinate FROM add_coo WHERE address=#{add}")
	String addCoo(String add);
}
