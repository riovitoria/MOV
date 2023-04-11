package model;

public class JavaBeans {
	private String idcon;
	private String nome;
	private String prio1;
	private String prio2;
	private String prio3;
	private String prio4;
	private String prio5;

	public JavaBeans() {
		super();
	}

	public JavaBeans(String idcon, String nome, String prio1, String prio2, String prio3, String prio4, String prio5) {
		super();
		this.idcon = idcon;
		this.nome = nome;
		this.prio1 = prio1;
		this.prio2 = prio2;
		this.prio3 = prio3;
		this.prio4 = prio4;
		this.prio5 = prio5;
	}

	public String getIdcon() {
		return idcon;
	}
	public void setIdcon(String idcon) {
		this.idcon = idcon;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPrio1() {
		return prio1;
	}
	public void setPrio1(String prio1) {
		this.prio1 = prio1;
	}
	public String getPrio2() {
		return prio2;
	}
	public void setPrio2(String prio2) {
		this.prio2 = prio2;
	}
	public String getPrio3() {
		return prio3;
	}
	public void setPrio3(String prio3) {
		this.prio3 = prio3;
	}
	public String getPrio4() {
		return prio4;
	}
	public void setPrio4(String prio4) {
		this.prio4 = prio4;
	}
	public String getPrio5() {
		return prio5;
	}
	public void setPrio5(String prio5) {
		this.prio5 = prio5;
	}
}
