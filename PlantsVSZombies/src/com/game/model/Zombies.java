package com.game.model;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;

public class Zombies extends BaseModel {
	protected int locationX;	//位置
	protected int locationY;	
	protected boolean isAlive;
	protected int farmeIndex = 0;
	protected int n;		//为僵尸所在的跑道
	protected int speed;
	protected int value;	//生命值
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
	public void sub(int o){	//减少血
		this.value -= o;
		if(this.value <= 0){
			this.isAlive = false;
		}
	}
	public void stop(boolean v){
		this.stop = v;
	}
	
	
}
