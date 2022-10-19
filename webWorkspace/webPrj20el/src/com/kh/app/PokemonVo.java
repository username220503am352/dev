package com.kh.app;

public class PokemonVo {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAtk() {
		return atk;
	}
	public void setAtk(String atk) {
		this.atk = atk;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	@Override
	public String toString() {
		return "PokemonVo [name=" + name + ", atk=" + atk + ", def=" + def + "]";
	}
	public PokemonVo(String name, String atk, String def) {
		super();
		this.name = name;
		this.atk = atk;
		this.def = def;
	}
	public PokemonVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String atk;
	private String def;

}
