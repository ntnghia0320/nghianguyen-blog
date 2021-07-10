package com.ntnghia.nghianguyenblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    @NotEmpty
    private String firstName;

    @Column
    @NotNull
    @NotEmpty
    private String lastName;

    @Column(unique = true)
    @NotNull
    @NotEmpty
    @Email
    private String email;

    @Column
    @NotNull
    @NotEmpty
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="role_id", nullable=false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Role role;
}
