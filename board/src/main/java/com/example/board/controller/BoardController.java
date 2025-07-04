package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	

	@GetMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	// 글쓰기 화면 요청을 처리하는 메서드 
	@GetMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return "/board/boardWrite";
	}
	
	// 글 저장 요청을 처리하는 메서드 
	@PostMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto boardDto) throws Exception {
		boardService.insertBoard(boardDto);
		return "redirect:/board/openBoardList.do";
	}
	
	// 상세 조회 요청을 처리하는 메서드
	@GetMapping("/board/openBoardDetail.do")
	public ModelAndView openboardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
		BoardDto boardDto = boardService.selectBoardDetail(boardIdx);
		
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		mv.addObject("board", boardDto);
		
		return mv;
	}
	

}
