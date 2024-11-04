package kadai10＿1;
import java.util.*;
public class Monster implements Character{
	String name;
	private int hp;
	private int atk;
	private int dfn;
	private int spd;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("名前がnullです。");
		}
		if (name.isEmpty()) { // 空の文字列をチェック
	        throw new IllegalArgumentException("Monsterの名前が空です。");
	    }
		if (name.length() < 3 || name.length() >= 10) {
			throw new IllegalArgumentException("名前を３文字以上10文字以下に修正してください。");
		}
		this.name = name;
	}
	
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		if (hp > 100) {
			throw new IllegalArgumentException("MonsterのHpが異常な値です。");
		}
		if (hp < 0) {
			hp = 0;
			//throw new IllegalArgumentException("MonsterのHpが0に修正されました。");
		}
		this.hp = hp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		if (atk > 100) {
			throw new IllegalArgumentException("MonsterのAtkが異常な値です。");
		}
		if (atk < 0) {
			atk = 0;
			//throw new IllegalArgumentException("MonsterのAtkが0に修正されました。");
		}
		this.atk = atk;
	}
	
	public int getDfn() {
		return this.dfn;
	}
	public void setDfn(int dfn) {
		if (dfn > 100) {
			throw new IllegalArgumentException("MonsterのDfnが異常な値です。");
		}
		if (dfn < 0) {
			dfn = 0;
			//throw new IllegalArgumentException("MonsterのDfnが0に修正されました。");
		}
		this.dfn = dfn;
	}
	
	public int getSpd() {
		return this.spd;
	}
	public void setSpd(int spd) {
		if (spd > 100) {
			throw new IllegalArgumentException("MonsterのSpdが異常な値です。");
		}
		if (spd < 0) {
			spd = 0;
			//throw new IllegalArgumentException("MonsterのSpdが0に修正されました。");
		}
		this.spd = spd;
	}
	
void attack(Hero hero , Magician magician) {
	System.out.println(this.name + "の攻撃！");
	
	Random rdm = new Random();
	int target = rdm.nextInt(2);
	
	if(target == 0) {
		System.out.println(this.name + "は" + hero.getName() + "に攻撃した！" );
		int damage = this.atk -hero.getDfn();
		if (damage < 0) {
			damage = 0;
		}
		int newHhp = hero.getHp() -damage;
		hero.setHp(newHhp);
		System.out.println(hero.getName() + "に" + damage + "のダメージを与えた！");
		hero.status();
		
	}
	else {
		System.out.println(this.name + "は" + magician.getName() + "に攻撃した！" );
		int damage = this.atk -magician.getDfn();
		if (damage < 0) {
			damage = 0;
		}
		int newMghp = magician.getHp() - damage;
		magician.setHp(newMghp);
		System.out.println(magician.getName() + "に" + damage + "のダメージを与えた！");
		magician.status();
	}
	
}
void deffence() {
	System.out.println(this.name+"は守りを硬めた！");
	if (this.dfn > this.dfn + 20) {
		this.dfn = this.dfn + 20;
		System.out.println("これ以上防御力はあがらない");
	}
	else {
		this.dfn += this.dfn + 10;
		System.out.println("防御力が10上がった！");
	}
	
}
@Override
public int getSpeed() {
    return this.spd;
}
void status() {
    System.out.println(this.name + "のHPは " + this.hp + "だ！");
}
}
