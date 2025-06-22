package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dto.BoardDto;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() {
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto boardDto) {
		// TODO: 글쓴이 ID를 로그인한 사용자의 ID로 변경
		boardDto.setCreatedId("admin");
		
		boardMapper.insertBoard(boardDto);		
	}

}
