package cafe.jjdev.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafe.jjdev.web.MemberRequest;
@Service
public class MemberService {
		@Autowired //주입받다
		private MemberDao memberDao;
		public int addMember(MemberRequest memberRequest) {
			Member member =  new Member();
			member.setMemberId(memberRequest.getMemberId());
			member.setMemberPw(memberRequest.getMemberPw());
			member.setMemberName(memberRequest.getMemberName());
			return memberDao.insertMember(member);
			
		}
}
