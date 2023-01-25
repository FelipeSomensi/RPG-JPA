package fichaRpg.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemCompra {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(name = "preco_unitario")
		private double precoUnitario;
		private int quantidade;
		
		@ManyToOne
		private Compra compra;
		@ManyToOne
		private Arma arma;
		
		public ItemCompra(int quantidade, Compra compra, Arma arma) {
			super();
			this.quantidade = quantidade;
			this.compra = compra;
			this.arma = arma;
			this.precoUnitario = arma.getValorCompra();
		}
		
		public ItemCompra() {
			
		}
		
		public void setCompra(Compra compra) {
			this.compra = compra;
		}
		
		public Compra getCompra() {
			return compra;
		}

		public double getValor() {
			
			return precoUnitario * quantidade; 
		}
		
		
}
