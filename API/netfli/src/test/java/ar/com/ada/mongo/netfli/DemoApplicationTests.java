package ar.com.ada.mongo.netfli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ada.mongo.netfli.entities.Episodio;
import ar.com.ada.mongo.netfli.entities.Serie;
import ar.com.ada.mongo.netfli.entities.Temporada;
import ar.com.ada.mongo.netfli.services.SerieService;
import ar.com.ada.mongo.netfli.services.SerieService.SerieValidationType;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	SerieService service;

	@Test
	void contextLoads() {
	}

	@Test
	void verificarSerie() {
	

		Serie serie = new Serie();
		

		SerieValidationType validationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.SERIE_DATOS_INVALIDOS, validationType);

	}

	@Test
	void verificarSerieTempDuplicada() {
		

		Serie serie = new Serie();
		serie.setNombre("Breaking Bad");
		serie.setAño(2008);
		serie.setGenero("Drama");
		Temporada temporada = new Temporada();

		temporada.setNumeroTemporada(3);

		serie.getTemporadas().add(temporada);
		
		Episodio e = new Episodio();

		temporada.getEpisodios().add(e);
		
		Temporada temporada2 = new Temporada();

		temporada2.setNumeroTemporada(3);
		
		serie.getTemporadas().add(temporada2);
		
		e = new Episodio();

		temporada2.getEpisodios().add(e);
		

		SerieValidationType serieValidationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.TEMPORADA_DUPLICADA, serieValidationType);

	}

	@Test 
	void verificarTemporadaNula() {

		Serie serie = new Serie ();
		serie.setNombre("Breaking Bad");
		serie.setAño(2008);
		serie.setGenero("Drama");
		serie.setTemporadas(null);

		SerieValidationType serieValidationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.TEMPORADAS_NULA, serieValidationType);

	}

	@Test
	void verificarTemporadaVacia() {

		Serie serie = new Serie ();
		serie.setNombre("Breaking Bad");
		serie.setAño(2008);
		serie.setGenero("Drama");
		serie.setTemporadas(new ArrayList<>());

		SerieValidationType serieValidationType = service.verificarSerie(serie);
		
		assertEquals(SerieValidationType.TEMPORADAS_VACIA, serieValidationType);
	}



}
