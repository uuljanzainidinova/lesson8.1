package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Antman extends Hero{
    public Antman(int health, int damage) {
        super(health, damage, SuperAbility.ANTMAN);
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {
      switch (RPG_Game.random.nextInt(2)+1){
          case 1 :
              this.setHealth(getHealth()+40);
              this.setDamage(getDamage()+ 40);
              System.out.println("Antman увеличелся на 40 метров");
              break;
          case 2 :
              this.setHealth(getHealth()-40);
              this.setDamage(getDamage()- 40);
              System.out.println("Antman уменьшился на 40 метров");
      }
    }
}
