package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.CommentDto;

@Mapper
public interface CommentMapper {

	void insertComment(CommentDto comment) throws Exception;

	List<CommentDto> selectCommentList() throws Exception;

	void deleteComment(int commentIdx) throws Exception;

}
