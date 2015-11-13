package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.TouchAble;

public class Sun extends BaseModel implements TouchAble {
	private float locationX;	//位置
	private float locationY;	
	private boolean isAlive;
	private Rect touchArea;
	private long startTime;
	private SunState sunState;
	private float xDirectionDistance;	//太阳移动 x向量
	private float yDirectionDistance;	//太阳移动y向量
	private float xSpeed;
	private float ySpeed;
	private int value;	//生命值
	
	public enum SunState{	//阳光的状态
		SHOW,MOVE
	}
	
	public Sun(int x,int y){
		locationX = x;
		locationY = y;
		isAlive = true;
		sunState = SunState.SHOW;
		startTime = System.currentTimeMillis();
		touchArea = new Rect((int)locationX,(int)locationY,(int)locationX+Config.sun.getWidth(),(int)locationY+Config.sun.getHeight());
	}
	
	
	@Override
	public boolean onTouch(MotionEvent event) {
		// TODO 自动生成的方法存根
		int x = (int) event.getX();
		int y = (int) event.getY();
		if (event.getAction() ==MotionEvent.ACTION_DOWN){
			if(touchArea.contains(x, y)){
				sunState = SunState.MOVE;
				//x向量
				xDirectionDistance = locationX - Config.sunDeadLocationX + Config.deviceWidth / 28;
				yDirectionDistance = locationY - 0;
				xSpeed = xDirectionDistance / 20f;	//太阳移动到目标点需要10帧
				ySpeed = yDirectionDistance / 20f;
				
				if(xSpeed > ySpeed){	//让每次移动的距离都一样
					ySpeed = yDirectionDistance / xSpeed;
					xSpeed = xDirectionDistance < 0 ? -20 : 20;
				}else{
					xSpeed = xDirectionDistance / ySpeed;
					ySpeed = 20;
				}
				
				
				
				return true;
			}
		
		} 
		return false;
	}
	
	public void draw(Canvas canvas,Paint paint){
		if(isAlive){
			canvas.drawBitmap(Config.sun, locationX, locationY, paint);	
			if(sunState == SunState.SHOW){
				if(System.currentTimeMillis() - startTime > 5000){
					isAlive = false;
				}
			}else if(sunState == SunState.MOVE){
				locationX -= xSpeed;
				locationY -= ySpeed;
				if(locationY <= 0){
					isAlive = false;	
					Config._sun += 25;
				}
			}
			
		}
		
		
		
		
	}
	
	
	
	
	public float getX() {
		return locationX;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public float getY() {
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
	public void sub(int o){
		
	}
	
	
	
	
	
}
