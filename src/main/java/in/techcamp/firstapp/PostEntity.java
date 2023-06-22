package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PostEntity {
    private long id;
    private  String memo;
}
