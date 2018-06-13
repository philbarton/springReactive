package uk.co.maclon.claimant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document
public class Claimant {
    @Id
    private String id;
    @NonNull
    private final String nino;
    @NonNull
    private final LocalDate dateOfBirth;
    @NonNull
    private final Title title;
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
    private String middleName;
    @NonNull
    private final Gender gender;
    @NonNull
    private final RelationshipStatus relationshipStatus;
    @NonNull
    private final Boolean hasPartner;
    @NonNull
    private final Boolean hasSavings;
}
