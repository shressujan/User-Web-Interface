package edu.unk.cs406.user.validation;

import org.junit.Assert;
import org.junit.Test;

public class ValidationPatternsUnitTest {

	/**
	 * Test one or more number pattern validation.
	 */
	@Test
	public void testNumberExpression() {
		Assert.assertFalse("No Numbers", "aeouau!@%@AEOUAEO".matches(ValidationPatterns.NUMBER_PATTERN));
		Assert.assertTrue("Numbers", "21412414151".matches(ValidationPatterns.NUMBER_PATTERN));
	}
	
	/**
	 * Test one or more lowercase letter pattern validation.
	 */
	@Test
	public void testLowercaseExpression() {
		Assert.assertFalse("No Lowercase", "AOEUAU124$!@$".matches(ValidationPatterns.LOWERCASE_PATTERN));
		Assert.assertTrue("Lowercase", "aeouoauaeuoa".matches(ValidationPatterns.LOWERCASE_PATTERN));
	}
	
	/**
	 * Test one or more uppercase letter pattern validation.
	 */
	@Test
	public void testUppercaseExpression() {
		Assert.assertFalse("No Uppercase", "aeou21s%#@".matches(ValidationPatterns.UPPERCASE_PATTERN));
		Assert.assertTrue("Uppercase", "AOEUAaoeuaAOE214(*@!$".matches(ValidationPatterns.UPPERCASE_PATTERN));
	}
	
	/**
	 * Test one or more symbol pattern validation.
	 */
	@Test
	public void testSymbolExpression() {
		Assert.assertFalse("No Symbols", "aeou123AOEUA".matches(ValidationPatterns.SYMBOL_PATTERN));
		Assert.assertTrue("Symbols", "!@$!@$!@$!@!%%#$(_&^".matches(ValidationPatterns.SYMBOL_PATTERN));
	}
	
	/**
	 * Test email pattern validation.
	 */
	@Test
	public void testEmailExpression() {
		Assert.assertFalse("Website", "https://www.google.com".matches(ValidationPatterns.EMAIL_PATTERN));
		Assert.assertFalse("Name", "Eduardo Salas".matches(ValidationPatterns.EMAIL_PATTERN));
		Assert.assertTrue("solace32@lopers.com", "solace32@lopers.com".matches(ValidationPatterns.EMAIL_PATTERN));
		Assert.assertTrue("salase2@gmail.com", "salase2@gmail.com".matches(ValidationPatterns.EMAIL_PATTERN));
		Assert.assertTrue("eduardoSalas@outlook.com", "eduardoSalas@outlook.com".matches(ValidationPatterns.EMAIL_PATTERN));
		Assert.assertTrue("owls@gmail.com", "owls@gmail.com".matches(ValidationPatterns.EMAIL_PATTERN));		
	}
}