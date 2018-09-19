package com.principal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MapInterfaceDemo {

	// args ya contiene nombres que se le han pasado en run, run aplication...
	public static void main(String[] args) {
		// un mapa es un objeto que mapea o selecciona claves con valores donde las
		// claves no pueden estar duplicadas

		// contar frecuencia de ocurriencia de cada una de las palabras que se pasan
		// como parametro en el array args
		// crear un mapa (map objet o map interface) que en las claves tengan las
		// palabras y en los valores la frecuencia de ocurrencia de
		// dichas palabras

		Map<String, Integer> m;
		m = new HashMap<>();

		// como agregar elementos a la colección
		for (String s : args) {
			// cada iteracion agrega 1 palabra en el mapa
			// el mapa posee un metodo get que se le pasa una clave (en este caso una
			// palabra, s)
			// si encuentra esa palabra en el mapa la extrae, por el contrario devuelve null
			// Retorna el valor numerico de la clave

			Integer frecuenciaOcurrencia = m.get(s);
			// introfucimos el valor con put, si la palabra no se ha introducido sera valor
			// 1, pero si ya se introdujo la palabra
			// se debe incrementar, usaremos operador ternario
			// si la frecuenciaOcurrencia == null introucimos 1, si no es null es que ya se
			// encontro, : +1
			m.put(s, (frecuenciaOcurrencia == null) ? 1 : frecuenciaOcurrencia + 1);
		}
		// recorremos el mapa y mostramos su contenido y el numero de veces que hay una
		// palabra
		// no hay ningún procesamiento intermedio
		System.out.println(m);

		// recorrer el mapa y mostrar las palabras que se repiten 3 veces o mas
		// hay tres vistas que permiten recorrer una parte del mapa en concreto
		// una vista que te de todas las claves del mapa
		// otra vista que te puede dar los valores
		// muestra los valores completos

		// for mejorado, la clave es String y el valor Integer
		// se vuelva en una variable, por ejemplo entry, la vista entryset muestra el
		// mapa completo
		for (Map.Entry<String, Integer> entry : m.entrySet()) {
			//esto muestra todo el mapa
			//System.out.println(entry);
			
			//almacenamos tanto la clave y el valor en variables
			String clave = entry.getKey();
			Integer valor = entry.getValue();
			if (valor >=3) {
				System.out.println(clave);
			} else {
				;
			
			}
			
		}
			//agrupar las personas por sexo(utilizar la clase persona y crear un listado de persona
			//creamos el listado de personas
			List<Persona> personas;
			//obtenemos el listado de personas
			personas = Persona.getPersonas();
			
			//obtengo un mapa que la clave sera el sexo
			Map<Persona.Sexo, List<Persona>> personasPorSexo;
			
			//usamos un stream para convertir el listado de personas en un flujo
			//usamos collect para que cree una nueva coleccion de otra ya existente
			personasPorSexo = personas.stream().collect(Collectors.groupingBy(Persona::getSexo));
			System.out.println(personasPorSexo);
		
			//obtener un mapa que contenga el nombre de las personas agrupado por ciudad
			Map<Persona.Ciudad, List<String>> personasPorCiudad;
			
			//el groupby va a extraer solo el nombre de las personas, llevara por tanto un mapeo, ya que 
			//no se puede convertir a String
			personasPorCiudad = personas.stream().collect(Collectors.groupingBy(Persona::getCiudad, 
					Collectors.mapping((Persona p) -> p.getNombre(), Collectors.toList())));
		}

}
