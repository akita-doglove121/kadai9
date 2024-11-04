package kadai10＿1;

import java.util.Random;

public class SuperMonster extends Monster{
	void attack(Hero hero , Magician magician) {
		System.out.println("Venom_attack メソッドが呼び出されました。");
		Random random = new Random();
		int target = random.nextInt(2);// 0ならHero、1ならMagician
		int venomChance = random.nextInt(2);// 0か1を生成して毒判定
		
		if (target == 0) {
			System.out.println(this.name + "は" + hero.getName() + "に攻撃した！" );
			int damage = getAtk()-hero.getDfn();
			if (damage < 0) {
				damage = 0;
			}
			int newHhp = hero.getHp() -damage;
			hero.setHp(newHhp);
			System.out.println(hero.getName() + "に" + damage + "のダメージを与えた！");
			if (venomChance == 1) {
				newHhp = hero.getHp() - 3;
				hero.setHp(newHhp);
				System.out.println("追加で毒のダメージを受けた！");
			}
			hero.status();
		}else {
			if (target == 1) {
				System.out.println(this.name + "は" + magician.getName() + "に攻撃した！" );
				int damage = getAtk()-magician.getDfn();
				if (damage < 0) {
					damage = 0;
				}
				int newMhp = magician.getHp() -damage;
				magician.setHp(newMhp);
				System.out.println(magician.getName() + "に" + damage + "のダメージを与えた！");
				if (venomChance == 1) {
					newMhp = magician.getHp() -3;
					magician.setHp(newMhp);
					System.out.println("追加で毒のダメージを受けた！");
				}
				magician.status();
			}
		}
	}	
}



