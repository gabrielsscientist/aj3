package br.com.globalcode.aj3.teste;

import java.util.Date;

public class TestePrintf {

	public static void main(String[] args) {

		Date data = new Date();
		System.out.printf("%1$td/%1$tm/%1$tY %n", data);

		int i = 101;
		System.out.printf("Inteiro = %06d %n" , i);

		double numero = 23.45;
		System.out.printf("Decimal = %5.2f", numero);
	}
}
