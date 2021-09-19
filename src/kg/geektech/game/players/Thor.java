package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{

    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);
    }
    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
        if (RPG_Game.random.nextInt(2)==1){
            System.out.println("Thor deafen the Boss");
            boss.setDeafen(true);
        }else{
            boss.setDeafen(false);
        }
    }
}
