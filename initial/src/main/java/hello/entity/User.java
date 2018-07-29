package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

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
    private String password;

    @Temporal(TemporalType.DATE) private Date lastLogin;

    @Column(name = "created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(value = GenerationTime.INSERT)
    @GeneratedValue(generator = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Generated(value = GenerationTime.ALWAYS)
    @GeneratedValue(generator = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

}
