package kr.cloud.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
	
	// 검색 기준을 의미하는 자료형
	// filter : select 태그의 입력받는 데이터
	// searchContent : input태그의 입력받는 데이터
	private String filter; // 작성자 or 제목 or내용
	private String searchContent; // 입력받은 검색 단어
	
	// Board.jsp에서 form태그를 통해서 검색을 할 경우,
	// controller에서 데이터를 가져올때, 한가지씩 가져오는게 아니라
	// criteria라는 자료형으로 전체 가져오겠다.
	
	
	
	
}
