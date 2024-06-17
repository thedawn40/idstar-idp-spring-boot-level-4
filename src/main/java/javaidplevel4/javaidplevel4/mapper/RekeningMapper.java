package javaidplevel4.javaidplevel4.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel4.javaidplevel4.dto.RekeningDTO;
import javaidplevel4.javaidplevel4.model.Rekening;

@Mapper(componentModel = "spring")
public interface RekeningMapper {

    Rekening toEntity(RekeningDTO rekeningDTO);
    RekeningDTO toDTO(Rekening rekening);

    List<RekeningDTO> toListDTO(Page<Rekening> list);
} 
