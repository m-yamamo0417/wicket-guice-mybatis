package myamamo0417.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageMapper {

    void create();

    void drop();

    void insert(@Param("message") String message);

    List<String> selectAll();
}
