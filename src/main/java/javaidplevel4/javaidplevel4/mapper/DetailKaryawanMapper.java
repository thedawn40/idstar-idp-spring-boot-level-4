package javaidplevel4.javaidplevel4.mapper;

import org.mapstruct.Mapper;

import javaidplevel4.javaidplevel4.dto.DetailKaryawanDTO;
import javaidplevel4.javaidplevel4.model.DetailKaryawan;

@Mapper(componentModel = "spring")
public interface DetailKaryawanMapper {
    
    // DetailKaryawanMapper INSTANCE = Mappers.getMapper(DetailKaryawanMapper.class);

    DetailKaryawanDTO detailKaryawanToDetailKaryawanDTO(DetailKaryawan detailKaryawan);
    DetailKaryawan detailKaryawanDTOToDetailKaryawan(DetailKaryawanDTO detailKaryawanDTO);
}
