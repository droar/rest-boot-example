package com.droar.restex_svc.entity.typemaster;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.droar.boot.fwk.base.entity.AbstractEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Its a not a bad practice to use a master table.
 * 
 * @author droar
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(schema = "public", name = "exm_type_masters")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "discriminator")
public class TypeMaster extends AbstractEntity {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 6158096912564091621L;


  /** The master id. */
  @Id
  @Column(name = "tms_id")
  @SequenceGenerator(name = "materKey_generator", sequenceName = "public.seq_mst_cod")
  @GeneratedValue(generator = "materKey_generator")
  @NotNull
  private Integer typeMasterId;

  /** The discriminator. */
  @Column(nullable = false, name = "tms_discriminator", insertable = false, updatable = false)
  @NotNull
  private Integer discriminator;


  /** The value. */
  @Column(name = "tms_value", nullable = false)
  @NotNull
  private String value;

  /** The description. */
  @Column(name = "tms_description", nullable = false)
  @NotNull
  private String description;
}
