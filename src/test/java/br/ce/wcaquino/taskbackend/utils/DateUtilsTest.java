package br.ce.wcaquino.taskbackend.utils;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	@Test
	public void deveRetornarTrueParaDataFuturas() {
		LocalDate data = LocalDate.of(2030, 1, 1);
		Assert.assertTrue(DateUtils.isEqualOrFutureDate(data));
	}
	
	@Test
	public void deveRetornarFalseParaDataPassadas() {
		LocalDate data = LocalDate.of(2010, 1, 1);
		Assert.assertFalse(DateUtils.isEqualOrFutureDate(data));
	}

}
