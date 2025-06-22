package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class RestApiBoardController {

	@Autowired
	private BoardService boardService;
	
	// 목록 조회
	// @CrossOrigin(origins = "http://localhost:5173")
	@GetMapping("/board")
	public List<BoardDto> openBoardList() throws Exception {
		return boardService.selectBoardList();
	}
	
	// 글 저장 요청을 처리하는 메서드 
	@PostMapping("/board")
	public void insertBoard(@RequestBody BoardDto boardDto) throws Exception {
		boardService.insertBoard(boardDto);
	}
	
	// 상세 조회 요청을 처리하는 메서드
	@GetMapping("/board/{boardIdx}")
	public ResponseEntity<Object> openboardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		BoardDto boardDto = boardService.selectBoardDetail(boardIdx);
		if (boardDto == null) {
			Map<String, Object> result = new HashMap<>();
			result.put("code", HttpStatus.NOT_FOUND.value());
			result.put("name", HttpStatus.NOT_FOUND.name());
			result.put("message", "게시판 번호 " + boardIdx + "와 일치하는 게시물이 존재하지 않습니다.");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(boardDto);
		}
	}
}
