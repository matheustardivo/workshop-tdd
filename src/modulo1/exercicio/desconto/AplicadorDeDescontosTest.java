package modulo1.exercicio.desconto;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AplicadorDeDescontosTest {

	private AplicadorDeDescontos aplicadorDeDescontos;

	@Before
	public void setup() {
		aplicadorDeDescontos = new AplicadorDeDescontos();
	}

	@Test
	public void testDescontoPorProduto15Porcento() {
		Item macbook = new Item("MACBOOK", 1, 4000.0);
		Item iphone = new Item("IPHONE", 1, 2000.0);

		assertAplicacaoDesconto(0.15, macbook, iphone);
	}

	@Test
	public void testDescontoPorProduto12Porcento() {
		Item notebook = new Item("NOTEBOOK", 1, 2000.0);
		Item windowsPhone = new Item("WINDOWS PHONE", 1, 1500.0);

		assertAplicacaoDesconto(0.12, notebook, windowsPhone);
	}

	@Test
	public void testDescontoPorProduto70Porcento() {
		Item xbox = new Item("XBOX", 1, 800.0);

		assertAplicacaoDesconto(0.7, xbox);
	}

	@Test
	public void testDescontoPorValor2Porcento() {
		Item item = new Item("OPA", 1, 800.0);

		assertAplicacaoDesconto(0.02, item);
	}

	@Test
	public void testDescontoPorValor5Porcento() {
		Item item = new Item("OPA", 4, 1000.0);

		assertAplicacaoDesconto(0.05, item);
	}

	@Test
	public void testDescontoPorValor6Porcento() {
		Item item = new Item("OPA", 5, 1000.0);

		assertAplicacaoDesconto(0.06, item);
	}

	public void assertAplicacaoDesconto(double desconto, Item... itens) {
		Compra compra = new Compra(Arrays.asList(itens));

		double valorLiquidoComDesconto = compra.getValorLiquido()
				- (compra.getValorLiquido() * desconto);

		aplicadorDeDescontos.aplica(compra);
		Assert.assertEquals(valorLiquidoComDesconto, compra.getValorLiquido(),
				0.0001);
	}
}
