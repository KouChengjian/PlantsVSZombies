package com.game.model;

import android.graphics.Canvas;
import android.graphics.Paint;

public class BaseModel {
	private int locationX;	//位置
	private int locationY;	
	private boolean isAlive;	//是否活着
	private int speed;
	private int a;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public  void draw(Canvas canvas,Paint paint){	//画
		
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
	public int getModelWidth(){
		return 0;
	}
	public int getSpeed() {
		return 0;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
