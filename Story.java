package kadai10＿1;
import java.util.*;
public class Story {
	public static void main(String [] args) {
		
		//Scanner sc1 = new Scanner (System.in);
		//勇者の作成
	    SuperHero hero =new SuperHero();
	    hero.setName("ゆうしゃ1");
	    hero.setHp(25);
	    hero.setAtk(8);
	    hero.setDfn(2);
	    hero.setSpd(5);

		
	    System.out.println("勇者" + hero.getName() + "が誕生した！");
	    System.out.println("体力は" + hero.getHp() + "だ");
	    System.out.println("攻撃力は" + hero.getAtk() + "だ");
	    System.out.println("防御力は" + hero.getDfn() + "だ");
	    System.out.println("素早さは" +hero.getSpd() + "だ");
		
		//Scanner sc3 = new Scanner(System.in);
		//魔法使いの作成
	    SuperMagician magician =new SuperMagician();
	
	
	    magician.setName("魔法使い1");
	    magician.setHp(25);
	    magician.setAtk(7);
	    magician.setDfn(1);
	    magician.setSpd(3);
	    magician.setMp(30);

	    System.out.println("魔法使い" + magician.getName() + "が誕生した！");
	    System.out.println("体力は" + magician.getHp() + "だ");
	    System.out.println("攻撃力は" + magician.getAtk() + "だ");
	    System.out.println("防御力は" + magician.getDfn() + "だ");
	    System.out.println("素早さは" + magician.getSpd() + "だ");
	    System.out.println("MPは" + magician.getMp() + "だ");
		
		//Scanner sc2 = new Scanner(System.in);
		//モンスターの作成
	    SuperMonster monster =new SuperMonster();
	    
	    monster.setName("ドラゴン");
	    monster.setHp(100);
	    monster.setAtk(8);
	    monster.setDfn(2);
	    monster.setSpd(4);

		
	    System.out.println("モンスターの" + monster.getName() + "が誕生した！");
	    System.out.println( monster.getName() + "の体力は" + monster.getHp() + "だ");
	    System.out.println( monster.getName() + "の攻撃力は" + monster.getAtk() + "だ");
	    System.out.println( monster.getName() + "の防御力は" + monster.getDfn() + "だ");
	    System.out.println( monster.getName() + "素早さは" + monster.getSpd() + "だ");
		
        //戦闘
	    ArrayList<Character> turnOrder = new ArrayList <>();
	    turnOrder.add(hero);
	    turnOrder.add(magician);
	    turnOrder.add(monster);
		//戦闘の順番を決める
	    turnOrder.sort(Comparator.comparingInt(Character::getSpeed).reversed());
		
        System.out.println("戦闘開始！！");
        
        while(true) {
    	    for (Character character : turnOrder) {
    		    if (hero.getHp() <= 0 || magician.getHp() <= 0) {
    			    System.out.println("勇者たちは敗北した・・・");
                    return; // ゲーム終了get
                    } else if (monster.getHp() <= 0) {
                	    System.out.println("勇者たちは勝利した！");
                        return; // ゲーム終了
                    }
            	if (character instanceof SuperHero) {
            		SuperHero h = (SuperHero) character;
            		hero.HeroAttack(monster);
            	}
            	else if (character instanceof SuperMagician) {
            		SuperMagician mg = (SuperMagician) character;
            		magician.MagicianAttack(monster);
            	}
            	else if (character instanceof SuperMonster) {
                    Monster mon = (SuperMonster) character;
                    monster.attack(hero, magician); 
            	}
            }
        }
	}
}
