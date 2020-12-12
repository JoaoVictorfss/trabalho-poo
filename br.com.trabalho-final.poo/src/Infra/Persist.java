package Infra;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *@desc Inclusão de dados em um arquivo binário
 */
@SuppressWarnings("serial")
public class Persist implements Serializable{
	private static FileOutputStream arquivo = null;
	private static ObjectOutputStream  objGravar = null;
	
	public static boolean gravar(Object obj,String nomeArquivo){
		try {
			//Gera o arquivo para amazenar os objetos
			arquivo = new FileOutputStream(nomeArquivo);

			//insere os dados no arquivo
			objGravar = new ObjectOutputStream(arquivo);	
			objGravar.writeObject(obj);

			//Termina
			objGravar.flush();
			objGravar.close();
			arquivo.flush();
			arquivo.close();
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
