package javaidplevel4.javaidplevel4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javaidplevel4.javaidplevel4.dto.KaryawanDTO;
import javaidplevel4.javaidplevel4.model.Karyawan;

/**
 * KaryawanMapper
 */
@Mapper(componentModel = "spring")
public interface KaryawanMapper {
    
    KaryawanMapper INSTANCE = Mappers.getMapper(KaryawanMapper.class);

    KaryawanDTO karyawanToKaryawanDTO(Karyawan karyawan);
    Karyawan karyawanDTOToKaryawan(KaryawanDTO karyawanDTO);
}