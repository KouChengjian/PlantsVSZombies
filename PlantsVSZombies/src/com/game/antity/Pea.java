package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.Plants;
import com.game.view.GameView;

public class Pea extends Plants {
	private int farmeIndex = 0;
	private int makeSpeed = 1400;	//�����ٶ�Ϊ1.4��
	private long makeTime;
	

	
	public Pea(int left ,int top ,int x,int y,int v){
		super(left,top,x,y,v);
		isAlive = true;
		Config._sun -= Config.sunPeater;
		makeTime = System.currentTimeMillis();
		
		
		
		
	}
	
	
	
	
	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.peater[farmeIndex/5].getWidth();
	}




	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		
		if(isAlive){
			canvas.drawBitmap(Config.peater[farmeIndex/5],locationX,locationY,paint);
			if(++farmeIndex >= 65){
				farmeIndex = 0;
			}
			
			if(farmeIndex == 5){
				
				GameView.getInstance().makeBullet(locationX +Config.peater[farmeIndex/5].getWidth()/10*7,locationY +Config.peater[farmeIndex/5].getHeight()/25,y,20);
				makeTime = System.currentTimeMillis();
				
			}
			
			
			
		}
		
		
	}




	
	
}