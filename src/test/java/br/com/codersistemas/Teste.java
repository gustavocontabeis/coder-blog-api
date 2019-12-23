package br.com.codersistemas;

import java.lang.reflect.Field;

import org.junit.Test;

import br.com.codersistemas.entity.Post;
import br.com.codersistemas.libs.utils.ReflectionUtils;
import br.com.codersistemas.libs.utils.StringUtil;

public class Teste {
	
	@Test
	public void gerarJson(){
		
		Field[] fields = ReflectionUtils.getFields(Post.class);
		for (Field field : fields) {
			System.out.print("{");
			System.out.print("atributo: '" + field.getName() + "', ");
			System.out.print("tipo: '" + field.getType().getSimpleName() + "', ");
			System.out.print("obrigatorio: true, ");
			System.out.print("tamanho: , ");
			System.out.print("nome: '" + StringUtil.nome(field.getName()) + "', ");
			System.out.print("}");
			System.out.println("");
		}
		
	}
}






















/*
 
 Tipos de dados
 
 Numeros
  
	int, long
	 
		1
		2
		10
		2019
		
	float, double
	
		1.5
		12.7
	
 textos
 	Flaviane Viel
 	
 datas
 boolean (verdadeiro / falso)
 
 
 */





class Imovel {
	String endereco;
}






















