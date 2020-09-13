package JSP_Practice.sevlet_calc;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;


@WebServlet(description = "계산기 구현", urlPatterns = {"/CalcServlet"})
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response)
	throws ServletException, IOException{
		doPost(request,response);
	}
	
   
        
   

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int num1, num2;
		int result;
		String op;
		
		response.setContentType("text/html; charset=euc-kr");
		
		PrintWriter out = response.getWriter();
		
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("op");
		
		result = calc(num1, num2, op);
		
		out.println("<HTML>");
		out.println("<HEAD><TITLE>계산</TITLE></HEAD>");
		out.println("<BODY><CENTER>");
		out.println("<H1>계산</H1><HR>");
		out.println(num1+""+op+""+num2+ "=" + result);
		out.println("</Body></HTML>");
	}
	
	public int calc(int num1, int num2, String op) {
		int result = 0;
		switch (op) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}
		return result;
		}
	}