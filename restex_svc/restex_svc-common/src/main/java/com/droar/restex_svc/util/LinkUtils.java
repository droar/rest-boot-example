package com.droar.restex_svc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import com.droar.boot.fwk.base.model.OffsetBasedPageRequest;
import com.droar.boot.fwk.base.util.WebUtils;

/**
 * The Class Utils.
 *
 * @param <T> the generic type
 */
@Component
public class LinkUtils<T> {

  /** The Constant ID. */
  private static final String ID = "ID";

  /**
   * Gets the pagination links.
   *
   * @param pageable the pageable
   * @param lEntity the l entity
   * @param mpFilters the mp filters
   * @return the pagination links
   */
  public List<Link> getPaginationLinks(Pageable pageable, Page<T> lEntity, Map<String, Object> mpFilters) {
    // We get the base uri from the context
    UriComponentsBuilder baseUri = UriComponentsBuilder.fromUriString(WebUtils.getLocalContextPath());

    List<Link> links = new ArrayList<>();

    // self link
    Pageable pSelf = new OffsetBasedPageRequest(Math.toIntExact(pageable.getOffset()), pageable.getPageSize());
    UriComponentsBuilder selfBuilder = this.replacePageParams(baseUri, pSelf, mpFilters);
    links.add(Link.of(selfBuilder.toUriString()).withRel(IanaLinkRelations.SELF));

    // first link
    Pageable pFirst = new OffsetBasedPageRequest(0, pageable.getPageSize());
    UriComponentsBuilder firstBuilder = this.replacePageParams(baseUri, pFirst, mpFilters);
    links.add(Link.of(firstBuilder.toUriString()).withRel(IanaLinkRelations.FIRST));

    // next page
    if (lEntity.hasNext()) {
      UriComponentsBuilder nextBuilder = this.replacePageParams(baseUri, lEntity.nextPageable(), mpFilters);
      links.add(Link.of(nextBuilder.toUriString()).withRel(IanaLinkRelations.NEXT));
    }
    // prev page
    if (lEntity.hasPrevious()) {
      UriComponentsBuilder prevBuilder = this.replacePageParams(baseUri, lEntity.previousPageable(), mpFilters);
      links.add(Link.of(prevBuilder.toUriString()).withRel(IanaLinkRelations.PREVIOUS));
    }
    // last page
    Pageable pLast = PageRequest.of((int) (lEntity.getTotalElements() / pageable.getPageSize()), pageable.getPageSize());
    UriComponentsBuilder prevBuilderLast = this.replacePageParams(baseUri, pLast, mpFilters);
    links.add(Link.of(prevBuilderLast.toUriString()).withRel(IanaLinkRelations.LAST));

    return links;
  }


  /**
   * Replace page param for links
   * 
   * @param original
   * @param pageable
   * @param mpFilters
   * @return
   */
  private UriComponentsBuilder replacePageParams(UriComponentsBuilder original, Pageable pageable,
      Map<String, Object> mpFilters) {
    // We set params from links
    UriComponentsBuilder builder = original.cloneBuilder();

    if (mpFilters.get(ID) instanceof String) {
      builder.replaceQueryParam(ID, mpFilters.get(ID));
    }

    builder.replaceQueryParam("_offset", pageable.getOffset());
    builder.replaceQueryParam("_limit", pageable.getPageSize());
    return builder;
  }
}
