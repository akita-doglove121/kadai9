package kadai10＿1;

public class SuperHero extends Hero{
	public void HeroAttack(Monster monster) {
		
		System.out.println(getName() + "の攻撃！");
		int damage = getAtk() - monster.getDfn();
		if ( damage < 0) {
			damage = 0;
		}
		int newMhp = monster.getHp() -damage;
		if (newMhp < 0) {
			newMhp= 0;
		}
		monster.setHp(newMhp);
		System.out.println(monster.getName() + "に" + damage + "のダメージを与えた！");
		monster.status();
		System.out.println("さらに追加攻撃！");
		super.HeroAttack(monster);
		
	}

}
