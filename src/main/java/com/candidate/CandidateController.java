package com.candidate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

    CandidateRepository candidateRepository;

    @Autowired
    public CandidateController(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Candidate> getAll() {
        return candidateRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Iterable<Candidate> create(@RequestBody Candidate candidate) {
        //if(candidate.getEmail()))

        Candidate candidateExists = candidateRepository.findByEmail(candidate.getEmail());

        System.out.println(candidateExists);

        if (candidateExists != null) {
            candidateRepository.save(candidate);
            return candidateRepository.findAll();
        }
        return candidateRepository.findAll();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public Iterable<Candidate> remove(@PathVariable long id) {
        candidateRepository.deleteById(id);

        return candidateRepository.findAll();
    }


}
