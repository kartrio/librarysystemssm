package com.library.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * 生成图形验证码的图片
 * @author Administrator
 *
 */
public class CheckCodeImage {
	public static int WIDTH = 110;
	public static int HEIGHT = 40;

	public static void drawRands(Graphics g, char[] rands) {
		g.setColor(Color.black);
		g.setFont(new Font(null, 3, 22));

		g.drawString("" + rands[0], 3, 25);
		g.setColor(Color.red);
		g.drawString("" + rands[1], 36, 20);
		g.setColor(Color.green);
		g.drawString("" + rands[2], 61, 30);
		g.setColor(Color.blue);
		g.drawString("" + rands[3], 90, 35);
		System.out.println(rands);
	}

	public static void drawBackground(Graphics g) {
		g.setColor(new Color(14474460));

		g.fillRect(0, 0, WIDTH, HEIGHT);
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255.0D);
			int green = (int) (Math.random() * 255.0D);
			int blue = (int) (Math.random() * 255.0D);
			g.setColor(new Color(red, green, blue));

			g.drawOval(x, y, 1, 0);
		}
	}

	public static char[] generateCheckCode() {
		String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++) {
			int rand = (int) (Math.random() * 36.0D);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}
}
