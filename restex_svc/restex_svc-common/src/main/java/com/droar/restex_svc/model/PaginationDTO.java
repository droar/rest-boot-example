package com.droar.restex_svc.model;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import com.droar.boot.fwk.base.model.EntityModelCustom;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new pagination bean.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationDTO<T> extends RepresentationModel<PaginationDTO<T>> {

  /** The limit. */
  @JsonProperty("_limit")
  private Integer limit;

  /** The offset. */
  @JsonProperty("_offset")
  private Integer offset;

  /** The count. */
  @JsonProperty("_count")
  private Long count;

  /** The embeddeds. */
  @JsonProperty("_embedded")
  private EntityModelCustom<EntityModel<T>> embedded;

}
