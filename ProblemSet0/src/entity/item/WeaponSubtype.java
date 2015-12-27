package entity.item;


import java.util.Random;

public enum WeaponSubtype 
{
	AXE,	//Melee
	DAGGER,
	SWORD,
	GREATSWORD,
	CLUB,
	HAMMER,
	POLEARM,
	STAFF,
	BOW,	//Ranged
	CROSSBOW,
	THROWN,
	GUN;
	

	
	public static WeaponSubtype randomize(WeaponType wType)
	{
		switch(wType)
		{
			case MELEE:
				WeaponSubtype[] elementsM = {AXE, DAGGER, SWORD, GREATSWORD,
						CLUB, HAMMER, POLEARM};
				return elementsM[new Random().nextInt(elementsM.length)];
			case RANGED:
				WeaponSubtype[] elementsR = {BOW, CROSSBOW, THROWN, GUN};
				return elementsR[new Random().nextInt(elementsR.length)];
		}
	    throw new IllegalStateException("Error occurred during randomization");
	}
	
	public static WeaponStat randomizeStats(WeaponSubtype wsType)
	{
		switch(wsType)
		{
			case AXE:
				return WeaponSubtypeAxe.randomize();
			case DAGGER:
				return WeaponSubtypeAxe.randomize();
			case SWORD:
				return WeaponSubtypeAxe.randomize();
			case GREATSWORD:
				return WeaponSubtypeAxe.randomize();
			case CLUB:
				return WeaponSubtypeClub.randomize();
			case HAMMER:
				return WeaponSubtypeAxe.randomize();
			case POLEARM:
				return WeaponSubtypePolearm.randomize();
			case STAFF:
				return WeaponSubtypeStaff.randomize();
			case BOW:
				return WeaponSubtypeAxe.randomize();
			case CROSSBOW:
				return WeaponSubtypeAxe.randomize();
			case THROWN:
				return WeaponSubtypeAxe.randomize();
			case GUN:
				return WeaponSubtypeAxe.randomize();
		}
	    throw new IllegalStateException("Error occurred during randomization");
	}
}
