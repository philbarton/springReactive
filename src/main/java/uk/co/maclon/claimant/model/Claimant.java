package uk.co.maclon.claimant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Document
public class Claimant {
    @Id
    private String id;
    @NonNull
    private String nino;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private Title title;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;

    private String middleName;
    @NonNull
    private Gender gender;
    @NonNull
    private RelationshipStatus relationshipStatus;
    @NonNull
    private Boolean hasPartner;
    @NonNull
    private Boolean hasSavings;
}
