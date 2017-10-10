package cafe.jjdev.web;

public class MemberRequest {
	
	private String memberId;
	private String memberPw;
	private String memberName;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	@Override
	public String toString() {
		return "MemberRequest [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + "]";
	}
	
	
	
}
