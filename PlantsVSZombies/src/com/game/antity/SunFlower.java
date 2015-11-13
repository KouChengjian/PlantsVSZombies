package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.Plants;
import com.game.view.GameView;

public class SunFlower extends Plants {
	
	
	private int farmeIndex = 0;
	private long makeTime;
	private int n;
	private int x,y;

	public SunFlower(int left ,int top,int x,int y,int v){		//x�Ǻ������λ��  y ���������λ��
		super(left,top,x,y,v);
		
		makeTime = System.currentTimeMillis() ;
		Config._sun -= Config.sunFlower;
		n = x;
		
		
		
	}
	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.sunflower[farmeIndex/5].getWidth();
	}
	//����̫��
	public void makeSun(){	
		GameView.getInstance().makeSun(locationX,locationY);
		
		
	}
	
	
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO �Զ����ɵķ������
		
		if(isAlive){
			canvas.drawBitmap(Config.sunflower[farmeIndex/5],locationX,locationY,paint);
			if(++farmeIndex >= 90){
				farmeIndex = 0;
			}
			if(System.currentTimeMillis() - makeTime > 10000){
				
				makeTime = System.currentTimeMillis();
				makeSun();
			}
		}
		
		
	}

	
	
}
