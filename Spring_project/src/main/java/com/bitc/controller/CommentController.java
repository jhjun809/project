package com.bitc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitc.dto.CommentDto;
import com.bitc.service.comment.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	/*댓글 불러오기*/
	@RequestMapping("/teamTwo/comment/news")
	public String insertComment(CommentDto comment) throws Exception{
		commentService.insertComment(comment);
		return "/news/newsList";
	}
	/*댓글 지우기*/
	@RequestMapping("/teamTwo/deleteComment/{commentIdx}")
	public String deleteComment(@PathVariable("commentIdx") String commentIdx)throws Exception{
		int Idx=Integer.parseInt(commentIdx);
		commentService.deleteComment(Idx);
		return "/news/newsList";
	}
}
