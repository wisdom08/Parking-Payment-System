package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.beans.MemberBean;

public interface MemberMapper {
	@Select("select * from member")
	List<MemberBean> selectMembers();
}
