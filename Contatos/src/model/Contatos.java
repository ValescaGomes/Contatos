package model;

public class Contatos {
	private int id;
	private String nome;
	private String eMail;
	private String telefone;
	
	//facilita a visualização do estado do objeto
	@Override
	public String toString() {
		return "Contatos: [ID=" + id + ", Nome=" + nome + ", E-Mail=" + eMail + ", Telefone=" + telefone + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
