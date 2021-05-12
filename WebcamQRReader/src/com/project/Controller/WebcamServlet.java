package com.project.Controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.project.db.WebcamDao;
import com.project.Web.WebcamWallet;
import com.project.Web.WebcamUser;
import com.project.Web.WebcamTransaction;


/**
 * Servlet implementation class WebcamServlet
 */
@WebServlet("/WebcamServlet")
public class WebcamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private WebcamDao webcamdao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
   public void init() {
	   webcamdao=new WebcamDao();
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("common/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		try {
	    	   switch(action) {
	    	   case "ReadQr":
	    		   Readqr(request,response);
	    		   
	    		   break;
	    	   }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	private void Readqr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Called");
		Webcam webcam = Webcam.getDefault();   //Generate Webcam Object
        webcam.setViewSize(new Dimension(320,240));
        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setMirrored(false);
        JFrame jFrame = new JFrame();
        jFrame.add(webcamPanel);
        jFrame.pack();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        do {
            try {
            	
                BufferedImage image = webcam.getImage();
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Result result = new MultiFormatReader().decode(bitmap);
                if(result.getText() != null) {
                    jFrame.setVisible(false);
                    jFrame.dispose();
                    webcam.close();
                    System.out.println(result.getText());
                 try {
                	 if(result.getText()!=null) {
                		 String s = result.getText();
                		 String s1=s.substring(10, 22);
                		 
                		 
                		WebcamUser webcam1 =new WebcamUser(); 
                		webcam1.setQrid(s1);
                		 try {
                			 if(webcamdao.validate(webcam1)) {
                				 request.setAttribute("Validation", s1);
                				 System.out.println("Correct");
                				 WebcamUser user=WebcamDao.verify(s1);
                				 HttpSession session = request.getSession(true);
                					session.setAttribute("user", user);
                				transaction(request,response);
                			 }
                			 
                			 else {
                				 System.out.println("Incorrect Details");
                			 }
                		 }catch(Exception e) {
                			 e.printStackTrace();
                		 }RequestDispatcher dispatcher = request.getRequestDispatcher("common/index.jsp");
                  		dispatcher.forward(request, response);
                	 }
                 }catch(Exception e) {
                	 e.printStackTrace();
                 } 
                    break;
                    
                }

            }catch (NotFoundException e ) {
                //pass
            }
            
            
        } while(true);
		
	}

	private void transaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		WebcamUser user = (WebcamUser) session.getAttribute("user");
		List<WebcamTransaction> transactions = WebcamDao.getTransactions(1, user);// TODO Auto-generated method stub
		request.setAttribute("transactions", transactions);
		double cash = 50;
		String comments="Prefare money deduction";
		WebcamTransaction trans =new WebcamTransaction(cash,comments);
		trans.setUser(user.getQrid());
		WebcamWallet userWallet = WebcamDao.getUserWalletBalance(user.getQrid());
		
		double existingCash = userWallet.getCash();
		double updatedAmount = existingCash - cash;
		if(updatedAmount < 50){
			System.out.println("Insufficient Balance !!");
		}
		
		WebcamWallet newWallet = WebcamDao.updateUserWalletBalance(user.getQrid(), updatedAmount);
		if(null != newWallet){
			WebcamDao.doTransaction(trans);
			request.setAttribute("NOTIFICATION", "Amount Deducted Successfully!");
		} else {
			
			System.out.println("Transaction Error!!");
		}
	}

}

