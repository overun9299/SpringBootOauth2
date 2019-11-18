package soap.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import soap.domain.AcRolePermission;
import soap.domain.AcRolePermissionExample;

import java.util.List;

@Mapper
public interface AcRolePermissionMapper {
    long countByExample(AcRolePermissionExample example);

    int deleteByExample(AcRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcRolePermission record);

    int insertSelective(AcRolePermission record);

    List<AcRolePermission> selectByExample(AcRolePermissionExample example);

    AcRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcRolePermission record, @Param("example") AcRolePermissionExample example);

    int updateByExample(@Param("record") AcRolePermission record, @Param("example") AcRolePermissionExample example);

    int updateByPrimaryKeySelective(AcRolePermission record);

    int updateByPrimaryKey(AcRolePermission record);
}
