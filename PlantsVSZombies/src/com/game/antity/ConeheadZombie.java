package com.game.antity;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.game.global.Config;
import com.game.model.BaseModel;
import com.game.model.Zombies;
import com.game.view.GameView;

public class ConeheadZombie extends Zombies {
	
	public ConeheadZombie(int x,int y, int n, int speed){
		super(x, y, n, speed);
		this.value = 250;
		
	}
	
	
	
	
	@Override
	public void draw(Canvas canvas, Paint paint) {
		// TODO 自动生成的方法存根
		if(isAlive){
			canvas.drawBitmap(Config.ConeheadZombie[farmeIndex/5],locationX,locationY-Config.deviceHeight/25,paint);
			if(++farmeIndex > 99){
				farmeIndex = 0;
			}
			if(stop){
				
			}else{
				locationX  -= Config.deviceWidth / 1000 * speed;
				if(locationX < 0){
					isAlive = false;
				}
			}
			
			
			//碰撞检测
			GameView.getInstance().checkConllision(this,this.n);	
			
			
			
			
			
		}
	}




	@Override
	public int getModelWidth() {
		// TODO 自动生成的方法存根
		return Config.ConeheadZombie[farmeIndex/5].getWidth();
	}



	
}