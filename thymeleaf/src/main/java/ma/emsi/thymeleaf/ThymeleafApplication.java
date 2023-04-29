package ma.emsi.thymeleaf;

import ma.emsi.thymeleaf.entities.Patient;
import ma.emsi.thymeleaf.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ThymeleafApplication {

    public static void main(String[] args) {

        SpringApplication.run(ThymeleafApplication.class, args);
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "Siham", new Date(), true, 278));
            patientRepository.save(new Patient(null, "Saad", new Date(), false, 112));
            patientRepository.save(new Patient(null, "Reda", new Date(), false, 244));
            patientRepository.save(new Patient(null, "Karim", new Date(), true, 198));
            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
