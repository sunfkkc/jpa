package jpa.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Entity
@Table(name = "board")
@SequenceGenerator(name = "board_seq_generator",sequenceName = "board_seq",allocationSize = 1)
public class SequenceBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * .
     * .
     * .
     */
}
