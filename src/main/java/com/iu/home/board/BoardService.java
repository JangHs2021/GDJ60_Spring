package com.iu.home.board;

public interface BoardService extends BbsService {
	
	// detail
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
}
