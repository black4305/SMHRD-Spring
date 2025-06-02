package kr.cloud.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.cloud.web.entity.Board;
import kr.cloud.web.entity.SearchCriteria;

@Mapper
public interface BoardMapper {

    public List<Board> selectAll();

	public Board goBoardContent(int idx);

    @Update("UPDATE BOARD SET COUNT = COUNT + 1 WHERE IDX = #{idx}")
	public int updateBoard(int idx);

	public List<Board> search(SearchCriteria criteria);

	public void goInsert(Board board);
}
