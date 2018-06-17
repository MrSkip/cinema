//package com.countrycinema.ua.service.core.rest;
//
//import com.countrycinema.ua.dto.MessageDTO;
//import com.countrycinema.ua.dto.core.IdDTO;
//import com.countrycinema.ua.dto.user.UserResponseDTO;
//import com.countrycinema.ua.persistence.entity._core.id.IdComponent;
//import com.countrycinema.ua.persistence.repository._core.OptionalRepository;
//import com.countrycinema.ua.service.core.ServiceCoreImpl;
//import org.modelmapper.ModelMapper;
//
//import java.util.List;
//import java.util.Optional;
//
//@SuppressWarnings("all")
//public class RestServiceImpl<Request extends IdDTO, Response extends IdDTO, E extends IdComponent, ID>
//        extends ServiceCoreImpl<E, ID> implements RestService<Request, Response, ID> {
//
//    protected final ModelMapper modelMapper;
//
//    private Class<Request> requestClass;
//    private Class<Response> responseClass;
//    private Class<E> entityClass;
//
//    public RestServiceImpl(OptionalRepository<E, ID> repository,
//                           ModelMapper modelMapper) {
//        super(repository);
//        this.modelMapper = modelMapper;
//    }
//
//    @Override
//    public Response save(Request dto) {
//        E entity = modelMapper.map(dto, entityClass);
//        if (entity.getId() == null) {
//            repository.save(entity);
//        } else {
//            repository.findOne(entity.getId());
//        }
//        return modelMapper.map(entity, responseClass);
//    }
//
//    @Override
//    public Response findOne(ID id) {
//        E one = getOne(id);
//        return modelMapper.map(one, responseClass);
//    }
//
//    @Override
//    public MessageDTO delete(ID id) {
//        deleteOne(id);
//        return MessageDTO.of("Deleted successfully");
//    }
//
//    @Override
//    public List<Response> findAll() {
//        return null;
//    }
//}
