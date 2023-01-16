package fichaRpg.model;

import java.math.BigDecimal;

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
		
		private BigDecimal PecoUnitario;
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
		}
		
		public ItemCompra() {
			
		}
		
		
		
}
