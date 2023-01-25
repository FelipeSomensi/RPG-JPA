package fichaRpg.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.FetchTiming;

@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name = "valor_total") //define o nome de uma coluna
	private BigDecimal valorTotal = BigDecimal.ZERO;
	private LocalDate data = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)//Boa pratica para todo o caregamento manyToOne
	private Personagem personagem;
												//cascade replica todo ação da tabela compra para a tabbela item compra
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL) //Este atributo esta mapeado pela "compra" da class ItemCompra //se tiver um relacionamento bidericional isso é necessario 
	private List<ItemCompra> itens = new ArrayList<>(); //Boa pratica inicilizar a lista
	
	public Compra(Personagem personagem) {
		this.personagem = personagem;
	}

	public Compra() {
		
	}
	
	public void adicionarArma(ItemCompra item) {
		item.setCompra(this);
		this.getItens().add(item);
		//item conhece o pedido e o pedido conhece o item
		
		this.valorTotal = this.valorTotal.add(new BigDecimal(item.getValor()));
		
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemCompra> itens) {
		this.itens = itens;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	
	 
	
}
