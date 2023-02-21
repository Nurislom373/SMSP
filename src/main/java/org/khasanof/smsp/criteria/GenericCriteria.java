package org.khasanof.smsp.criteria;

import lombok.*;
import org.springframework.data.domain.Sort;

import java.util.Objects;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 2:59 PM
 * <br/>
 * Package: org.khasanof.smsp.criteria
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class GenericCriteria implements BaseCriteria {

    private Integer size;
    private Integer page;
    private Sort.Direction direction;

    public Integer getPage() {
        if (Objects.isNull(page))
            page = 0;
        return page;
    }

    public Integer getSize() {
        if (Objects.isNull(size))
            size = 10;
        return size;
    }

    public Sort.Direction getSort() {
        if (Objects.isNull(direction)) {
            direction = Sort.Direction.ASC;
        }
        return direction;
    }
}
