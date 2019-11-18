package soap.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import soap.domain.AcRole;
import soap.domain.AcRoleExample;

import java.util.List;

@Mapper
public interface AcRoleMapper {
    long countByExample(AcRoleExample example);

    int deleteByExample(AcRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcRole record);

    int insertSelective(AcRole record);

    List<AcRole> selectByExample(AcRoleExample example);

    AcRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcRole record, @Param("example") AcRoleExample example);

    int updateByExample(@Param("record") AcRole record, @Param("example") AcRoleExample example);

    int updateByPrimaryKeySelective(AcRole record);

    int updateByPrimaryKey(AcRole record);
}
