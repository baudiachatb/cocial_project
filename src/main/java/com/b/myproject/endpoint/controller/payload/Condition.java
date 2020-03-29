package com.b.myproject.endpoint.controller.payload;

import lombok.*;

//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
abstract class Condition {
    String key;
    Object value;
    ConditionType type;
}
