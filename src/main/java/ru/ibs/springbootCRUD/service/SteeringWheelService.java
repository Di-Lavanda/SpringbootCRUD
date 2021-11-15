package ru.ibs.springbootCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.springbootCRUD.model.SteeringWheel;
import ru.ibs.springbootCRUD.repository.SteeringWheelRepository;

import java.util.List;

@Service
public class SteeringWheelService {

    private final SteeringWheelRepository steeringWheelRepository;

    @Autowired
    public SteeringWheelService(SteeringWheelRepository steeringWheelRepository){this.steeringWheelRepository = steeringWheelRepository;}
    public SteeringWheel findBuId(Long id){return steeringWheelRepository.getOne(id);}
    public List<SteeringWheel> findAll(){return steeringWheelRepository.findAll();}
    public SteeringWheel saveSteeringWheel(SteeringWheel steeringWheel){return steeringWheelRepository.save(steeringWheel);}
    public void deleteById(Long id){steeringWheelRepository.deleteById(id);}
}
