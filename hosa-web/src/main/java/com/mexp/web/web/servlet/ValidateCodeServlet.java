package com.mexp.web.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.mexp.core.utils.StringCodeUtils;


public class ValidateCodeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1264719463166937194L;

	/**
	 * @see HttpServletHttpServlet()
	 */
	public ValidateCodeServlet() {
		super();
	}

	/**
	 * @see Servletinit(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServletdoGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpg"); 
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		//response.setDateHeader("Expires", 0);
		
		String webToken = (String) request.getParameter("t");
		
		String captcha = StringUtils.substring(StringCodeUtils.md5(webToken), 5, 9);
		BufferedImage image = generate(captcha);
		ServletOutputStream responseOutputStream = response.getOutputStream();
		ImageIO.write(image, "JPEG", responseOutputStream);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	private BufferedImage generate(String captcha) {
		int width = 100, height = 40;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		g.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		for(int i=0; i< captcha.length(); i++) {
			String rand = String.valueOf(captcha.charAt(i));

			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 20 * i + 8, 33);
		}
//		for (int i = 0; i < 4; i++) {
//			String rand = String.valueOf(random.nextInt(10));
//
//			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
//			g.drawString(rand, 13 * i + 6, 20);
//		}
		g.dispose();
		
		return image;
	}
	Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	

}
