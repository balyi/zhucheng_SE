package cn.tedu.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T> {
	//��rs�е�����->T t  ����  List<T> list
	T handle(ResultSet rs) throws SQLException; 
}
