package com.jdd.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 *@author:David admin@dxscx.com
 *@Version: 1.0
 *@Description:  What do you want to do?
 *@Time:2016-6-19  上午2:17:10
 */
public class RandomCode extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 80;
		int height = 30;
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		g.fillRect(1, 1, width - 2, height - 2);
		g.setColor(Color.RED);
		g.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 30));
		Random rd = new Random();
		String data = "0123456789";
		String code = null;
		for (int i = 0; i < 4; i++) {
			int index = rd.nextInt(9);
			String d = data.substring(index, index + 1);
			if (code == null) {
				code = d;
			} else {
				code += d;
			}
			g.drawString(d, i * 18, 26);
		}
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		response.setContentType("image/jpeg");
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
