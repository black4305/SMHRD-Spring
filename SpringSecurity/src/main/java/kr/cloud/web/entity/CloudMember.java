package kr.cloud.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // jpa 데이터베이스 테이블을 나타내는 객체임을 표현하는 어노테이션
@Table(name="cl_Member")
public class CloudMember {
	
	// JPA 사용법
	// -> 각각의 필드 위에 어노테이션을 추가함으로써 DB 컬럼의 제약조건
	//     설정 !
	@Id // --> Pk 의미
	private String userid;
	@Column(nullable=false)
	// 기타 다른 제약 조건을 걸고 싶을때, 사용 가능한 어노테이션
	private String userpw;
	@Column(nullable=false)
	private String username;
	
	
}
