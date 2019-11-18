package soap.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import soap.domain.AcUserRole;
import soap.domain.AcUserRoleExample;

import java.util.List;

@Mapper
public interface AcUserRoleMapper {
    long countByExample(AcUserRoleExample example);

    int deleteByExample(AcUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcUserRole record);

    int insertSelective(AcUserRole record);

    List<AcUserRole> selectByExample(AcUserRoleExample example);

    AcUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcUserRole record, @Param("example") AcUserRoleExample example);

    int updateByExample(@Param("record") AcUserRole record, @Param("example") AcUserRoleExample example);

    int updateByPrimaryKeySelective(AcUserRole record);

    int updateByPrimaryKey(AcUserRole record);
}
