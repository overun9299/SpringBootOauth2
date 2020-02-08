package soap.mapper;

import org.apache.ibatis.annotations.Param;
import soap.domain.AcPermission;
import soap.domain.AcPermissionExample;

import java.util.List;

public interface AcPermissionMapper {
    long countByExample(AcPermissionExample example);

    int deleteByExample(AcPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AcPermission record);

    int insertSelective(AcPermission record);

    List<AcPermission> selectByExample(AcPermissionExample example);

    AcPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AcPermission record, @Param("example") AcPermissionExample example);

    int updateByExample(@Param("record") AcPermission record, @Param("example") AcPermissionExample example);

    int updateByPrimaryKeySelective(AcPermission record);

    int updateByPrimaryKey(AcPermission record);
}
