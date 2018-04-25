package dl;


public class GenerarNumAleatorio {

	java.util.Date utilDate = new java.util.Date(); //fecha actual
	long lnMilisegundos = utilDate.getTime();
	java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
	private String numRandom;
	private String aux;
	private String[] array;
	
	
	public String opera(){
		
	aux=String.valueOf(sqlTime);
	array=aux.split(":");
	numRandom=array[0]+array[1]+array[2];
	
	return numRandom;
	}



	
	
}
