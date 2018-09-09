package hello.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class User {

    @Id
    @SequenceGenerator(name="users_id_seq",
            sequenceName="users_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="users_id_seq")
    @Column
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    @Column(name = "lastlogin")
    private LocalDateTime lastLogin;

    @Column(name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(value = GenerationTime.INSERT)
    @GeneratedValue(generator = "date")
    private LocalDateTime createdAt;

    @Column(name = "modified_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(value = GenerationTime.ALWAYS)
    @GeneratedValue(generator = "date")
    private  LocalDateTime modifiedAt;





}
