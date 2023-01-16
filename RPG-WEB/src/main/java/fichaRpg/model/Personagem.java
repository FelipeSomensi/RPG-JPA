package fichaRpg.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Personagem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer idade;
	private String classe;
	private LocalDate dataCadastro = LocalDate.now();
	
	@ManyToOne
	private Arma armaPersonagem;
	
	//@Enumerated(EnumType.STRING)//para mapear no banco essa coluna pela String do enum
	@ManyToOne //Muitos para um //referente a interação entre tabelas
	private TipoDePersonagem tipoDePersonagem; 

	public Personagem(Integer id, String nome, int idade, String classe,TipoDePersonagem tipoDePersonagem ) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.classe = classe;
		this.tipoDePersonagem = tipoDePersonagem;
		
	}
	
	public Personagem() {
		
	}
	
	public void setArmaPersonagem(Arma armaPersonagem) {
		this.armaPersonagem = armaPersonagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Personagem [id=" + id + ", nome=" + nome + ", classe=" + classe + "]";
	}

	

}
