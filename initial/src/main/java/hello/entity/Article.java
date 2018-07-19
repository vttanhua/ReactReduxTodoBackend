package hello.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Article")
@Data
public class Article {

    @Id
    @SequenceGenerator(name="article_id_seq",
            sequenceName="article_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="article_id_seq")
    @Column
    private Long id;
    @Column
    private String title;

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

    public Article copy(Article source){
        this.setTitle(source.getTitle());
        return this;
    }

    public Article(){

    }

    public Article(String title){
        this.title = title;
    }

}
