package com.iu.home.board;

import java.util.List;

import com.iu.home.util.Pager;

public interface BbsDAO {
	
	// totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
	// list
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	// insert
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	
	// update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	// delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;
}
