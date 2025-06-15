package kr.cloud.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.cloud.web.entity.CloudMember;

@Repository // sql구문을 생성할 repository임을 명시하는 어노테이션
public interface CloudMemberRepository 
         extends JpaRepository<CloudMember, String> {

	public CloudMember findByUseridAndUserpw(String userid, 
			               String userpw);

	//JPARepository <테이블이 생성된 클래스명, 테이블의 PK자료형>
	// int인 경우, Wrapper Class로 Integer 작성한다.
	// --> 여기까지 작성하면 기본 CRUD 사용 가능!
	//  * 사용 가능한 메서드가 아래와 같다!
	//     findAll
	//     findByUserid
	//     save
	//     delete
	// <JPA 메서드 명명 규칙>
	// 1) select 기능 수행 시,
	//    find +테이블명(생략 가능) + By + Column이름
	//     * 카멜식 규칙으로 첫 글자만 대문자!
	//       ex) findByUserpw(String pw)
	//         찾고싶은 컬럼명과 메서드 명이 동일해야한다!
	//     -> select * from cl_member where userpw=#{userpw}
	
	// 2) 조건을 여러개 붙이고 싶을 때!
	//    id 혹은 이름이 일치한 데이터를 조회
	//    -> findByUseridOrUsername(String userid, String username)
	//      And, Or , not, orderBy, isNull, Between
	//      .. : 컬럼이 추가되는 위치
	//    3) existes..By..
	//       특정 데이터 존재 여부 판단 (리턴 : boolean)
	//    4) count..By..
	//       조회 후에 해당 데이터 개수 리턴(리턴 : long)
//  JPA를 이용해서 Login 기능 만들기( 로그인 성공 -> main.html로 이동)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
