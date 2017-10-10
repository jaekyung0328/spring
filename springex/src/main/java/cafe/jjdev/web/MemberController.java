package cafe.jjdev.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Member;
import cafe.jjdev.web.service.MemberDao;
import cafe.jjdev.web.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/memberList")
	public String memberList() {
		System.out.println("memberList 요청");
		//DBㅇ에서 list를 get해온다.
		return"memberList";
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	// command객체이용하는 방법
	public String addMebmer(MemberRequest memberRequest) { // Member member
		/*입력받는 폼의 네임과 MemberRequest의 객체네의 명이 일치해야함 */
		System.out.println(memberRequest);
		memberService.addMember(memberRequest);
		return "redirect:/memberList"; //response.sendRedirct("/memberList")
				//memberList를 재요청 하세요
	}
	
	//@RequestParam 각각
	/*@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMeber(@RequestParam(value = "memberId") String memberId
							,@RequestParam(value = "memberPw") String memberPw
							,@RequestParam(value = "memberName") String memberName) {
		
	System.out.println(memberId + "  : memberId");
	System.out.println(memberPw + "  : memberPw");
	System.out.println(memberName + "  : memberName");
		return "";
	}*/
	
	
	@RequestMapping(value="/addMember", method = RequestMethod.GET)
	public String addMebmer() {
		return "addMember";
	}
	
	
	
	@RequestMapping("/getMember")  //get, post 상관x
	//getmembe가 호출 되는 시점에 스프링이 만들어줌 // request의 저장공간 과 비슷한다.
	public String getMember(Model model) {
		Member member = memberDao.selectMemberOne(1);
		model.addAttribute("member",member);
		return "getMember";
	}
}
