package kadai10＿1;

public class Hero implements Character{
	private String name;
	private int hp;
	private int atk;
	private int dfn;
	private int spd;
	private int maxhp = hp;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("名前がnullです。");
		}
		if (name.isEmpty()) { // 空の文字列をチェック
	        throw new IllegalArgumentException("Heroの名前が空白です。");
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
		if (hp > 100 ) {
			throw new IllegalArgumentException("HeroのHpが異常な値です。");
		}
		if (hp < 0) {
			hp = 0;
			//throw new IllegalArgumentException("HeroのHpが0に修正されました。");
		}
		this.hp = hp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		if (atk > 100 ) {
			throw new IllegalArgumentException("HeroのAtk異常な値です。");
		}
		if (atk < 0) {
			atk = 0;
			//throw new IllegalArgumentException("HeroのAtkが0に修正されました。");
		}
		this.atk = atk;
	}
	
	public int getDfn() {
		return this.dfn;
	}
	public void setDfn(int dfn) {
		if (dfn > 100) {
			throw new IllegalArgumentException("HeroのDfn異常な値です。");
		}
		if (dfn < 0) {
			dfn = 0;
			//throw new IllegalArgumentException("HeroのDfnが0に修正されました。");
		}
		this.dfn = dfn;
	}
	
	public int getSpd() {
		return this.spd;
	}
	public void setSpd(int spd) {
		if (spd > 100) {
			throw new IllegalArgumentException("HeroのSpd異常な値です。");
		}
		if (spd < 0) {
			spd = 0;
			//throw new IllegalArgumentException("HeroのSpdが0に修正されました。");
		}
		this.spd = spd;
	}
	
void HeroAttack(Monster monster) {
	System.out.println(this.name + "の攻撃！");
	int damage = this.atk - monster.getDfn();
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
}

void deffence() {
	System.out.println("勇者はガードした！");
	if (this.dfn > this.dfn + 20) {
		this.dfn = this.dfn + 20;
		System.out.println("これ以上防御力はあがらない");
	}
	else {
		this.dfn += this.dfn + 10;
		System.out.println("防御力が10上がった！");
	}
}


void heal() {
	System.out.println("勇者は祈りをささげた！");

	if (this.hp > this.maxhp) {
		this.hp = this.maxhp;
		System.out.println("勇者の体力が全快した！");
		
	}
	else {
		this.hp += 10;
		System.out.println("勇者の体力が"+this.hp+"まで回復した！");
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
