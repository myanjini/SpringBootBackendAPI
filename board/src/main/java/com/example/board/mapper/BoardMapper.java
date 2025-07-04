package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList();
	void insertBoard(BoardDto boardDto);
	BoardDto selectBoardDetail(int boardIdx);
	void updateHitCnt(int boardIdx);
}
