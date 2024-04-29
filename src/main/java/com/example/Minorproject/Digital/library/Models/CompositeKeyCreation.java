package com.example.Minorproject.Digital.library.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompositeKeyCreation implements Serializable {
    @Id
    private int id;
    @Id
    private String name;
    @CreationTimestamp
    private Date creationOn;

}
