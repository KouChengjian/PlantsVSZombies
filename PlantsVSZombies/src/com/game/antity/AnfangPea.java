package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.TouchAble;
import com.game.view.GameView;

public class AnfangPea extends BaseModel implements TouchAble{
	private int locationX;	//位置
	private int locationY;	
	private boolean isAlive;	//是否活着
	private Rect touchArea;	
	private int type;	//植物的类型	
	@Override
	public boolean onTouch(MotionEvent event) {
		
		int x = (int)event.getX();
		int y = (int)event.getY();
		if(isAlive){
			switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:	//按下
				
				return true;
			case MotionEvent.ACTION_MOVE:	//移动
				locationX = x -Config.peater[0].getWidth()/2;
				locationY = y-Config.peater[0].getHeight()/2;
				touchArea.offsetTo(locationX, locationY);
				return true;
			case MotionEvent.ACTION_UP:		//弹起
				isAlive = false;
				GameView.getInstance().apply4Plant(locationX,locationY,type);
				return true;
			
			}
			
			
			
		}
		
		// TODO 自动生成的方法存根
		return false;
	}
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO 自动生成的方法存根
		
		if(isAlive){
			
			switch(type){
			case Config.c_flower:
				canvas.drawBitmap(Config.sunflower[0], locationX, locationY, paint);
				break;
			case Config.c_pea:
				canvas.drawBitmap(Config.peater[0], locationX, locationY, paint);
				break;
			case Config.c_wallnut:
				canvas.drawBitmap(Config.wallnut[0], locationX, locationY, paint);
				break;
			}
			
			
			
		}
		
		
		
	}
	public AnfangPea (int x,int y,int type){
		locationX = x;
		locationY = y;
		this.type = type;
		isAlive = true;
		touchArea = new Rect(locationX,locationY,locationX+Config.peater[0].getWidth(),locationY+Config.peater[0].getHeight());
		
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
	

}
