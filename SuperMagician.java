package kadai10＿1;

public class SuperMagician extends Magician{
	public void MagicianAttack(Monster monster) {
		//魔法攻撃メソッド（物理に攻撃を一時的に強化付与）
		System.out.println( this.name + "は超攻撃魔法を唱えた！");
		int Special_atk = getAtk() + 3*2;
		int damage = Special_atk - monster.getDfn();
		if ( damage < 0) {
			damage = 0;
		}
		int newMhp = monster.getHp() - damage;
		monster.setHp(newMhp);
		System.out.println(monster.name + "に" + damage + "のダメージを与えた！");
		System.out.println("MPを6消費した。");
		int Special_mp = getMp() -3*2;
		System.out.println("残りMPは" + Special_mp + "だ！");
		Special_atk -=3;
		monster.status();
		}

}
