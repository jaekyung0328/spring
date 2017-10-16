package cafe.jjdev.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.web.service.Board;
import cafe.jjdev.web.service.BoardDao;

@Controller
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	// 글 상세 내용 요청 
    @RequestMapping(value="/boardView", method = RequestMethod.GET)
    public String boardView(Model model
                            , @RequestParam(value="boardNo", required=true) int boardNo) {
        Board board = boardDao.getBoard(boardNo);
        model.addAttribute("board", board);
        return "/boardView";
    }
	
	// 리스트 요청		value값을 여러개로 해도됨{"/","/boardList"	}
    @RequestMapping(value={"/boardList"}, method = RequestMethod.GET)
    public String boardList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
    																		// -> currentPage가 넘어올수도 안넘어 올수도
    																	 //defaultValue 값이 넘어오지 않으면 1로 처리  -> 숫자 int
    	int boardCount = boardDao.getBoardCount(); //전체 board의 갯수
        int pagePerRow = 10;
        int lastPage = (int)(Math.ceil(boardCount / pagePerRow)); //ceil -> 나머지가 있으면 무조건 올림
        List<Board> list = boardDao.getBoardList(currentPage, pagePerRow);
        model.addAttribute("totalRowCount", boardCount); //
        model.addAttribute("currentPage", currentPage); //현재페이지
        model.addAttribute("boardCount", boardCount); //전체 게시판의 글 갯수
        model.addAttribute("lastPage", lastPage); //마지막 페이지 -> 다음 링크가 마지막에 안뜨게 하기 위해서 
        model.addAttribute("list", list);
       
        return "/boardList";
    }
	
	@RequestMapping(value="/boardAdd", method = RequestMethod.POST)
    public String boardAdd(Board board) {
        System.out.println(board);
        boardDao.insertBoard(board);
        return "redirect:/boardList"; // 글입력후 "/boardList"로 리다이렉트(재요청)
    }

	
	@RequestMapping(value="/boardAdd", method = RequestMethod.GET)
    public String boardAdd() {
        System.out.println("boardAdd 폼 요청");
        return "boardAdd";
	}	
}
