package blog.csdn.net.dr_guo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class Image {

	public static void main(String[] args) throws Exception {

		Image i = new Image();
		i.create();
	}

	public void create() throws Exception {
		int[] a = null;
		// 大小
		int width = 60;
		int height = 30;
		// 声明一个图片类型rgb
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 获取画笔
		Graphics g = bi.getGraphics();
		// 背景色
		g.setColor(Color.WHITE);

		// 画

		g.fillRect(0, 0, width, height);
		// 字体
		g.setFont(new Font("黑体", Font.BOLD, 18));

		// 写一个字符到bi
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			// 生成随机数
			int code = r.nextInt(10);// 0---9之间
			// 画笔随机色
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			// 写出字符
			g.drawString("" + code, i * 15, 10 + r.nextInt(20));

		}

		// 干扰线
		for (int i = 0; i < 1; i++) {

			//g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			// 画线
			//g.drawLine(r.nextInt(60), r.nextInt(30), r.nextInt(60), r.nextInt(30));
		}
		g.dispose();// 图片生成

		ImageIO.write(bi, "JPEG", new FileOutputStream(System.getProperty("user.dir")+"/img1/a.jpg"));// 设置路径为e：盘下的a.jpg

	   System.out.println("finished-------");
	}

}
