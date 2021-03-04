import req.SearchRequest;
import req.TipsRequst;
import res.StuDTO;
import res.Stutips;
import res.TableDTO;
import res.TipsDTO;

public interface Studentsearch {
    //查询自己的成绩
    StuDTO Mysearch(SearchRequest searchRequest);
    //查看自己的排名
    int Mylocation(String a);
    //发送建议
    void assess(Stutips stutips);
    //查看建议
    TipsDTO seeTip(TipsRequst tipsRequst);

}
