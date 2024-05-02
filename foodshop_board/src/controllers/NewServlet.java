package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.StringHelper;

import javassist.CtNewMethod;
import models.Suggest_shop;
import utils.DBUtil;
import java.sql.Timestamp;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager em = DBUtil.createEntityManager();
		em.getTransaction().begin();
		
		Suggest_shop s = new Suggest_shop();
		
		String shopname = "座銀";
		s.setShopname(shopname);
		
		String star = "4";
		s.setStar(star);
		
		String category = "ラーメン屋";
		s.setCategory(category);
		
		String coment = "ごぼうの素揚げと鶏白湯のスープの組み合わせがおいしかった";
		s.setComent(coment);
		
	    Timestamp currentTime = new Timestamp(System.currentTimeMillis()); // 現在の日時を取得
	    s.setCreated_at(currentTime);
	    s.setUpdated_at(currentTime);
	    
	    em.persist(s);
	    em.getTransaction().commit();
	    
	    response.getWriter().append(Integer.valueOf(s.getId()).toString());
	    
	    em.close();
	}

}
