package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VocabularyItem;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/editItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ListItemHelper dao = new ListItemHelper();
		
		String word = request.getParameter("store");
		String definition = request.getParameter("definition");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		VocabularyItem itemToUpdate = dao.searchForVocabById(tempId);
		itemToUpdate.setWord(word);
		itemToUpdate.setDefinition(definition);
		
		dao.updateVocab(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request,  response);
	}

}
