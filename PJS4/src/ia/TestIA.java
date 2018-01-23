package ia;

import static org.junit.Assert.*;

import org.junit.Test;

import core.InterfaceIA;

public class TestIA {

	@Test
	public void test() {
		InterfaceIA ia = FactoryIA.genererIA();
		String question = "Comment allez-vous ?";
		String result = ia.genererReponse(question);
		assertEquals(result, "Her name is Caroline");
	}

}
