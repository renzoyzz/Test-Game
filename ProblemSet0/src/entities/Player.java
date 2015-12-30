package entities;

import handler.Handler;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import entity.item.Weapon;

public class Player extends Entity{

	private AnimationState animationState = AnimationState.DOWN;
	private AnimationActive animationActive = AnimationActive.IDLE;
	
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id, handler);
		this.velocity = 10;
		this.width = 50;
		this.height = 50;
		try {
			img = ImageIO.read(new File("C:\\Users\\Renzo\\workspace\\TestGame\\ProblemSet0\\src\\sprites\\EnemySpriteSheet1.png"));
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	


	public void tick() {
		this.movePlayer();
		this.collision();
		
	}
	
	
	
	private void movePlayer(){
		if(this.moveDirection[0]){
			this.yPos -= this.velocity;
			this.animationState = AnimationState.UP;
		} else if(this.moveDirection[1]){
			this.yPos += this.velocity;
			this.animationState = AnimationState.DOWN;
		}
		
		if(this.moveDirection[2]){
			this.xPos += this.velocity;
			this.animationState = AnimationState.RIGHT;
		} else if(this.moveDirection[3]){
			this.xPos -= this.velocity;
			this.animationState = AnimationState.LEFT;
		}
	}
	
	public void render(Graphics g) {
		System.out.println(this.animationState);
		switch(this.animationState){
		case UP:
			
			g.drawImage(this.img, this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, 5, 97, 28, 126, null);
			
			break;
		case DOWN:
			g.drawImage(this.img, this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, 5, 0, 28, 31, null);
			break;
		case LEFT:
			g.drawImage(this.img, this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, 5, 32, 28, 65, null);
			break;
		case RIGHT:
			g.drawImage(this.img, this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, 5, 65, 28, 97, null);
			break;
		
		
		}
		
		
		g.setColor(Color.red);
		g.drawRect(this.xPos, this.yPos, this.width, this.height);
	}
	
	protected void collision() {
		for(Entity entity : this.handler.entitiesList){
			
			if(entity.getId() == ID.Loot){
				
				//Player touches loot
				if(this.getBounds().intersects(entity.getBounds())){
					Weapon test = new Weapon();
					String iType;
					switch(test.getItemType())
					{
						case EQUIPABLE: 	iType = "Equipable"; 	break;
						case CONSUMABLE: 	iType = "Consumable"; 	break;
						case OTHER:			iType = "Other";		break;
						default:			iType = "Other";		break;
					}
					String iRarity;
					switch(test.getItemRarity())
					{
						case COMMON: 		iRarity = "Common"; 	break;
						case UNIQUE: 		iRarity = "Unique"; 	break;
						case RARE:			iRarity = "Rare";		break;
						case LEGENDARY:		iRarity = "Legendary"; 	break;
						case EPIC:	 		iRarity = "Epic"; 		break;
						case QUEST:			iRarity = "Quest";		break;
						default:			iRarity = "Common";		break;
					}
					String iName = test.getItemName();
					String iLevel = String.valueOf(test.getItemLevel());
					String iQuest = String.valueOf(test.isQuestItem());
					String iPrice = String.valueOf(test.getItemPrice());
					
					System.out.println("Name: "+iName+"\nType: "+iType+"\nRarity: "+iRarity+
							"\nLevel: "+iLevel+"\nQuest Item: "+iQuest+"\nPrice: $"+iPrice+
							"\n\nEquip Type: "+test.getEquipType()+"\nEquip Quality: "+
							test.getEquipQuality()+"\n\nWeapon Type: "+test.getWeaponType()+
							"\nWeapon Subtype: "+test.getWeaponSubtype()+"\n\nDamage: "+
							test.getDamage()+"\nAttack Speed: "+test.getAttackSpeed()+
							"\nAccuracy: "+test.getAccuracy()+"\n\nTwo Handed? "+
							test.isTwoHanded()+"\nQuest Item? "+test.isQuestItem());
					this.handler.entitiesList.remove(entity);
						System.out.println("touching");
					
				}
			}
			
			
		}
	}
	
	

	
	
	
	
	



	

}
