package krd.kurdestansoft.showin.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PagingData<T>{
    private Integer totalPage;
    private Integer currenetPage;
    private List<T> data;
}
