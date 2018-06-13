package uk.co.maclon.claimant.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import uk.co.maclon.claimant.model.Claimant;
import uk.co.maclon.claimant.repository.ClaimantRepository;

import java.util.Optional;

@Component
public class Handler {
    private ClaimantRepository repository;

    @Autowired
    public Handler(ClaimantRepository repository) {
        this.repository = repository;
    }

    Mono<ServerResponse> findByNino(ServerRequest request) {
        String nino = request.pathVariable("nino");
        return ServerResponse.ok().body(repository.findByNino(nino), Claimant.class);
    }

    Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().body(repository.findAll(), Claimant.class);
    }

    Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Claimant> claimantMono = serverRequest.bodyToMono(Claimant.class);
        return ServerResponse.status(HttpStatus.CREATED).body(claimantMono.flatMap(repository::save), Claimant.class);
    }
}
