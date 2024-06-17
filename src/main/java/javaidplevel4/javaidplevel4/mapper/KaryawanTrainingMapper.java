package javaidplevel4.javaidplevel4.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel4.javaidplevel4.dto.KaryawanTrainingDTO;
import javaidplevel4.javaidplevel4.model.KaryawanTraining;

@Mapper(componentModel = "spring")
public interface KaryawanTrainingMapper {

    KaryawanTraining toEntity(KaryawanTrainingDTO karyawanTrainingDTO);

    KaryawanTrainingDTO toDTO(KaryawanTraining karyawanTraining);

    List<KaryawanTrainingDTO> toListDTO(Page<KaryawanTraining> karyawanTraining);
    
}
