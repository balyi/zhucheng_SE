package cn.tarena.ht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.HeroMapper;
import cn.tarena.ht.pojo.Hero;
@Service
public class HeroServiceImple implements HeroService{

	@Autowired
	private HeroMapper heroMapper;
	
	@Override
	public List<Hero> findAll() {
		// TODO Auto-generated method stub
		return heroMapper.findAll();
	}

}
