package threads;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import resources.Tiles;

public class LevelThread extends TimerThread {
	private static final int WAIT_TIME = 10;
	private static final int NB_WAITS = 100; 
	BufferedImage LEVEL;
	
	private Tiles tiles;
	private int scoreLevelI;
	private JPanel gamePanel;
	Graphics dbg;
	
	private Dimension dim = new Dimension();
	
	private int draw_nb = 0;

	public LevelThread(Tiles tiles, JPanel gamePanel, int scoreLevelI) {
		super(WAIT_TIME, NB_WAITS);
		setName("Level");
		this.tiles = tiles;
		this.gamePanel = gamePanel;	
		this.scoreLevelI=scoreLevelI;
	}
	@Override
	protected void doThatAtStart() {
		drawOrDie();
	}
	
	@Override
	protected void doThatWhileWaiting() {}

	@Override
	protected void finallyDoThat() {
		drawOrDie();
	}
	

	public BufferedImage level() {
		BufferedImage L2 = tiles.getTileNumber(50);
		BufferedImage LE = tiles.joinToRight(L2 , tiles.getTileNumber(43));
		BufferedImage LEV = tiles.joinToRight(LE , tiles.getTileNumber(60));
		BufferedImage LEVE = tiles.joinToRight(LEV ,tiles.getTileNumber(43));
		BufferedImage LEVEL = tiles.joinToRight(LEVE , tiles.getTileNumber(50));
		if(scoreLevelI==2) {
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(31));
		}
		if(scoreLevelI==3) {
			
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(32));
		}
		if(scoreLevelI==4) {
			
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(33));
		}
		if(scoreLevelI==5) {
			
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(34));
		}
		if(scoreLevelI==6) {
			
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(35));
		}
		if(scoreLevelI==7) {
			
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(36));
		}
		if(scoreLevelI==8) {
	
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(37));
		}
		if(scoreLevelI==9) {
	
			this.LEVEL = tiles.joinToRight(LEVEL , tiles.getTileNumber(38));
		}
		 
		
		
		this.LEVEL =tiles.resize(this.LEVEL, new Dimension(50,18));		
		return this.LEVEL;
	}
	
	


	

	private boolean draw() {
		if(draw_nb < 3) {
			BufferedImage img = level();			
			Graphics g;
			try {
				g = gamePanel.getGraphics();
				if ((g != null) && ( level() != null))
					g.drawImage(img,150, 250, 250, 50, null);
				Toolkit.getDefaultToolkit().sync();  
				g.dispose();
			}
			catch (Exception e)
			{ System.out.println("Graphics error: " + e);  }
			
			draw_nb++;
			return true;
		}
		else {
			draw_nb = 0;
			return false;
		}
	}
	

	
	private void drawOrDie() {
		if(!draw()) {
			this.stopThread();
		}
	}
	
	

}
