package com.bitc.dto;

import lombok.Data;

@Data
public class CommentDto {
	private int commentIdx;
	private String noComment;
	private String freeComment;
	private String newsComment;
	
	private String creatorId;
}
