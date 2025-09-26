package ch20.sec11;

import lombok.Data;
import java.util.Date;

@Data
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    // bfilename, bfiledata는 본 예제에서 생략한다
}
