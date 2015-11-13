package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.Plants;
import com.game.view.GameView;

public class RePeater extends Plants {
	private int farmeIndex = 0;
	private int makeSpeed = 1400;	//生产速度为1.4秒
	private long makeTime;
	

	
	public RePeater(int left ,int top ,int x,int y,int v){
		super(left,top,x,y,v);
		isAlive = true;
		Config._sun -= Config.sunRePeater;
		makeTime = System.currentTimeMillis();
		
		
		
		
	}
	
	
	
	
	@Override
	public int getModelWidth() {
		// TODO 自动生成的方法存根
		return Config.rePeater[farmeIndex/5].getWidth();
	}




	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO 自动生成的方法存根
		
		if(isAlive){
			canvas.drawBitmap(Config.rePeater[farmeIndex/5],locationX,locationY,paint);
			if(++farmeIndex >= 75){
				farmeIndex = 0;
			}
			
			if(farmeIndex == 5){
				
				GameView.getInstance().makeBullet(locationX +Config.rePeater[farmeIndex/5].getWidth()/10*7,locationY +Config.rePeater[farmeIndex/5].getHeight()/25,y,20);
				makeTime = System.currentTimeMillis();
				
			}
			
			
			
		}
		
		
	}




	
	
}
