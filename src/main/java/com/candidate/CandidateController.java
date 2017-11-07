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
    public Iterable getAll() {
        return candidateRepository.findAll().st;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Iterable create(@RequestBody Candidate candidate) {
        candidateRepository.save(candidate);
        return candidateRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Iterable remove(@PathVariable long id) {
        candidateRepository.deleteById(id);
        return candidateRepository.findAll();
    }

    @RequestMapping(value = "/soft/{id}", method = RequestMethod.GET)
    public Iterable softDelete(@PathVariable long id) {
        Optional byId = candidateRepository.findById(id);
        Candidate can = (Candidate) byId.get();
        System.out.println(can.getIsActive());
        can.setIsActive(false);
        System.out.println(can.getIsActive());
        candidateRepository.save(can);
        System.out.println(byId);
        return candidateRepository.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Iterable update(@RequestBody Candidate candidat, @PathVariable long id) {
        Optional byId = candidateRepository.findById(id);
        Candidate can = byId.get();
        System.out.println(candidat.getCandidateName());
        can.setCandidateName(candidat.getCandidateName());
        System.out.println(candidat.getEmail());
        can.setEmail(candidat.getEmail());
        candidateRepository.save(can);
        System.out.println(byId);
        return candidateRepository.findAll();

    }

}