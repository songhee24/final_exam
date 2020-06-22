package com.example.demo.entity;

import com.example.demo.enam.HTTP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exam_log")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long Id;

    @Column(name = "count")
    int count;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date")
    Date date ;

    @Column(name = "HTTP")
    @Enumerated(EnumType.STRING)
    HTTP http;

}
