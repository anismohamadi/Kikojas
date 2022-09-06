package krd.kurdestansoft.showin.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String Key;
    private  Object value;
    private SearchOperation operation;
}
