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
		// TODO �Զ����ɵķ������
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
			
			
			//��ײ���
			GameView.getInstance().checkConllision(this,this.n);	
			
			
			
			
			
		}
	}




	@Override
	public int getModelWidth() {
		// TODO �Զ����ɵķ������
		return Config.ConeheadZombie[farmeIndex/5].getWidth();
	}



	
}