package com.candidate;

import com.candidate.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Long> {

	Candidate findByEmail(String email);

 // List<com.candidate.Candidate> findByEamailId(String email);

}