package com.bitc.service.comment;

import java.util.List;

import com.bitc.dto.CommentDto;

public interface CommentService {

	void insertComment(CommentDto comment) throws Exception;

	List<CommentDto> selectCommentList() throws Exception;

	void deleteComment(int commentIdx) throws Exception;

}
