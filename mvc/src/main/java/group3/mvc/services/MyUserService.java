package group3.mvc.services;

import group3.mvc.model.MyUser;
import group3.mvc.model.RelationRequest;
import group3.mvc.services.connection.Connection;
import group3.mvc.services.implementation.IMyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MyUserService implements IMyUser {
    private WebClient wCu = new Connection('u').getClient();

    @Override
    public ResponseEntity<String> createU(MyUser myUser) {
        ResponseEntity<String> rCu = wCu.post()
                .body(Mono.just(myUser),MyUser.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rCu;
    }

    @Override
    public ResponseEntity<MyUser[]> listAllUsers() {
        ResponseEntity<MyUser[]> rLAu = wCu.get()
                .retrieve()
                .toEntity(MyUser[].class)
                .block();
        return rLAu;
    }

    @Override
    public ResponseEntity<MyUser> readU(Long idU) {
        ResponseEntity<MyUser> rRu = wCu.get()
                .uri("/"+idU)
                .retrieve()
                .toEntity(MyUser.class)
                .block();
        return rRu;
    }

    @Override
    public ResponseEntity<String> updateMyUser(MyUser myUser) {
        ResponseEntity<String> rUu = wCu.put()
                .body(Mono.just(myUser),MyUser.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rUu;
    }

    @Override
    public ResponseEntity<String> deleteU(Long idU) {
        ResponseEntity<String> rDu = wCu.delete()
                .uri("/"+ idU)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rDu;
    }

    ////////////////////////////////////////////////////////////////

    @Override
    public ResponseEntity<String> addC(RelationRequest rr) {
        ResponseEntity<String> rACu = wCu.post()
                .uri("/contact")
                .body(Mono.just(rr),RelationRequest.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rACu;
    }

    @Override
    public ResponseEntity<String> removeC(RelationRequest rr) {
        ResponseEntity<String> rRCu = wCu.put()
                .uri("/contact")
                .body(Mono.just(rr),RelationRequest.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rRCu;
    }

    @Override
    public ResponseEntity<String> addB(RelationRequest rr) {
        ResponseEntity<String> rABu = wCu.post()
                .uri("/block")
                .body(Mono.just(rr),RelationRequest.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rABu;
    }

    @Override
    public ResponseEntity<String> removeB(RelationRequest rr) {
        ResponseEntity<String> rABu = wCu.delete()
                .uri("/block",Mono.just(rr),RelationRequest.class)
                .retrieve()
                .toEntity(String.class)
                .block();
        return rABu;
    }
}
