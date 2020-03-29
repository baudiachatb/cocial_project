package com.b.myproject.endpoint.controller.payload;

import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SearchParams {
    private List<Condition> conditions;
    private List<String> fields;
    private List<String> exFields;
    private SortField sortField;
    private int page;
    private int size;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
class SortField {
    private String field;
    private Boolean desc;
}
