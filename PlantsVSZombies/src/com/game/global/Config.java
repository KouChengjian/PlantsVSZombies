package com.game.global;



import android.graphics.Bitmap;
import android.graphics.Rect;

public class Config {
	public static float scaleWidth;		//���ű���
	public static float scaleHeight;	//���ű���
	public static int deviceWidth;		//�豸���
	public static int deviceHeight;		//�豸�߶�
	
	public static Bitmap back;		//����ͼƬ
	public static Bitmap seedBank;	
	public static Bitmap seedFlower;	
	public static Bitmap seedPea;	//����,�ӵ�
	public static Bitmap seedWallNut;
	
	public static Bitmap sun;
	public static Bitmap bullet;
	
	
	
	public static int sunDeadLocationX;
	public static int _sun;
	public static Bitmap[] wallnut = new Bitmap[3];
	public static Bitmap[] sunflower = new Bitmap[18];
	public static Bitmap[] peater = new Bitmap[13];
	public static Bitmap[] rePeater = new Bitmap[15];
	
	
	
	public static Bitmap[] zombie = new Bitmap[31];
	public static Bitmap[] ConeheadZombie = new Bitmap[21];
	public static Rect[][] map;
	
	public static final int c_flower = 0;		//ֲ�����ͳ���
	public static final int c_pea = 1;
	public static final int c_wallnut = 2;
	//ֲ����������
	public static final int sunFlower = 50;
	public static final int sunPeater = 100;
	public static final int sunWallNut = 50;
	public static final int sunRePeater = 200;
	
	
	
}
