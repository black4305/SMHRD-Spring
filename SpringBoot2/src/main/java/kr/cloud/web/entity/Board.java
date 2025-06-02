package kr.cloud.web.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor // 모든 전달인자(매개변수) 있는 생성자
@NoArgsConstructor  // 기본 생성자(전달인자,매개변수 X)
public class Board {

	private int idx;
	private String title;
	private String writer;
	private String content;
	private Date indate;
	private int count;
	private String file;
	
	
}
