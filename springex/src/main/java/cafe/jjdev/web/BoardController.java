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
	
	// �� �� ���� ��û 
    @RequestMapping(value="/boardView", method = RequestMethod.GET)
    public String boardView(Model model
                            , @RequestParam(value="boardNo", required=true) int boardNo) {
        Board board = boardDao.getBoard(boardNo);
        model.addAttribute("board", board);
        return "/boardView";
    }
	
	// ����Ʈ ��û		value���� �������� �ص���{"/","/boardList"	}
    @RequestMapping(value={"/boardList"}, method = RequestMethod.GET)
    public String boardList(Model model, @RequestParam(value="currentPage", required=false, defaultValue="1") int currentPage) {
    																		// -> currentPage�� �Ѿ�ü��� �ȳѾ� �ü���
    																	 //defaultValue ���� �Ѿ���� ������ 1�� ó��  -> ���� int
    	int boardCount = boardDao.getBoardCount(); //��ü board�� ����
        int pagePerRow = 10;
        int lastPage = (int)(Math.ceil(boardCount / pagePerRow)); //ceil -> �������� ������ ������ �ø�
        List<Board> list = boardDao.getBoardList(currentPage, pagePerRow);
        model.addAttribute("totalRowCount", boardCount); //
        model.addAttribute("currentPage", currentPage); //����������
        model.addAttribute("boardCount", boardCount); //��ü �Խ����� �� ����
        model.addAttribute("lastPage", lastPage); //������ ������ -> ���� ��ũ�� �������� �ȶ߰� �ϱ� ���ؼ� 
        model.addAttribute("list", list);
       
        return "/boardList";
    }
	
	@RequestMapping(value="/boardAdd", method = RequestMethod.POST)
    public String boardAdd(Board board) {
        System.out.println(board);
        boardDao.insertBoard(board);
        return "redirect:/boardList"; // ���Է��� "/boardList"�� �����̷�Ʈ(���û)
    }

	
	@RequestMapping(value="/boardAdd", method = RequestMethod.GET)
    public String boardAdd() {
        System.out.println("boardAdd �� ��û");
        return "boardAdd";
	}	
}
