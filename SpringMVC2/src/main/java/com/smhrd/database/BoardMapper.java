package com.smhrd.database;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.smhrd.model.BoardVO;

@Mapper
public interface BoardMapper {
	// 기능 단위로 메서드 작성 ==> 추상 메서드 작성 ==> 인터페이스 변경
	// 중괄호 안의 로직은 spring이 자동으로 실행한다.
	//DB에서 전체 게시글을 조회하는 메서드
	public List<BoardVO> boardList();
	
	// 게시글 등록하는 메서드
	public int register(BoardVO vo);
	
	// 게시글 1개를 조회하는 메서드
	// interface에서 쿼리문을 작성한 경우, 동일한 쿼리문이 mapper.xml에 있는 경우 오려 발생!
	@Select("SELECT * FROM BOARD WHERE idx = #{idx}")
	public BoardVO boardSelect(int idx);

	@Delete("DELETE FROM BOARD WHERE idx = #{idx}")
	public void boardDelete(int idx);
}
