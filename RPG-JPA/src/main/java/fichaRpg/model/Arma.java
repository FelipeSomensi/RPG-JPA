package fichaRpg.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//MUDAR PARA PRODUTO GENERICO
@Entity
@Table(name = "Arma")
public class Arma {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomeArma;
	private double forcaAtaque;
	private double valorCompra;
	
	@ManyToOne
	private TipoDaArma tipoArma;
	
	
	public Arma(String nomeArma, double forcaAtaque, double valorCompra, TipoDaArma tipoDaArma) {
		this.nomeArma = nomeArma;
		this.forcaAtaque = forcaAtaque;
		this.valorCompra = valorCompra;
		this.tipoArma = tipoDaArma;
	}
	
	public Arma() {
		
	}
	
	public void setNomeArma(String nomeArma) {
		this.nomeArma = nomeArma;
	}
	
	public String getNomeArma() {
		return nomeArma;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	
	
	
	
	

}
