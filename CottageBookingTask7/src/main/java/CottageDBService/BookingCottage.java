package CottageDBService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookingCottage
 */
@WebServlet("/Booking")
public class BookingCottage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingCottage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CottageDB mediator = new  CottageDB();
		
		ArrayList<Cottage> result  = null;
		
		if(request.getParameter("reqType").toString().equals("doQuery")){  
			String param01 = request.getParameter("para01").toString();
			String param02 = request.getParameter("para02").toString(); 
			String param03 = request.getParameter("para03").toString(); 
			String param04 = request.getParameter("para04").toString();
			String param05 = request.getParameter("para05").toString();
			String param06 = request.getParameter("para06").toString();
			String param07 = request.getParameter("para07").toString();
			String param08 = request.getParameter("para08").toString();
			String param09 = request.getParameter("para09").toString();
			String pathToDB = this.getServletContext().getRealPath("/res/BookingDB.ttl");
			
			result = mediator.searchForResult(pathToDB, param01, param02, param03, param04, param05, param06, param07, param08, param09);
	    }
		
		
		PrintWriter out = response.getWriter();
		
		if(result.isEmpty()) {
			out.write("No any bookings!");
		}
		
		
		for(Cottage cot: result){
			out.write("Cottage Name: "+cot.cottageName+"\n");
			out.write("Address: "+cot.address+"\n");
			out.write("Nearest City: "+cot.city+"\n");
			out.write("Distance from City: "+cot.cityDistance+"\n");
			out.write("Number of People: "+cot.numberOfPlaces+"\n");
			out.write("Number of Bed Rooms: "+cot.numberOfBedRooms+"\n");
			out.write("Distance from Lake: "+cot.distancelake+"\n");
			out.write("\n");
		}
	
		out.flush();
	    out.close();
	}

}
