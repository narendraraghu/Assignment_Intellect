package com.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private CandidateRepository candidateRepository;

    
    @Autowired
    public DatabaseSeeder(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void run(String... args) throws Exception {


    	SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    	java.util.Date dob = df.parse("12-08-1989");
    	
    	
    	Candidate candidate = new Candidate("Narendra","Raghuwansh","email@mail.com",1234,true,dob,200.4,3);
        candidateRepository.save(candidate);
        candidateRepository.save(new Candidate("ABC","XYX","email@mail.com",1234,true,dob,130.4,3));
        candidateRepository.save(new Candidate("UQW","PQR","email@mail.com",1234,true,dob,90.4,3));

        candidateRepository.save(candidate);
    }
}
