package it.dstech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.mysql.cj.jdbc.Blob;

@Entity
public class Eroe {
	@Id
	private String nome;
	@Lob
	@Column(columnDefinition = "LONGBLOB NOT NULL")
	private String image;
	
	private String heroPower;
	public Eroe() {
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Eroe [nome=" + nome + ", image=" + image + ", heroPower=" + heroPower + "]";
	}
	public String getHeroPower() {
		return heroPower;
	}
	public void setHeroPower(String heroPower) {
		this.heroPower = heroPower;
	}


}
