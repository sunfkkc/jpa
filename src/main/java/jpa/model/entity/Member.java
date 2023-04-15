package jpa.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue
    private Long memberId;

    private String name;
    private String city;
    private String street;
    private String zipcode;
    @Builder
    public Member(String name, String city, String street, String zipcode) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
