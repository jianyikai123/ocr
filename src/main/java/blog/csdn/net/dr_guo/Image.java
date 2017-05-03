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
		// ��С
		int width = 60;
		int height = 30;
		// ����һ��ͼƬ����rgb
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// ��ȡ����
		Graphics g = bi.getGraphics();
		// ����ɫ
		g.setColor(Color.WHITE);

		// ��

		g.fillRect(0, 0, width, height);
		// ����
		g.setFont(new Font("����", Font.BOLD, 18));

		// дһ���ַ���bi
		Random r = new Random();
		for (int i = 0; i < 4; i++) {
			// ���������
			int code = r.nextInt(10);// 0---9֮��
			// �������ɫ
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			// д���ַ�
			g.drawString("" + code, i * 15, 10 + r.nextInt(20));

		}

		// ������
		for (int i = 0; i < 1; i++) {

			//g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			// ����
			//g.drawLine(r.nextInt(60), r.nextInt(30), r.nextInt(60), r.nextInt(30));
		}
		g.dispose();// ͼƬ����

		ImageIO.write(bi, "JPEG", new FileOutputStream(System.getProperty("user.dir")+"/img1/a.jpg"));// ����·��Ϊe�����µ�a.jpg

	   System.out.println("finished-------");
	}

}
