package com.droar.restex_svc.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.droar.boot.fwk.base.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Example user class
 * 
 * @author droar
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "exm_users")
public class User extends AbstractEntity {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 7057285610553691773L;

  @Id
  @Access(value = AccessType.PROPERTY)
  @Column(nullable = false, unique = true, name = "usr_id")
  @SequenceGenerator(name = "usrKey_generator", sequenceName = "public.seq_id_user", allocationSize = 1)
  @GeneratedValue(generator = "usrKey_generator", strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column(name = "usr_first_name")
  private String firstName;

  @Column(name = "usr_last_name")
  private String lastName;
  

  @Column(name = "usr_career")
  private String career;

}
