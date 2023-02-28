package com.iu.home.board.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDAO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.BoardFileDTO;
import com.iu.home.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.home.board.notice.NoticeDAO.";
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}

	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getBoardList", pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setBoardAdd", bbsDTO);
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "setBoardUpdate", bbsDTO);
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "setBoardDelete", bbsDTO);
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getBoardDetail", boardDTO);
	}

	@Override
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "setBoardFileAdd", boardFileDTO);
	}

	@Override
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getBoardFileList", bbsDTO);
	}

	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getBoardFileDetail", boardFileDTO);
	}
}
