package javaidplevel4.javaidplevel4.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel4.javaidplevel4.dto.TrainingDTO;
import javaidplevel4.javaidplevel4.model.Training;

@Mapper(componentModel = "spring")
public interface TrainingMapper {
    
    Training toEntity(TrainingDTO trainingDTO);

    TrainingDTO toDTO(Training training);

    List<TrainingDTO> toListDTO(Page<Training> training);

}
