package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Suggest_shop;
import utils.DBUtil;

import javax.persistence.EntityManager;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Suggest_shop> suggest_shop = em.createNamedQuery("getAllSuggest_shop", Suggest_shop.class).getResultList();
        response.getWriter().append(Integer.valueOf(suggest_shop.size()).toString());

        em.close();
        
        request.setAttribute("suggest_shop", suggest_shop);
        
        var rd = request.getRequestDispatcher("/WEB-INF/views/suggest_shop/index.jsp");
        rd.forward(request, response);
	}

}
