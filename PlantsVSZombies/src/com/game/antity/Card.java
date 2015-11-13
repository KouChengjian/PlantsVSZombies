package com.game.antity;



import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.TouchAble;
import com.game.view.GameView;

public class Card extends BaseModel implements TouchAble {
	private int locationX;	//位置
	private int locationY;	
	private boolean isAlive;	//是否活着
	private Rect touchArea;		//触摸区域
	private int type;
	private int m_sun;	//需要多少太阳
	
	
	public Card(int x,int y,int type){
		locationX = x;
		locationY = y;
		this.type = type;
		isAlive = true;
		touchArea = new Rect(locationX,locationY,locationX+Config.seedPea.getWidth(),locationY+Config.seedPea.getHeight());
		switch(type){
		case Config.c_flower:
			this.m_sun = Config.sunFlower;
			break;
		case Config.c_pea:
			this.m_sun = Config.sunPeater;
			break;
		case Config.c_wallnut:
			this.m_sun = Config.sunWallNut;
			break;
		}
		
	}
	
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO 自动生成的方法存根
		if(isAlive){
			switch(type){
			case Config.c_flower:
				canvas.drawBitmap(Config.seedFlower,locationX,locationY,paint);
				break;
			case Config.c_pea:
				canvas.drawBitmap(Config.seedPea,locationX,locationY,paint);
				break;
			case Config.c_wallnut:
				canvas.drawBitmap(Config.seedWallNut,locationX,locationY,paint);
				break;
			}
			if(Config._sun < this.m_sun){
				paint.setAlpha(100);
				canvas.drawRect(touchArea, paint);
				paint.setAlpha(255);
			}
			
			
	
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
	public boolean onTouch(MotionEvent event) {
		// TODO 自动生成的方法存根
		int x = (int ) event.getX();
		int y = (int ) event.getY();
		
		if(touchArea.contains(x, y)){
			if(Config._sun >= this.m_sun){
				anfang();
				return true;
			}
		}
		
		return false;
	}


	private void anfang() {	//种
		// TODO 自动生成的方法存根
		GameView.getInstance().anfang(locationX,locationY,type);
	}

}
