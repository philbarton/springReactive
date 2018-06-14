package uk.co.maclon.claimant.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import uk.co.maclon.claimant.model.Claimant;
import uk.co.maclon.claimant.model.Gender;
import uk.co.maclon.claimant.model.RelationshipStatus;
import uk.co.maclon.claimant.model.Title;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClaimantRepositoryTest {

    @Autowired
    ReactiveMongoTemplate template;
    @Autowired
    ClaimantRepository claimantRepository;

    @Before
    public void setUp() {
        StepVerifier.create(template.dropCollection(Claimant.class)).verifyComplete();
    }

    @Test
    public void insertOneRepo() {
        Claimant claimant = createClaimant("QQ123456C");
        Mono<Claimant> claimantMono = claimantRepository.save(claimant);
        StepVerifier.create(claimantMono).expectNextCount(1).verifyComplete();
    }

    @Test
    public void insertOneTemplate() {
        Claimant claimant = createClaimant("QQ123456C");

        Flux<Claimant> insertOne = template
                .insertAll(Flux.just(claimant).collectList());

        StepVerifier.create(insertOne).expectNextCount(1).verifyComplete();
    }

    private static Claimant createClaimant(String nino) {
        return Claimant
                .builder()
                .nino(nino)
                .dateOfBirth(LocalDate.now())
                .title(Title.MR)
                .firstName("phil")
                .lastName("barton")
                .gender(Gender.MALE)
                .hasPartner(true)
                .relationshipStatus(RelationshipStatus.MARRIED)
                .hasSavings(false)
                .build();
    }
}