package com.iu.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.home.board.BbsDTO;
import com.iu.home.board.BoardDTO;
import com.iu.home.board.BoardService;
import com.iu.home.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		
		pager.makeNum(qnaDAO.getTotalCount(pager));
		
		return qnaDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		return qnaDAO.setBoardAdd(bbsDTO);
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	// reply Insert
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		// QnaDTO
		// num : 부모의 글번호
		// writer, title, contents : 답글로 입력한 값
		// ref : null
		// step : null
		// depth : null
		// 1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		// ref : 부모읜 ref
		qnaDTO.setRef(parent.getRef());
		
		// step : 부모의 step + 1
		qnaDTO.setStep(parent.getStep() + 1);
		
		// depth : 부모의 depth + 1
		qnaDTO.setDepth(parent.getDepth() + 1);
		
		// 2. Step update
		int result = qnaDAO.setStepUpdate(parent);
		
		// 3. 답글 insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result; 
	}
}
