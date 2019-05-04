package cn.tedu.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/* ����java���������֤��ͼƬ */
public class VerifyCode {
	private static int width = 120;
	private static int height = 30;
	private static String codes = "23456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
	private static String[] fontNames = { "΢���ź�", "����", "���Ŀ���", "��Բ", "����",
			"����" };
	
	private String valistr = ""; //������֤���ı�

	/**
	 * ������֤��ͼƬ
	 */
	public void drawImage(OutputStream output) {
		// 1.����һ��ͼƬ����������(����һ��ͼ��),
		// ������ͼƬ�Ŀ�ߺ�����
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 2.�õ�����(�õ����ƻ���)
		Graphics2D g = (Graphics2D) bi.getGraphics();

		// 3.��ʼ��ͼ
		/* ��һ��(��)Բ */
		// g.drawOval(0, 0, width, height);

		/* ��һ������ */
		// g.drawRect(0, 0, width-1, height-1);
		// g.drawRect(5, 5, 20, 20);

		/* ���ñ�����ɫ */
		g.fillRect(0, 0, width, height);

		/* ���û�����ɫ */
		g.setColor(Color.RED);

		/* ���������С */
		g.setFont(new Font("΢���ź�", Font.BOLD, 22));

		/* ��һ���ַ�(��) */
		for (int i = 0; i < 4; i++) {
			/* ����������ɫ��� */
			g.setColor(new Color(getRandom(0, 175), getRandom(0, 175),
					getRandom(0, 175)));

			/* ����������� */
			g.setFont(new Font(fontNames[getRandom(0, fontNames.length)],
					Font.BOLD, 22));

			/* ��ͼƬ��תָ���Ķ��� */
			/* �������ȡ�Ķ���ת�ɻ���!!! */
			double theta = getRandom(-45, +45) * Math.PI / 180;
			g.rotate(theta, i * 30 + 7, height - 7);

			/* �����ȡһ���ַ� */
			String code = codes.charAt(getRandom(0, codes.length())) + "";
			g.drawString(code, i * 30 + 7, height - 7);
			
			valistr = valistr + code;
			
			/* ��ͼƬ����ת���� */
			g.rotate(-theta, i * 30 + 7, height - 7);
		}

		/* �������� */
		for (int i = 0; i < 6; i++) {
			/* ����������ɫ��� */
			g.setColor(new Color(getRandom(0, 175), getRandom(0, 175),
					getRandom(0, 175)));
			//�����һ����
			g.drawLine(getRandom(0, width), getRandom(0, height),
					getRandom(0, width), getRandom(0, height));
		}
		
		/* ��һ���߿� */
		//���ñ߿����ɫ
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, width-1, height-1);

		// 4.����ͼƬ��ָ��λ��(Ӳ��/���͸������)
		try {
			ImageIO.write(bi, "JPEG", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 5.�ͷ���Դ
		g.dispose();
	}
	
	/**
	 * ������֤���ı�
	 * @return
	 */
	public String getCode(){
		return valistr;
	}

	/* ��ȡһ��ָ����Χ������� 0~10 3~10 */
	public int getRandom(int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start) + start;
	}

	public static void main(String[] args) throws Exception {
		VerifyCode vc = new VerifyCode();
		vc.drawImage(new FileOutputStream("E:/vc.jpg"));
		System.out.println("ִ�����!!");
	}
}
