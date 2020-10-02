package br.com.globalcode.aj3.datas;

//a) importação de bibliotecas
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormataDatas {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.DATE, 3);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.YEAR, 1997);
		cal.set(Calendar.HOUR_OF_DAY, 18);
		cal.set(Calendar.MINUTE, 57);
		cal.set(Calendar.SECOND, 0);

		Date data = cal.getTime();
		System.out.println("data: " + data);

		SimpleDateFormat formatador = new SimpleDateFormat("dd/MMM/yy HH'h'mm'm's");

		System.out.println("\ndata formatada (SimpleDateFormat): "
				+ formatador.format(data));
		System.out.println("data atual formatada (SimpleDateFormat): "
				+ formatador.format(new Date()));

		// f) Construcao do objeto para formatacao padrao
		DateFormat formatador2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("\ndata formatada (DateFormat): "
				+ formatador2.format(data));
		System.out.println("data atual formatada (DateFormat:) "
				+ formatador2.format(new Date()));
	}
}
