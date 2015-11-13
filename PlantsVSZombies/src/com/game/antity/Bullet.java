package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;

public class Bullet extends BaseModel {
	private int locationX;	//λ��
	private int locationY;	
	private boolean isAlive;
	private int speed;
	private int a;	//������
	public Bullet(int x,int y,int a){	//aΪ�ӵ��Ĺ�����
		locationX = x;
		locationY = y;
		speed = 10;
		isAlive = true;
		this.a = a;
	}
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		canvas.drawBitmap(Config.bullet, locationX, locationY, paint);
		
		locationX += speed; 
		
		if(locationX > Config.deviceWidth){
			isAlive = false;
			
			
		}
		
	}

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.bullet.getWidth();
	}

	@Override
	public int getSpeed() {
		// TODO �Զ����ɵķ������
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		// TODO �Զ����ɵķ������
		this.speed = speed;
	}

	public int getA(){	//ȡ�ӵ�������
		return this.a;
	}
	
	
	
	
	
}
