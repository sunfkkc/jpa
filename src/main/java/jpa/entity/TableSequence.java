package jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;

@Entity
@Getter
@TableGenerator(name = "BOARD_SEQ_GENERATOR",table = "my_sequence",pkColumnValue = "board_seq",allocationSize = 1)
@Table(name = "board")
public class TableSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "BOARD_SEQ_GENERATOR")
    private Long id;

    /**
     * .
     * .
     * .
     */
}
