package com.game.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;

public class Zombies extends BaseModel {
	protected int locationX;	//λ��
	protected int locationY;	
	protected boolean isAlive;
	protected int farmeIndex = 0;
	protected int n;		//Ϊ��ʬ���ڵ��ܵ�
	protected int speed;
	protected int value;	//����ֵ
	protected boolean stop;
	
	
	
	public Zombies(int x,int y, int n, int speed){
		locationX = x;
		locationY = y;
		isAlive = true;
		this.n = n;
		this.speed = speed;
		this.stop = false;
		
		
	}
	public void draw(Canvas canvas, Paint paint) {
		
		
		
		
	}
	
	public int getSpeed() {
		return Config.deviceWidth / 1000 * speed;
	}




	public void setSpeed(int speed) {
		this.speed = speed;
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
	public void sub(int o){	//����Ѫ
		this.value -= o;
		if(this.value <= 0){
			this.isAlive = false;
		}
	}
	public void stop(boolean v){
		this.stop = v;
	}
	
	
}
