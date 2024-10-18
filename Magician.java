package kadai9;

public class Magician implements Character{
	String name;
	private int hp;
	private int atk;
	private int dfn;
	private int spd;
	private int mp;
	private int maxhp = hp;
	private int maxmp = mp;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("名前がnullです。");
		}
		if (name.isEmpty()) { // 空の文字列をチェック
	        throw new IllegalArgumentException("Magicianの名前が空です。");
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
			throw new IllegalArgumentException("MagicianのHpが異常な値です。");
		}
		if (hp < 0) {
			hp = 0;
			throw new IllegalArgumentException("MagicianのHpが0に修正されました。");
		}
		this.hp = hp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		if (atk > 100) {
			throw new IllegalArgumentException("MagicianのAtkが異常な値です。");
		}
		if (atk < 0) {
			atk = 0;
			//throw new IllegalArgumentException("MagicianのAtkが0に修正されました。");
		}
		this.atk = atk;
	}
	
	public int getDfn() {
		return this.dfn;
	}
	public void setDfn(int dfn) {
		if (dfn > 100) {
			throw new IllegalArgumentException("MagicianのDfnが異常な値です。");
		}
		if (dfn < 0) {
			dfn = 0;
			//throw new IllegalArgumentException("MagicianのDfnが0に修正されました。");
		}
		this.dfn = dfn;
	}
	
	public int getSpd() {
		return this.spd;
	}
	public void setSpd(int spd) {
		if (spd > 100) {
			throw new IllegalArgumentException("MagicianのSpdが異常な値です。");
		}
		if (spd < 0) {
			spd = 0;
			//throw new IllegalArgumentException("MagicianのSpdが0に修正されました。");
		}
		this.spd = spd;
	}
	
	public int getMp() {
		return this.mp;
	}
	public void setMp(int mp) {
		if (mp > 100 ) {
			throw new IllegalArgumentException("MagicianのMpが異常な値です。");
		}
		if (mp < 0) {
			mp = 0;
			//throw new IllegalArgumentException("MagicianのMpが0に修正されました。");
		}
		this.mp = mp;
	}
	

void str_attack(Monster monster) {//物理攻撃メソッド
	System.out.println( this.name + "の物理攻撃！");
	int damage = this.atk - monster.getDfn();
	if (damage < 0) {
		damage = 0;
	}
	int newMhp = monster.getHp() -damage;
	System.out.println(monster.getName() + "に" + this.atk + "のダメージを与えた！");
	monster.status();
	
}

void mg_attack(Monster monster) {//魔法攻撃メソッド（物理に攻撃を一時的に強化付与）
	System.out.println( this.name + "は攻撃魔法を唱えた！");
	this.atk += 3;
	int damage = this.atk - monster.getDfn();
	if ( damage < 0) {
		damage = 0;
	}
	int newMhp = monster.getHp() - damage;
	monster.setHp(newMhp);
	System.out.println(monster.name + "に" + damage + "のダメージを与えた！");
	System.out.println("MPを3消費した。");
	this.mp -=3;
	System.out.println("残りMPは" + this.mp + "だ！");
	this.atk -=3;
	monster.status();
}

void mg_heal() {//回復魔法メソッド
	System.out.println( this.name + "は回復魔法を唱えた");
	
	if (this.hp > this.maxhp) {
		this.hp = this.maxhp;
	}
	else {
		System.out.println("体力が5回復した");
		this.hp += 5;
	}
	System.out.println("MPを2消費した。");
	this.mp -= 2;
	
}

void meditation() {
	System.out.println( this.name + "は瞑想した！");
	System.out.println("MPが全快した！");
	this.mp = this.maxmp;
	
}
@Override
public int getSpeed() {
    return this.spd;
}
void status() {
    System.out.println(this.name + "のHPは " + this.hp + "だ！");
}
}
