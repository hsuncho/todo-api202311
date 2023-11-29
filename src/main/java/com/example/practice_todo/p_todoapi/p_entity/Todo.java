package com.example.practice_todo.p_todoapi.p_entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode( of = "todoId")
@Entity
@Table(name = "prac_tbl_todo")
public class Todo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String todoId;

    @Column(nullable = false)
    private String title;

    private boolean done;

    @CreationTimestamp
    private LocalDate createDate;
}
