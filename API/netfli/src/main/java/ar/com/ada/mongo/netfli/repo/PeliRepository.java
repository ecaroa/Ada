package ar.com.ada.mongo.netfli.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.mongo.netfli.entities.Peli;

/**
 * PeliRepository
 */
@Repository
public interface PeliRepository extends MongoRepository<Peli, ObjectId>{
    Peli findBy_id(ObjectId _id); 
    Peli findByNombre(String nombre);

    
}