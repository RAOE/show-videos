package com.show.mapper;

import java.util.List;

import com.show.pojo.SearchRecords;
import com.show.utils.MyMapper;

public interface SearchRecordsMapper extends MyMapper<SearchRecords> {
	

	public List<String> getHotWords();

}