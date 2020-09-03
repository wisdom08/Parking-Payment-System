package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.beans.LogBean;

public interface LogMapper {
	@Select("select * from logs")
	List<LogBean> selectLog();
}
