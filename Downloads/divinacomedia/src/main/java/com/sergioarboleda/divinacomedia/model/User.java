/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sergioarboleda.divinacomedia.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author hldua
 */
@Data /*Me genera los Getter and Setter*/
@NoArgsConstructor/*Me crea el constructor vacio*/
@AllArgsConstructor/*Me crea los constructores con las propiedades*/
@Entity
@Table(name="user",indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable{/*Serializarse en JSON*/
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Autoincrementa el @Id*/
    private Integer id;
    @NonNull
    @Column(name="user_email", unique=true, length=50, nullable=false)
    private String email;
    @NonNull
    @Column(name="user_password", length=50, nullable=false)
    private String password;
    @NonNull
    @Column(name="user_name", length=80, nullable=false)
    private String name;
}
