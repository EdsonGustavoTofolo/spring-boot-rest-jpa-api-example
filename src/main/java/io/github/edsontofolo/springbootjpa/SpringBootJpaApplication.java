package io.github.edsontofolo.springbootjpa;

import io.github.edsontofolo.springbootjpa.entity.ComplementoAnuario;
import io.github.edsontofolo.springbootjpa.entity.ComplementoAnuarioRamoUrl;
import io.github.edsontofolo.springbootjpa.repository.ComplementoAnuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(@Autowired ComplementoAnuarioRepository complementoAnuarioRepository){
        return args -> {
            System.out.println("Salvando Complementos");
            ComplementoAnuarioRamoUrl complementoAnuarioRamoUrl1 = new ComplementoAnuarioRamoUrl();
            complementoAnuarioRamoUrl1.setUrl("http://www.complementoanuariourls.com/1");

            ComplementoAnuarioRamoUrl complementoAnuarioRamoUrl11 = new ComplementoAnuarioRamoUrl();
            complementoAnuarioRamoUrl11.setUrl("http://www.complementoanuariourls.com/1.1");

            ComplementoAnuarioRamoUrl complementoAnuarioRamoUrl2 = new ComplementoAnuarioRamoUrl();
            complementoAnuarioRamoUrl2.setUrl("http://www.complementoanuariourls.com/2");

            ComplementoAnuario complementoAnuario1 = new ComplementoAnuario();
            complementoAnuario1.setTexto("Some text here");
            complementoAnuario1.setUrl("http://www.complementoanuario.com/1");
            complementoAnuario1.addComplementoAnuarioRamoUrl(complementoAnuarioRamoUrl1);
            complementoAnuario1.addComplementoAnuarioRamoUrl(complementoAnuarioRamoUrl11);

            ComplementoAnuario complementoAnuario2 = new ComplementoAnuario();
            complementoAnuario2.setTexto("Some text here2");
            complementoAnuario2.setUrl("http://www.complementoanuario.com/2");
            complementoAnuario2.addComplementoAnuarioRamoUrl(complementoAnuarioRamoUrl2);

            complementoAnuarioRepository.save(complementoAnuario1);
            complementoAnuarioRepository.save(complementoAnuario2);

            List<ComplementoAnuario> complementos = complementoAnuarioRepository.findAll();
            complementos.forEach(System.out::println);

        };
    }


}
