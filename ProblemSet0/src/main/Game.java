package main;

import handler.Handler;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import keyInput.KeyInput;
import entities.ID;
import entities.Loot;
import entities.Player;

public class Game extends Canvas implements Runnable {
	
	private Handler handler;
	
	
	
	private static final long serialVersionUID = 6691247796639148462L;
	
	
	public static final int WIDTH = 1080, HEIGHT = WIDTH/12*9;
	private Thread thread;
	private boolean running = false;

	public Game() {
		this.handler = new Handler();
		this.addKeyListener(new KeyInput(this.handler));
		new Window(WIDTH, HEIGHT, "Game", this);
		this.createPlayer();
		
	}
	
	private void createPlayer(){
		this.handler.addEntity(new Player(WIDTH/2-50, HEIGHT/2-50, ID.Player, this.handler));
		this.handler.addEntity(new Loot(20,20, ID.Loot, this.handler));
		
	}
	
	public synchronized void start() {
		
		thread = new Thread(this);
		thread.start();
		running = true;
		
		
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running){
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
			
		}
		stop();
		
	}
	
	
	private void tick () {
		this.handler.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics background = bs.getDrawGraphics();
		background.setColor(Color.white);
		background.fillRect(0,0,WIDTH, HEIGHT);
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		this.handler.render(g);
		
		
		
		g.dispose();
		bs.show();
		
	}
	
	
	
	public static void main(String args[]) {
		
		new Game();
		
	}
	
}


