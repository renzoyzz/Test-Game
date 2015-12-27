package entity.item;



abstract class Equipable extends Item
{
	private EquipType equipableType;
	private EquipQuality equipableQuality;
	//Not Quest
	public Equipable(EquipType type)
	{
		super(Type.EQUIPABLE);
		equipableType = type;
		equipableQuality = EquipQuality.randomize();
	}
	//Quest
	public Equipable(EquipType type, EquipQuality quality, String name, 
			Rarity rarity, int level)
	{
		super(Type.EQUIPABLE, name, rarity, level);
		equipableType = type;
		equipableQuality = quality;
	}
	
	public EquipType getEquipType()
	{
		return equipableType;
	}
	
	public EquipQuality getEquipQuality()
	{
		return equipableQuality;
	}
}
