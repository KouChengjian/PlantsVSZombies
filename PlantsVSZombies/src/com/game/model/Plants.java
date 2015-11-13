package com.game.model;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.game.global.Config;
import com.game.model.BaseModel;

public class Plants extends BaseModel {
	public int locationX;	//位置
	public int locationY;	
	public boolean isAlive;	//是否活着
	private int speed;
	private int a;
	public int value;
	protected int x,y; 			//xy不是表示坐标而是表示所在格子
	
	public Plants(int left,int top,int x,int y,int v){		//v为生命值
		top += Config.deviceHeight/30;
		this.locationX = left;
		this.locationY = top;
		this.x = x;			
		this.y = y;
		this.value = v;
		isAlive = true;
	}
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
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
	public void sub(int v){
		this.value -= v;
		if(this.value <= 0){
			this.isAlive = false;
		}
	}
	
	public Point getXY(){
		return new Point(x,y);
	}
	
	
	
	
	
}
