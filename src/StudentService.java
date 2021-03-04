import req.StudentRequest;
import res.StudentDO;
import res.TableDTO;

/**
 * 查询接口
 */
public interface StudentService {
    TableDTO retrieveStudent(StudentRequest requst);//查询包含:当前第几页，// 每页查多少，查询词

    boolean add(StudentDO studentDO);

    StudentDO getByid(String selectedstudentsno);

    boolean update(StudentDO studentDO);


    boolean delete(String selectedstudentsno);
}
