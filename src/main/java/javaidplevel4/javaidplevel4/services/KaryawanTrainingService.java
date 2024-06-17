package javaidplevel4.javaidplevel4.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javaidplevel4.javaidplevel4.dto.KaryawanTrainingDTO;
import javaidplevel4.javaidplevel4.mapper.KaryawanMapper;
import javaidplevel4.javaidplevel4.mapper.KaryawanTrainingMapper;
import javaidplevel4.javaidplevel4.model.Karyawan;
import javaidplevel4.javaidplevel4.model.KaryawanTraining;
import javaidplevel4.javaidplevel4.model.Training;
import javaidplevel4.javaidplevel4.repository.KaryawanRepository;
import javaidplevel4.javaidplevel4.repository.KaryawanTrainingRepository;
import javaidplevel4.javaidplevel4.repository.TrainingRepository;

@Service
public class KaryawanTrainingService {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    KaryawanTrainingRepository karyawanTrainingRepository;

    @Autowired
    KaryawanTrainingMapper karyawanTrainingMapper;

    @Autowired
    KaryawanMapper karyawanMapper;

    public List<KaryawanTrainingDTO> getAllKaryawanTraining(String page, String size) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
        Page<KaryawanTraining> findAll = karyawanTrainingRepository.findAllTraining(pageable);
        return karyawanTrainingMapper.toListDTO(findAll);
    }

    public KaryawanTrainingDTO getKaryawanTrainingById(long id) {
        KaryawanTraining training = karyawanTrainingRepository.findById(id).orElse(null);
        return karyawanTrainingMapper.toDTO(training);
    }

    public KaryawanTrainingDTO createKaryawanTraining(KaryawanTrainingDTO dto){
        KaryawanTraining karyawanTraining = karyawanTrainingMapper.toEntity(dto);
        KaryawanTraining savedTraining = karyawanTrainingRepository.save(karyawanTraining);
        Karyawan karyawan = karyawanRepository.getReferenceById(dto.getKaryawan().getId());
        Training training = trainingRepository.getReferenceById(dto.getTraining().getId());
        savedTraining.setKaryawan(karyawan);
        savedTraining.setTraining(training);
        return karyawanTrainingMapper.toDTO(savedTraining);
    }

    public KaryawanTrainingDTO updateKaryawanTraining(KaryawanTrainingDTO trainingDTO) {
        KaryawanTrainingDTO dto = getKaryawanTrainingById(trainingDTO.getId());
        KaryawanTraining karyawanTraining = karyawanTrainingMapper.toEntity(dto);
        karyawanTraining.setId(trainingDTO.getId());
        karyawanTraining.setTanggal(trainingDTO.getTanggal());
        KaryawanTraining updatedKaryawanTraining = karyawanTrainingRepository.save(karyawanTraining);
        Karyawan karyawan = karyawanRepository.getReferenceById(dto.getKaryawan().getId());
        Training training = trainingRepository.getReferenceById(dto.getTraining().getId());
        updatedKaryawanTraining.setKaryawan(karyawan);
        updatedKaryawanTraining.setTraining(training);
        return karyawanTrainingMapper.toDTO(updatedKaryawanTraining);
    }

    public KaryawanTrainingDTO deleteKaryawanTraining(KaryawanTrainingDTO trainingDTO) {
        KaryawanTrainingDTO dto = getKaryawanTrainingById(trainingDTO.getId());
        KaryawanTraining training = karyawanTrainingMapper.toEntity(dto);
        training.setId(trainingDTO.getId());
        training.setDeletedDate(LocalDateTime.now());
        KaryawanTraining updatedKaryawanTraining = karyawanTrainingRepository.save(training);
        return karyawanTrainingMapper.toDTO(updatedKaryawanTraining);
    }
}