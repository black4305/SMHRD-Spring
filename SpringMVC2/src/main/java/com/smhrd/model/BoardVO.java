package com.smhrd.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

// lombok : 어노테이션을 이용하여 getter/setter/toString등 작성 가능
@NoArgsConstructor // 기본생성자(전달인자 x)
@AllArgsConstructor //모든 필드를 전달인자로 받는 생성자argument : 전달인자 
@Data // getter,setter, toString
public class BoardVO {
	// 하나의 자료형으로 묶어주기 위해 만드는 나만의 자료형
	// 게시글 데이터 1개를 표현가능한 자료형
	// 1. 필드
	//    게시글번호, 제목, 작성자 이름, 내용, 작성일
	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date indate;
}
