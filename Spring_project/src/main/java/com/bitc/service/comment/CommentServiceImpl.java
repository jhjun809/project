package com.bitc.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.CommentDto;
import com.bitc.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public void insertComment(CommentDto comment) throws Exception {
		commentMapper.insertComment(comment);
		
	}

	@Override
	public List<CommentDto> selectCommentList() throws Exception {
		
		return commentMapper.selectCommentList();
	}

	@Override
	public void deleteComment(int commentIdx) throws Exception {
		commentMapper.deleteComment(commentIdx);
		
	}
	
}
