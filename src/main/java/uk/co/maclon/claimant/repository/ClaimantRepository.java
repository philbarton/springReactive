package uk.co.maclon.claimant.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import uk.co.maclon.claimant.model.Claimant;

@Repository
public interface ClaimantRepository extends ReactiveCrudRepository<Claimant, String> {

    @Query("{ 'nino': ?0 }")
    Mono<Claimant> findByNino(String nino);
}
